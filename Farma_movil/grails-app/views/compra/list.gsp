
<%@ page import="farma_movil.Compra" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'compra.label', default: 'Compra')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'compra.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="cantidad" title="${message(code: 'compra.cantidad.label', default: 'Cantidad')}" />
                        
                            <g:sortableColumn property="estado" title="${message(code: 'compra.estado.label', default: 'Estado')}" />
                        
                            <g:sortableColumn property="pedido" title="${message(code: 'compra.pedido.label', default: 'Pedido')}" />
                        
                            <th><g:message code="compra.producto.label" default="Producto" /></th>
                        
                            <g:sortableColumn property="usuario" title="${message(code: 'compra.usuario.label', default: 'Usuario')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${compraInstanceList}" status="i" var="compraInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${compraInstance.id}">${fieldValue(bean: compraInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: compraInstance, field: "cantidad")}</td>
                        
                            <td>${fieldValue(bean: compraInstance, field: "estado")}</td>
                        
                            <td>${fieldValue(bean: compraInstance, field: "pedido")}</td>
                        
                            <td>${fieldValue(bean: compraInstance, field: "producto")}</td>
                        
                            <td>${fieldValue(bean: compraInstance, field: "usuario")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${compraInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
