package farma_movil

class CompraController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = { 
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		
		//def b = Compra.findAllByUsuario(String.valueOf(session.user))		
		
		def b = Compra.findAllByUsuario(String.valueOf(session.user))		
			
		[compraInstanceList: b, compraInstanceTotal: b.size()]		
    }
	
	def list1 = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		def b = Compra.findAllByEstado("1")
		
		[compraInstanceList: b, compraInstanceTotal: b.size()]
		
	}
	
	def list2 = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		def b = Compra.findAllByEstado("1")
		
		[compraInstanceList: b, compraInstanceTotal: b.size()]
		
	}

	def list3 = {
	

		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		def b = Compra.findAllByPedido("1")
		
		[compraInstanceList: b, compraInstanceTotal: b.size()]
		
	}

		def list5 = {
	
	withHttp(uri: "http://localhost:8082") {
		   def html = get(path : '/wsfarma/rest/clienteRest/listar/'+session.user)
		   render html 
		   
		  
		}
 
	[compraInstanceList: html, compraInstanceTotal: html.size()]
	}

	
    def create = {
        def compraInstance = new Compra()
        compraInstance.properties = params
        return [compraInstance: compraInstance]
    }

	def create1 = {

	def c11 =params["c1"] 


		def compraInstance = Compra.findById(c11)
		
		compraInstance.estado = 2
		
        print compraInstance
		
		redirect(action: "list2")
		
    }
	
    def save = {
        def compraInstance = new Compra(params)
        if (compraInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'compra.label', default: 'Compra'), compraInstance.id])}"
            redirect(action: "show", id: compraInstance.id)
        }
        else {
            render(view: "create", model: [compraInstance: compraInstance])
        }
    }
	
	def save1 = {	
        def compraInstance = new Compra(paramets)
        flash.message = message(code: 'default.created.message', args: [message(code: 'compra.label', default: 'Compra'), compraInstance.id])
    }

    def show = {
        def compraInstance = Compra.get(params.id)
        if (!compraInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'compra.label', default: 'Compra'), params.id])}"
            redirect(action: "list")
        }
        else {
            [compraInstance: compraInstance]
        }
    }

    def edit = {
        def compraInstance = Compra.get(params.id)
        if (!compraInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'compra.label', default: 'Compra'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [compraInstance: compraInstance]
        }
    }

    def update = {
        def compraInstance = Compra.get(params.id)
        if (compraInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (compraInstance.version > version) {
                    
                    compraInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'compra.label', default: 'Compra')] as Object[], "Another user has updated this Compra while you were editing")
                    render(view: "edit", model: [compraInstance: compraInstance])
                    return
                }
            }
            compraInstance.properties = params
            if (!compraInstance.hasErrors() && compraInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'compra.label', default: 'Compra'), compraInstance.id])}"
                redirect(action: "show", id: compraInstance.id)
            }
            else {
                render(view: "edit", model: [compraInstance: compraInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'compra.label', default: 'Compra'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def compraInstance = Compra.get(params.id)
        if (compraInstance) {
            try {
                compraInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'compra.label', default: 'Compra'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'compra.label', default: 'Compra'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'compra.label', default: 'Compra'), params.id])}"
            redirect(action: "list")
        }
    }
}
