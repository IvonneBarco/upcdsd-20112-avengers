<%@ page import="farmamovil.Producto" %>


<div class="fieldcontain ${hasErrors(bean: productoInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="producto.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${productoInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productoInstance, field: 'cantidad', 'error')} required">
	<label for="cantidad">
		<g:message code="producto.cantidad.label" default="Cantidad" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="cantidad" required="" value="${fieldValue(bean: productoInstance, field: 'cantidad')}"/>
</div>


