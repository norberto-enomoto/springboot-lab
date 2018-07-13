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
                    <form method="post">
                        <c:if test="${not empty obj.id and obj.id ne null}">
                            <input name="id" type="hidden" value="${obj.id}">
                        </c:if>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <label>* Razão Social / Nome</label>
                                <input name="razaoSocial" value="${obj.razaoSocial}"
                                       class="form-control form-control-sm">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <label>Nome Fantasia</label>
                                <input name="nomeFantasia" value="${obj.nomeFantasia}"
                                       class="form-control form-control-sm">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <label>Crédito</label>
                                <input name="credito"
                                       value="<fmt:formatNumber
                                           pattern="###.##"
                                           type="number" value="${obj.credito}"/>"
                                       class="form-control form-control-sm">
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
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../commons/footer.jsp" %>
