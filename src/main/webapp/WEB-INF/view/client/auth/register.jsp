<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body>
                <script>
                    function setFormAction(actionUrl) {
                        document.getElementById("registerForm").action = actionUrl;
                        document.getElementById("registerForm").submit();
                    }
                </script>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-7">

                            <form:form method="post" action="/register" modelAttribute="registerUser" id="registerForm"
                                class="row g-3 col-12 col-md-8 mx-auto">
                                <h1 class="mt-5">Register</h1>
                                <div class="mb-3 col-12 col-md-6">
                                    <label class="form-label">First Name</label>
                                    <c:set var="errorFirstName">
                                        <form:errors path="firstName" />
                                    </c:set>
                                    <form:input path="firstName" type="text" class="form-control" id="firstName"
                                        placeholder="Enter your first name?" data-required="true" />
                                    <div class="invalid-feedback">
                                        <c:if test="${not empty errorFirstName}">
                                            <c:out value="${errorFirstName}" />
                                        </c:if>
                                    </div>
                                    <div class="valid-feedback">Looks good!</div>
                                </div>

                                <div class="mb-3 col-12 col-md-6">
                                    <label class="form-label">Last Name</label>
                                    <c:set var="errorLastName">
                                        <form:errors path="LastName" />
                                    </c:set>
                                    <form:input path="lastName" type="text" class="form-control" id="lastName"
                                        placeholder="Enter your last name?" data-required="true" />
                                    <div class="invalid-feedback">
                                        <c:if test="${not empty errorLastName}">
                                            <c:out value="${errorLastName}" />
                                        </c:if>
                                    </div>
                                    <div class="valid-feedback">Looks good!</div>
                                </div>
                                <div class="mb-3 col-12 ">
                                    <label class="form-label">Email address</label>
                                    <c:set var="errorEmail">
                                        <form:errors path="email" />
                                    </c:set>
                                    <form:input type="email" class="form-control" path="email" id="email"
                                        placeholder="Enter your email?" data-required="true" />
                                    <div class="invalid-feedback">
                                        <c:if test="${not empty errorEmail}">
                                           ${errorEmail}
                                        </c:if>
                                    </div>
                                    <div class="valid-feedback">Looks good!</div>
                                </div>
                                <div class="mb-3 col-12 col-md-6">
                                    <label class="form-label">Phone</label>
                                    <c:set var="errorPhone">
                                        <form:errors path="phone" />
                                    </c:set>
                                    <form:input path="phone" type="text" class="form-control" id="phone"
                                        data-required="true" />
                                    <div class="invalid-feedback">
                                        <c:if test="${not empty errorPhone}">
                                            <c:out value="${errorPhone}" />
                                        </c:if>
                                    </div>
                                    <div class="valid-feedback">Looks good!</div>
                                </div>
                                <div class="mb-3 col-12 col-md-6">
                                    <label class="form-label">Password</label>
                                    <c:set var="errorPassword">
                                        <form:errors path="password" />
                                    </c:set>
                                    <form:input type="password" class="form-control" path="password" id="password"
                                        placeholder="Enter your password?" data-required="true" />
                                    <div class="invalid-feedback">
                                        <c:if test="${not empty errorPassword}">
                                            ${errorPassword}
                                        </c:if>
                                    </div>
                                    <div class="valid-feedback">Looks good!</div>
                                </div>

                                <div class="mb-3 col-12 col-md-6">
                                    <label class="form-label">Confirm Password</label>
                                    <c:set var="errorConfirmPassword">
                                        <form:errors path="confirmPassword" />
                                    </c:set>
                                    <form:input type="confirmPassword" class="form-control" path="confirmPassword"
                                        placeholder="Confirm your password" id="confirmPassword" data-required="true" />
                                    <div class="invalid-feedback">
                                        <c:if test="${not empty errorConfirmPassword}">
                                            ${errorConfirmPassword}
                                        </c:if>
                                    </div>
                                    <div class="valid-feedback">Looks good!</div>
                                </div>

                                <!-- Buttons -->
                                <div class="d-flex flex-column">
                                    <button type="button" class="btn btn-primary mb-2"
                                        onclick="setFormAction('/register')" id="submitButton">
                                        Register
                                    </button>

                                </div>
                            </form:form>
                        </div>

                    </div>

                </div>

            </body>

            </html>