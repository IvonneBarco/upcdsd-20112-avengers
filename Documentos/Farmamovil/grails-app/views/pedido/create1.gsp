
<%@ page import="farmamovil.Pedido" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pedido.label', default: 'Pedido')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div id="list-pedido" class="content scaffold-list" role="main">
			<p> </p>
			
			<table>
				<thead>
					<tr>
					
						<th><g:message code="pedido.producto.label" default="Producto" /></th>
					
						<g:sortableColumn property="cantidad" title="${message(code: 'pedido.cantidad.label', default: 'Cantidad')}" />
					
						<g:sortableColumn property="estado" title="${message(code: 'pedido.estado.label', default: 'Estado')}" />

						<g:sortableColumn property="usuario" title="${message(code: 'pedido.usuario.label', default: 'Usuario')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${pedidoInstanceList}" status="i" var="pedidoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${fieldValue(bean: pedidoInstance, field: "producto")}</td>
					
						<td><g:link action="edit" id="${pedidoInstance.id}">${fieldValue(bean: pedidoInstance, field: "cantidad")}</g:link></td>
					
						<td>${fieldValue(bean: pedidoInstance, field: "estado")}</td>
					
					
					
						<td>${fieldValue(bean: pedidoInstance, field: "usuario")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>		
			<div class="pagination">
				<g:paginate total="${pedidoInstanceTotal}" />
			</div>
			
			<g:form action="create1" >
				<fieldset class="buttons">
					<g:submitButton name="create1" class="save" value="Comprar" />
				</fieldset>
			</g:form>
			
		</div>
	</body>
</html>
