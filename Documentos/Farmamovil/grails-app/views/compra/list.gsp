
<%@ page import="farmamovil.Compra" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'compra.label', default: 'Compra')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		
		
			<h1>Pedidos por usuario</h1>
			
			<table>
				<thead>
					<tr>
					
			<g:sortableColumn property="pedido" title="${message(code: 'compra.pedido.label', default: 'Pedido')}" />
				<th><g:message code="compra.producto.label" default="Producto" /></th>
			<g:sortableColumn property="cantidad" title="${message(code: 'compra.cantidad.label', default: 'Cantidad')}" />
					
					
			
					</tr>
				</thead>
				<tbody>
				<g:each in="${compraInstanceList}" status="i" var="compraInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>${fieldValue(bean: compraInstance, field: "pedido")}</td>

						<td>${fieldValue(bean: compraInstance, field: "producto")}</td>
						
						<td><g:link action="show" id="${compraInstance.id}">${fieldValue(bean: compraInstance, field: "cantidad")}</g:link></td>
					
						
					

					

					
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
