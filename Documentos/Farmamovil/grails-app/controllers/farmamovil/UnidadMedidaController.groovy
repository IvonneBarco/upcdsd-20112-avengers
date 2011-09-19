package farmamovil

import grails.converters.JSON

class UnidadMedidaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[unidadMedidaInstanceList: UnidadMedida.list(params), unidadMedidaInstanceTotal: UnidadMedida.count()]
	}

    def create = {
        def unidadMedidaInstance = new UnidadMedida()
        unidadMedidaInstance.properties = params
        return [unidadMedidaInstance: unidadMedidaInstance]
    }

    def save = {
        def unidadMedidaInstance = new UnidadMedida(params)
        if (unidadMedidaInstance.save(flush: true)) {
            flash.message = message(code: 'default.created.message', args: [message(code: 'unidadMedida.label', default: 'UnidadMedida'), unidadMedidaInstance.id])
            redirect(action: "show", id: unidadMedidaInstance.id)
        }
        else {
            render(view: "create", model: [unidadMedidaInstance: unidadMedidaInstance])
        }
    }

    def show = {
        def unidadMedidaInstance = UnidadMedida.get(params.id)
        if (!unidadMedidaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'unidadMedida.label', default: 'UnidadMedida'), params.id])
            redirect(action: "list")
        }
        else {
            [unidadMedidaInstance: unidadMedidaInstance]
        }
    }

    def edit = {
        def unidadMedidaInstance = UnidadMedida.get(params.id)
        if (!unidadMedidaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'unidadMedida.label', default: 'UnidadMedida'), params.id])
            redirect(action: "list")
        }
        else {
            return [unidadMedidaInstance: unidadMedidaInstance]
        }
    }

    def update = {
        def unidadMedidaInstance = UnidadMedida.get(params.id)
        if (unidadMedidaInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (unidadMedidaInstance.version > version) {
                    
                    unidadMedidaInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'unidadMedida.label', default: 'UnidadMedida')] as Object[], "Another user has updated this UnidadMedida while you were editing")
                    render(view: "edit", model: [unidadMedidaInstance: unidadMedidaInstance])
                    return
                }
            }
            unidadMedidaInstance.properties = params
            if (!unidadMedidaInstance.hasErrors() && unidadMedidaInstance.save(flush: true)) {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'unidadMedida.label', default: 'UnidadMedida'), unidadMedidaInstance.id])
                redirect(action: "show", id: unidadMedidaInstance.id)
            }
            else {
                render(view: "edit", model: [unidadMedidaInstance: unidadMedidaInstance])
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'unidadMedida.label', default: 'UnidadMedida'), params.id])
            redirect(action: "list")
        }
    }

    def delete = {
        def unidadMedidaInstance = UnidadMedida.get(params.id)
        if (unidadMedidaInstance) {
            try {
                unidadMedidaInstance.delete(flush: true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'unidadMedida.label', default: 'UnidadMedida'), params.id])
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'unidadMedida.label', default: 'UnidadMedida'), params.id])
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'unidadMedida.label', default: 'UnidadMedida'), params.id])
            redirect(action: "list")
        }
    }
}
