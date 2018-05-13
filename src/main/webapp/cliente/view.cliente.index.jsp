<%--
    Document   : view.cliente.index
    Created on : 09/05/2018, 12:39:25
    Author     : lucas
--%>

<%@ include file="../commons/header.jsp" %>
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
                    <a href="${pageContext.request.contextPath}/cliente/form">Novo</a><br><br>
                    <table class="table table-hover table-sm">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Razão / Fantasia</th>
                                <th>Crédito</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="obj" items="${list}">
                                <tr>
                                    <td>${obj.id}</td>
                                    <td>${obj.razaoSocial} / ${obj.nomeFantasia}</td>
                                    <td>
                                        <fmt:setLocale value="pt-BR"/>
                                        <fmt:formatNumber value="${obj.credito}" type="currency"/>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/cliente/${obj.id}"
                                           class="acao acao-editar">
                                            Editar
                                        </a>
                                        <a href="${pageContext.request.contextPath}/cliente/deletar/${obj.id}"
                                           class="acao acao-deletar">
                                            Deletar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<!--Ver como carregar os scripts JS e CSS via Java-->
<script src="cliente/js/view.cliente.index.js"></script>
<%@include file="../commons/footer.jsp" %>