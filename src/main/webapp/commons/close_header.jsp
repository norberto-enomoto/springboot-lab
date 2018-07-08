<%--
    Document   : close_header
    Created on : 06/06/2018, 11:12:20
    Author     : lucas
--%>
<%@include file="../WEB-INF/taglibs/taglibs.jsp" %>
<title>SpringBoot Lab</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Hidden brand</a>
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a title="Home" class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/cliente">Clientes</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Disabled</a>
                </li>
            </ul>
            <div class="nav-item active col-md-2 col-lg-0">
                <sec:authorize access="isAuthenticated()">
                    <!--
                    Atributo 'alias' vem da classe
                    '/lab/security/model/CustomUserDetails.java'
                    -->
                    <sec:authentication property="principal.alias" />
                </sec:authorize>
            </div>
            <form class="form-inline my-2 my-lg-0">
                <a class="btn btn-primary my-2 my-sm-0" href="${pageContext.request.contextPath}/logout">Logout</a>
            </form>
        </div>
    </nav>