<%--
    Document   : logout
    Created on : 06/06/2018, 10:54:42
    Author     : lucas
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- https://pt.stackoverflow.com/questions/1109/onde-devo-colocar-um-c%C3%B3digo-javascript-em-um-documento-html -->

        <!-- Webjars minified -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.3.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        <title>SpringBoot Lab</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form action="${pageContext.request.contextPath}/login" method="post">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-group">
                                    <input name="username" class="form-control"
                                           placeholder="Username">
                                </div>
                                <div class="form-group">
                                    <input name="password" class="form-control"
                                           type="password" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <button class="btn btn-default" type="submit"
                                            value="login">Log in</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>