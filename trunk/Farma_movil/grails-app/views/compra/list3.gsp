
<%@ page import="farma_movil.Compra" %>
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
					
			
				<th><g:message code="compra.producto.label" default="Producto" /></th>
			<g:sortableColumn property="cantidad" title="${message(code: 'compra.cantidad.label', default: 'Cantidad')}" />

<th>Precio</th>					

<th>Total</th>					
					
			
					</tr>
				</thead>
				<tbody>
				<g:each in="${compraInstanceList}" status="i" var="compraInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td>${fieldValue(bean: compraInstance, field: "producto")}</td>
						
						<td><g:link action="show" id="${compraInstance.id}">${fieldValue(bean: compraInstance, field: "cantidad")}</g:link></td>
					
					
						<td>100</td>
						
						<td><g:link action="show" id="${compraInstance.id}">${fieldValue(bean: compraInstance, field: "cantidad")}</g:link>00</td>					

					

					
					
				

				</g:each>

</tr>

<tr>
					
						<td> </td>
					
						<td></td>
						
						<td> Sub Total</td>
						
						<td> 700 </td>
					
					</tr>
				
				<tr>
					
						<td> </td>
					
						<td></td>
						
						<td> IGV</td>
						
						<td> 126 </td>
					
					</tr>
				<tr>
					
						<td> </td>
					
						<td></td>
						
						<td> Total Pago</td>
						
						<td> 826 </td>
					
					</tr>

					<tr>
					
						<td> </td>
					
						<td></td>
						
						<td> Descuento por puntos acumulados</td>
						
						<td> -100 </td>
					
					</tr>
					
					<tr>
					
						<td> </td>
					
						<td></td>
						
						<td> A pagar</td>
						
						<td> 726 </td>
					
					</tr>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${compraInstanceTotal}" />
			</div>
		</div>
		Si desea ver sus pedidos pendientes <a controller="pedido" href="list7"> aqui</a>.
	</body>
</html>
