
<%@ page import="farma_movil.UnidadMedida" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'unidadMedida.label', default: 'UnidadMedida')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'unidadMedida.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="unidad" title="${message(code: 'unidadMedida.unidad.label', default: 'Unidad')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${unidadMedidaInstanceList}" status="i" var="unidadMedidaInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${unidadMedidaInstance.id}">${fieldValue(bean: unidadMedidaInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: unidadMedidaInstance, field: "unidad")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${unidadMedidaInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
