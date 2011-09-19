<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Condominios BMP Ingenieros</title>
		<style type="text/css" media="screen">

        #nav {
            margin-top:0px;
            margin-left:15px;
            width:228px;
            float:left;

        }
        .homePagePanel * {
            margin:0px;
        }
        .homePagePanel .panelBody ul {
            list-style-type:none;
            margin-bottom:10px;
        }
        .homePagePanel .panelBody h1 {
            text-transform:uppercase;
            font-size:1.1em;
            margin-bottom:10px;
        }
        .homePagePanel .panelBody {
            background: url(images/leftnav_midstretch.png) repeat-y top;
            margin:0px;
            padding:15px;
        }
        .homePagePanel .panelBtm {
            background: url(images/leftnav_btm.png) no-repeat top;
            height:20px;
            margin:0px;
        }

        .homePagePanel .panelTop {
            background: url(images/leftnav_top.png) no-repeat top;
            height:11px;
            margin:0px;
        }
        h2 {
            margin-top:0px;
            margin-bottom:15px;
            font-size:1.2em;
        }
        #pageBody {
            margin-left:200px;
            margin-right:20px;
        }
        </style>
	</head>
	
	<body style="background-color: transparent;" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
        <div id="nav">
		<div id="grailsLogo"><center><img src="${resource(dir:'images',file:'farmacia_logo.png')}" alt="Farmacia" border="0" /> </center></div>
           
            <div class="homePagePanel">
                <div class="panelTop"> </div>
                <div class="panelBody">
                 <h2>Mantenimientos:</h2>
                 <br>
                
                <ul>					
					<li class="controller"><g:link controller="producto" style="text-transform:capitalize" target="interno">Productos</g:link></li>
					<li class="controller"><g:link controller="unidadMedida" style="text-transform:capitalize" target="interno">Unidad de Medida</g:link></li>
					<li class="controller"><g:link controller="user" style="text-transform:capitalize" target="interno">Usuario</g:link></li>
					<li class="controller"><g:link controller="pedido" action="create" style="text-transform:capitalize" target="interno">Comprar</g:link></li>
					<li class="controller"><g:link controller="compra" action="list" style="text-transform:capitalize" target="interno">Lista pedidos</g:link></li>
					<li class="controller"><g:link controller="compra" action="list1" style="text-transform:capitalize" target="interno">Pendiente despacho</g:link></li>
					<li class="controller"><g:link controller="compra" action="list2" style="text-transform:capitalize" target="interno">Entregas</g:link></li>
				</ul>
                </div>
                <div class="panelBtm"></div>
            </div>
        </div>
        <div id="pageBody">            
            <div id="controllerList" class="dialog"></div>
        </div>
    </body>
	
	
</html>