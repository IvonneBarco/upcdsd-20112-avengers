
<%@ page import="farma_movil.Pedido" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pedido.label', default: 'Pedido')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<h1>Pedidos pendientes del usuario</h1>
		<div id="list-pedido" class="content scaffold-list" role="main">
			<p> </p>
			
			
			<table>
				<thead>
					<tr>
					
						<th>Usuario</th>
					
						<th>Numero Pedido</th>
						
						<th>Estado</th>
						
										
					</tr>
				</thead>
				<tbody>
				<%
						int a=0
						int b=0
						%>
				<g:each in="${pedidoInstanceList}" status="i" var="pedidoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
					
					
						<td>${fieldValue(bean: pedidoInstance, field: "usuario")}</td>
						
						<td>${fieldValue(bean: pedidoInstance, field: "pedido")}</td>
										
						<td>${fieldValue(bean: pedidoInstance, field: "estado")}</td>
					
					</tr>
				</g:each>
				
				
				
				</tbody>
			</table>		
			<div class="pagination">
				<g:paginate total="${pedidoInstanceTotal}" />
			</div>
			
						
		</div>
	</body>
</html>
