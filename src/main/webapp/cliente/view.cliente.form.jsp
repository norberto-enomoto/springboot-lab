<%--
    Document   : view.cliente.form
    Created on : 10/05/2018, 10:46:00
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
                <div class="col-md-10">
                    <h1>Form Cliente!</h1>
                    <hr>
                </div>
            </div>
            <div class="row">
                <div class="col-md-10">
                    <form:form method="post" modelAttribute="obj">
                        <c:if test="${not empty obj.id and obj.id ne null}">
                            <form:hidden path="id"/>
                        </c:if>
                        <div class="row">
                            <spring:bind path="razaoSocial"/>
                            <div class="col-md-4 form-group">
                                <form:label path="razaoSocial">* Razão Social / Nome</form:label>
                                <form:input path="razaoSocial" cssClass="form-control form-control-sm"
                                            cssErrorClass="form-control form-control-sm error"/>
                                <form:errors path="razaoSocial" cssClass="text-danger" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <form:label path="nomeFantasia">Nome Fantasia</form:label>
                                <form:input path="nomeFantasia" cssClass="form-control form-control-sm"/>
                                <form:errors path="nomeFantasia" cssClass="text-danger"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <form:label path="credito">Crédito</form:label>
                                <form:input path="credito" cssClass="form-control form-control-sm"/>
                                <form:errors path="credito" cssClass="text-danger"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-2 form-group">
                                <button type="submit" class="btn btn-secondary">Salvar</button>
                            </div>
                            <div class="col-md-2 form-group">
                                <a href="${pageContext.request.contextPath}/cliente"
                                   class="btn btn-secondary">
                                    Voltar
                                </a>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../commons/footer.jsp" %>
