<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Création d'utilisateur</title>
</head>
<body>

    <form:form modelAttribute="user">
        <a>Prénom : </a>
        <form:input path="name" size="15" maxlength="100" />
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
        <input type="submit" value="Créer l'utilisateur" />
    </form:form>

</body>
</html>