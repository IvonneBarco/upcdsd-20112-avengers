
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
						
						<th>Precio Unitario</th>
						
						<th>Total</th>
										
					</tr>
				</thead>
				<tbody>
				<%
						int a=0
						int b=0
						%>
				<g:each in="${pedidoInstanceList}" status="i" var="pedidoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
					
					
						<td>${fieldValue(bean: pedidoInstance, field: "producto")}</td>
						
						<td>${fieldValue(bean: pedidoInstance, field: "cantidad")}</td>
						
						<td>100.00</td>
						
						<td>${fieldValue(bean: pedidoInstance, field: "cantidad")}00</td>
					
					</tr>
				</g:each>
				
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
						
						<td> Descuento</td>
						
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
				<g:paginate total="${pedidoInstanceTotal}" />
			</div>
			
						
		</div>
	</body>
</html>
