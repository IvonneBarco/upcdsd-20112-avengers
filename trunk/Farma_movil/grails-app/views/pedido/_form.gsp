<%@ page import="farma_movil.Pedido" %>

<div class="fieldcontain ${hasErrors(bean: pedidoInstance, field: 'producto', 'error')} required">
	<label for="producto">
		<g:message code="pedido.producto.label" default="Producto" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="producto" name="producto.id" from="${farma_movil.Producto.list()}" optionKey="id" required="" value="${pedidoInstance?.producto?.code2}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pedidoInstance, field: 'cantidad', 'error')} required">
	<label for="cantidad">
		<g:message code="pedido.cantidad.label" default="Cantidad" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="cantidad" required="" value="${fieldValue(bean: pedidoInstance, field: 'cantidad')}"/>
	<g:hiddenField  type="number" name="estado" required="" value="1"/>
	<g:hiddenField name="usuario" value="$session.user"/>
</div>



