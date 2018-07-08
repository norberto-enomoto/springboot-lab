<%--
    Document   : index
    Created on : 12/05/2018, 12:50:11
    Author     : lucas
--%>

<%@ include file="../commons/open_header.jsp" %>

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

<%@ include file="../commons/close_header.jsp" %>

<h1>Spring Boot Lab!</h1>

<%@include file="../commons/footer.jsp" %>