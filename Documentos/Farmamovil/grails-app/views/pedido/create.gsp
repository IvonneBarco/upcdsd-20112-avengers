<%@ page import="farmamovil.Pedido" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pedido.label', default: 'Pedido')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div id="create-pedido" class="content scaffold-create" role="main">
			<h1> Pedido </h1>
			
			<g:hasErrors bean="${pedidoInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${pedidoInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Agregar" />
				</fieldset>
			</g:form>
			
			<g:include controller="pedido" action="list" />
			
		</div>
	</body>
</html>
