
<%@ page import="farmamovil.Compra" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'compra.label', default: 'Compra')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>

		<div id="list-compra" class="content scaffold-list" role="main">
			<h1>Pedidos Entrega</h1>
			
			
			
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="usuario" title="${message(code: 'compra.usuario.label', default: 'Usuario')}" />
					
						<th><g:message code="compra.producto.label" default="Producto" /></th>
					
						<g:sortableColumn property="cantidad" title="${message(code: 'compra.cantidad.label', default: 'Cantidad')}" />
						
						<th>Entregado</th>
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${compraInstanceList}" status="i" var="compraInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					<td>${fieldValue(bean: compraInstance, field: "usuario")}</td>
					<td>${fieldValue(bean: compraInstance, field: "producto")}</td>
					<td>${fieldValue(bean: compraInstance, field: "cantidad")}</td>
					
						
					<td>	
					<fieldset class="buttons">
					<g:link class="save" controller="compra" action="create1" params="[c1:compraInstance.id]" name="entregar" value="Entregar" /> Entrega
					
						</fieldset>
					
					</td>	
					
						
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${compraInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
