<%@ page import="farmamovil.UnidadMedida" %>



<div class="fieldcontain ${hasErrors(bean: unidadMedidaInstance, field: 'unidad', 'error')} ">
	<label for="unidad">
		<g:message code="unidadMedida.unidad.label" default="Unidad" />
		
	</label>
	<g:textField name="unidad" value="${unidadMedidaInstance?.unidad}"/>
</div>

