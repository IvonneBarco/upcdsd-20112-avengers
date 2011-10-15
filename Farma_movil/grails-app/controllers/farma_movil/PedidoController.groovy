package farma_movil
import static groovyx.net.http.ContentType.*

class PedidoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def beforeInterceptor = [action:this.&checkUser,except:
['index','list','show']]

def checkUser() {
if(!session.user) {
// i.e. user not logged in
redirect(controller:'user',action:'login')
return false
}
}
	
    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [pedidoInstanceList: Pedido.list(params), pedidoInstanceTotal: Pedido.count()]
    }
	
	def list1 = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		
		[pedidoInstanceList: Pedido.list(params), pedidoInstanceTotal: Pedido.count()]

	}
	
	def list2 = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		
		
		def html
		
			withHttp(uri: "http://localhost:8082") {
		    html = get(path : '/wsfarma/rest/clienteRest/listar/'+session.user)
		   }
		   Pedido1.executeUpdate("delete Pedido1")
		   html.each {
			print it.numero
			def event10 = new Pedido1(pedido:it.numero,usuario:session.user,estado:it.estado).save()									 			 
		   }
		
		[pedidoInstanceList: Pedido1.list(params), pedidoInstanceTotal: Pedido1.count()]

	}
    def create = {
        def pedidoInstance = new Pedido()
        pedidoInstance.properties = params
		
        return [pedidoInstance: pedidoInstance]
    }

	def create1 = {
        def all = Pedido.findAll()
		
		def results = 	Compra.withCriteria {
						projections {
						count 'pedido'
						}
						} 
		
		if (results==[0])
		results = 1
		else
		{
		def results1 = 	Compra.createCriteria()
		def pedido3 = results1.get {
							
						projections {
						max("pedido")
						}
						} 
			results = pedido3+1
		}
		 
		all.each {

			def paramets = [estado:it.estado,usuario:it.usuario,cantidad:it.cantidad,pedido:1,create:"Create","producto.id":it.producto.id,
						producto:"[id:"+it.producto.id+"]", action:"save", controller:"compra"]
			
			def prod = new Producto (id:it.producto.id)
			def event10 = new Compra(estado:it.estado,usuario:it.usuario,cantidad:it.cantidad,pedido:results,producto:prod,"producto.id":it.producto.id).save()									 			 
			
			}
			
		def pedi=0	
		withHttp(uri: "http://localhost:8082") {
		   def num = get(path : '/wsfarma/rest/clienteRest/obtieneNumero')
		   
		   pedi= num.numero+1
		}
		
		
		
		withHttp(uri: "http://localhost:8082/wsfarma/rest/clienteRest/pedido") {
		 
		
        def bodyContent = [
            numero: pedi,
			dniCliente: session.user,			
			estado : 0 
        ]

        def json = post(body: bodyContent, requestContentType: JSON)
		def json1 
        if (json.success == true) { 		  
		  
		  withHttp(uri: "http://localhost:8082/wsfarma/rest/clienteRest/detallepedido") {
			
			 
			all.each {
				def pruebaa = Producto.findById(it.producto.id)

				
				def bodydetailContent =	[	 
					numeroPedido: pedi,
					codigoProducto: pruebaa.code2,
					cantidad: it.cantidad
					]
				
				json1 = post(body: bodydetailContent, requestContentType: JSON)
				
				 
			} 
			
			if (json1.success == true) {
			redirect(controller:"compra",action: "list3") }
			}
        }
		else
		{
		render(view: "create")
		}
		}
		
		
		
		
		///////////////////////////////////////////////////////////////////////////////////////				

		Pedido.executeUpdate("delete Pedido")
			
	}
	
    def save = {
        def pedidoInstance = new Pedido(params)
		print pedidoInstance.list()
        if (pedidoInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'pedido.label', default: 'Pedido'), pedidoInstance.id])}"
            redirect(action: "create", id: pedidoInstance.id)
        }
        else {
            render(view: "create", model: [pedidoInstance: pedidoInstance])
        }
    }

    def show = {
        def pedidoInstance = Pedido.get(params.id)
        if (!pedidoInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])}"
            redirect(action: "list")
        }
        else {
            [pedidoInstance: pedidoInstance]
        }
    }

    def edit = {
        def pedidoInstance = Pedido.get(params.id)
        if (!pedidoInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [pedidoInstance: pedidoInstance]
        }
    }

    def update = {
        def pedidoInstance = Pedido.get(params.id)
        if (pedidoInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (pedidoInstance.version > version) {
                    
                    pedidoInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'pedido.label', default: 'Pedido')] as Object[], "Another user has updated this Pedido while you were editing")
                    render(view: "edit", model: [pedidoInstance: pedidoInstance])
                    return
                }
            }
            pedidoInstance.properties = params
            if (!pedidoInstance.hasErrors() && pedidoInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'pedido.label', default: 'Pedido'), pedidoInstance.id])}"
                redirect(action: "show", id: pedidoInstance.id)
            }
            else {
                render(view: "edit", model: [pedidoInstance: pedidoInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def pedidoInstance = Pedido.get(params.id)
        if (pedidoInstance) {
            try {
                pedidoInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])}"
            redirect(action: "list")
        }
    }
}
