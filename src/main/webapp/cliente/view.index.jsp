<%--
    Document   : index
    Created on : 09/05/2018, 12:39:25
    Author     : lucas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cliente index!</h1>
        <hr>
        <a href="cliente/form">Novo</a><br><br>
        <table>
            <tr>
                <td style="border: 1px solid activecaption;">#</td>
                <td>Razão/Fantasia</td>
                <td>Telefone</td>
                <td>Crédito</td>
                <td>Ações</td>
            </tr>
            <c:forEach var="obj" items="${list}">
            <tr>
                <td>${obj.id}</td>
                <td>${obj.razaoSocial}/${obj.nomeFantasia}</td>
                <td>(##)#####-####</td>
                <td>${obj.credito}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/cliente/${obj.id}">Editar</a>
                    <a href="${pageContext.request.contextPath}/cliente/deletar/${obj.id}">Deletar</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
