<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
    	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    	<meta http-equiv="Content-Type" content="text/html;CHARSET=ISO-8859-1" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jsfimages.css" type="text/css" />
		<style>
			.button-light-blue {background:url('${pageContext.request.contextPath}/resources/images/btn-light-blue.gif')}
		</style>
	</head>
	<body>
		<form method="post" action="j_security_check">
			<div id="wrapperForm">
				<div id="divLogoTodo" align="right">
					<img src="${pageContext.request.contextPath}/resources/images/logo-todo.png" />
				</div>
				<hr  style="width: 96%; margin-bottom: 25px;" />
				<div id="divLogoVivo">
					<img src="${pageContext.request.contextPath}/resources/images/logo-vivo.png" />
				</div>
				<div style="float:right; position:relative; top:-150px;">
					<table>
						<tr>
							<td>Login:</td>
							<td><input type="text" name="j_username" class="login" /></td>
						</tr>
						<tr>
							<td>Senha:</td>
							<td><input type="password" name="j_password" class="login" /></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="Logar" class="button-light-blue" style="float:right;" />
							</td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: right; color: #FF0000;">
								${param["msgErroLogin"]}
							</td>
						</tr>
					</table>
				</div>
			</div>
		</form>
	</body>
</html>