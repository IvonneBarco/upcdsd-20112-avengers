<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main" />
<title>User Login</title>
</head>
<body>
<div class="body">
<g:form action="doLogin" method="post">
<div class="dialog">
<p>Ingrese sus datos:</p>
<table class="userForm">
<tr class='prop'>
<td valign='top' style='text-align:left;' width='20%'>
<label for='dni'>DNI:</label>
</td>
<td valign='top' style='text-align:left;' width='80%'>
<input id="dni" type='text' name='dni' value='${user?.dni}' />
</td>
</tr>
<tr class='prop'>
<td valign='top' style='text-align:left;' width='20%'>
<label for='password'>Password:</label>
</td>
<td valign='top' style='text-align:left;' width='80%'>
<input id="password" type='password' name='password'
value='${user?.password}' />
</td>
</tr>
</table>
</div>
<div class="buttons">
<span class="formButton">
<input type="submit" value="Login"></input><br>


</span>
</div>
</g:form>
Si es un usuario nuevo ingrese <a href="create"> aqui</a>.
</div>


</body>
</html>