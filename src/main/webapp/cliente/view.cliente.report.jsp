<%--
    Document   : view.cliente.report
    Created on : 19/05/2018, 11:04:57
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
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-12">
                    <h1>Cliente index!</h1>
                    <hr>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form method="post">
                        <select name="tipoArquivo">
                            <c:forEach items="${filetype}" var="filetype">
                                <option value="${filetype.key}">${filetype.value}</option>
                            </c:forEach>
                        </select>
                        <input type="submit" name="acao" value="export">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../commons/footer.jsp" %>
