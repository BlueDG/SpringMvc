<%@ include file="/WEB-INF/init.jsp"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cr�ation d'utilisateur</title>
</head>
<body>

	<form:form modelAttribute="user">
		<a>Pr�nom : </a>
		<form:input path="
" size="15" maxlength="100" />
		<form:errors path="name" />
		<br />
		<a>Login : </a>
		<form:input path="login" size="15" maxlength="100" />
		<form:errors path="login" />
		<br />
		<a>Password : </a>
		<form:input path="password" size="15" maxlength="100" type="password" />
		<form:errors path="password" />

		<br />
		<input type="submit" value="Cr�er l'utilisateur" />
	</form:form>

</body>
</html>