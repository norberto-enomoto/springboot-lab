<%--
    Document   : form
    Created on : 10/05/2018, 10:46:00
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form Cliente!</h1>
        <form method="post">
            <input name="id" value="${obj.id}">
            <input name="razaoSocial" value="${obj.razaoSocial}">
            <button type="submit">Salvar</button>
        </form>
    </body>
</html>
