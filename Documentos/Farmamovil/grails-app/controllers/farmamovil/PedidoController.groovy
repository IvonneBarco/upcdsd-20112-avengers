package farmamovil

import grails.converters.JSON
import farmamovil.CompraController

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

def doLogin = {
def user = User.findWhere(email:params['email'],
password:params['password'])
session.user = user
if (user)
redirect(controller:'pedido',action:'list')
else
redirect(controller:'user',action:'login')
}
	
    def index = {
        redirect(action: "list", params: params)
    }

	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		
		[pedidoInstanceList: Pedido.list(params), pedidoInstanceTotal: Pedido.count()]

		}

    def create = {
        def pedidoInstance = new Pedido()
        pedidoInstance.properties = params
        return [pedidoInstance: pedidoInstance]
    }
	
	def list1 = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		
		[pedidoInstanceList: Pedido.list(params), pedidoInstanceTotal: Pedido.count()]

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
			//pedido3=pedido3+1
			results = pedido3+1
		}
		
		
		
		all.each { 			
						
			def paramets = [estado:it.estado,usuario:it.usuario,cantidad:it.cantidad,pedido:1,create:"Create","producto.id":it.producto.id,
						producto:"[id:"+it.producto.id+"]", action:"save", controller:"compra"]
			
			def prod = new Producto (id:it.producto.id)
			def event10 = new Compra(estado:it.estado,usuario:it.usuario,cantidad:it.cantidad,pedido:results,producto:prod,"producto.id":it.producto.id).save()									 			 
			
			}

		redirect(action: "list1")
			
	}
	
    

    def save = {		
        def pedidoInstance = new Pedido(params)
        if (pedidoInstance.save(flush: true)) {
            flash.message = message(code: 'default.created.message', args: [message(code: 'pedido.label', default: 'Pedido'), pedidoInstance.id])
            redirect(action: "create", id: pedidoInstance.id)
        }
        else {
            render(view: "create", model: [pedidoInstance: pedidoInstance])
        }
    }

    def show = {
        def pedidoInstance = Pedido.get(params.id)
        if (!pedidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])
            redirect(action: "edit")
        }
        else {
            [pedidoInstance: pedidoInstance]
			redirect(action: "edit")
        }
    }

    def edit = {
        def pedidoInstance = Pedido.get(params.id)
        if (!pedidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])
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
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pedido.label', default: 'Pedido'), pedidoInstance.id])
                redirect(action: "create", id: pedidoInstance.id)
            }
            else {
                render(view: "edit", model: [pedidoInstance: pedidoInstance])
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])
            redirect(action: "list")
        }
    }

    def delete = {
        def pedidoInstance = Pedido.get(params.id)
        if (pedidoInstance) {
            try {
                pedidoInstance.delete(flush: true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])
                redirect(action: "create")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])
                redirect(action: "create", id: params.id)
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])
            redirect(action: "list")
        }
    }
}
