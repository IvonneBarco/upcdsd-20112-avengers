<%@ page import="farmamovil.Compra" %>



<div class="fieldcontain ${hasErrors(bean: compraInstance, field: 'cantidad', 'error')} required">
	<label for="cantidad">
		<g:message code="compra.cantidad.label" default="Cantidad" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="cantidad" required="" value="${fieldValue(bean: compraInstance, field: 'cantidad')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: compraInstance, field: 'estado', 'error')} required">
	<label for="estado">
		<g:message code="compra.estado.label" default="Estado" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="estado" required="" value="${fieldValue(bean: compraInstance, field: 'estado')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: compraInstance, field: 'pedido', 'error')} required">
	<label for="pedido">
		<g:message code="compra.pedido.label" default="Pedido" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="pedido" required="" value="${fieldValue(bean: compraInstance, field: 'pedido')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: compraInstance, field: 'producto', 'error')} required">
	<label for="producto">
		<g:message code="compra.producto.label" default="Producto" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="producto" name="producto.id" from="${farmamovil.Producto.list()}" optionKey="id" required="" value="${compraInstance?.producto?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: compraInstance, field: 'usuario', 'error')} ">
	<label for="usuario">
		<g:message code="compra.usuario.label" default="Usuario" />
		
	</label>
	<g:textField name="usuario" value="${compraInstance?.usuario}"/>
</div>

