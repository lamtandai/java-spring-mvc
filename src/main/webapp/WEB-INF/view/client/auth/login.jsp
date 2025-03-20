<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Login</title>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body>
                <script>
                    function setFormAction(actionUrl) {
                        document.getElementById("loginForm").action = actionUrl;
                        document.getElementById("loginForm").submit();
                    }
                </script>
                <style>
                    .login-container {
                        max-width: 1000px;
                        margin: 50px auto;
                        padding: 20px;
                        border: 5px solid #007bff;
                        /* Prominent blue border */
                        border-radius: 20px;
                        /* Optional: Rounded corners */
                        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                        /* Optional: Shadow for depth */
                    }
                </style>

                <div class="login-container container-fluid ">
                    <div class="row justify-content-center ">
                        <h1 class="text-center mt-5">Login</h1>
                        <div class="col-lg-7">
                            <form:form method="post" action="/login" modelAttribute="loginUser" id="loginForm"
                                class="row g-3 col-12 col-md-8 mx-auto">

                                <div class="mb-3 col-12 ">
                                    <label class="form-label">Email address</label>
                                    <c:set var="errorEmail">
                                        <form:errors path="email" />
                                    </c:set>
                                    <input type="email" class="form-control" name="username" 
                                        placeholder="Enter your email?" data-required="true" />
                                    <div class="invalid-feedback">
                                        <c:if test="${not empty errorEmail}">
                                            ${errorEmail}
                                        </c:if>
                                    </div>
                                    <div class="valid-feedback">Looks good!</div>
                                </div>

                                <div class="mb-3 col-12 ">
                                    <label class="form-label">Password</label>
                                    <c:set var="errorPassword">
                                        <form:errors path="password" />
                                    </c:set>
                                    <input type="password" class="form-control" name="password" 
                                        placeholder="Enter your password?" data-required="true" />
                                    <div class="invalid-feedback">
                                        <c:if test="${not empty errorPassword}">
                                            ${errorPassword}
                                        </c:if>
                                    </div>
                                    <div>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    </div>
                                    <c:if test="${param.error != null}">
                                    <div class="my-2" style="color: red;">Invalid email or password.</div>
                                </c:if>

                                </div>

                                <!-- Buttons -->
                                <div class="d-flex flex-column">
                                    <button type="button" class="btn btn-primary mb-2" onclick="setFormAction('/login')"
                                        id="submitButton">
                                        Login


                                    </button>
                                    <div class="text-center">
                                        <a href="register"> Dont have an account?/ Go to create new one! </a>
                                    </div>
                                </div>
                            </form:form>
                        </div>

                    </div>

                </div>

            </body>

            </html>