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
		<div class="divCentral divErro">
			<h1>Sessão expirada.</h1>
			<hr />
			<a href="${pageContext.request.contextPath}/index.xhtml">Sair</a>
		</div>
	</body>
</html>