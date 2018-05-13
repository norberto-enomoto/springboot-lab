<%--
    Document   : header
    Created on : 12/05/2018, 12:45:54
    Author     : lucas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.0/css/bootstrap.css"/>
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.3.1/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>

        <!-- Custom scripts JS -->
        <%--<c:if test="${not empty $js and $js ne null}">
            <c:forEach items="${js}" var="js">
                <script src="${pageContext.request.contextPath}/${js}"></script>
            </c:forEach>
        </c:if>--%>

        <!-- Custom scripts CSS -->
        <%--<c:if test="${not empty $css and $css ne null}">
            <c:forEach items="${css}" var="css">
                <script src="${pageContext.request.contextPath}/${css}"></script>
            </c:forEach>
        </c:if>--%>


        <!-- Webjars minified -->
        <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.3.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>--%>
        <title>SpringBoot Lab</title>
    </head>
    <body>

<!-- https://pt.stackoverflow.com/questions/1109/onde-devo-colocar-um-c%C3%B3digo-javascript-em-um-documento-html -->