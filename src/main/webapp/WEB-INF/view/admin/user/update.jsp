<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="utf-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
            <meta name="description" content="" />
            <meta name="author" content="" />
            <title>Dashboard - SB Admin</title>
            <link href="/css/styles.css" rel="stylesheet" />
            <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            <script>
                function setFormAction(actionUrl) {
                    document.getElementById("userForm").action = actionUrl;
                    document.getElementById("userForm").submit();
                }
            </script>
        </head>

        <body class="sb-nav-fixed">
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
                <jsp:include page="../layout/sidebar.jsp" />
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                            <h1 class="mt-4">Update User</h1>
                            <ol class="breadcrumb mb-4">
                                <li class="breadcrumb-item active">
                                    <a href="/admin"> Dashboard</a>
                                </li>
                                <li class="breadcrumb-item active">
                                    <a href="/admin/user"> User </a>
                                </li>

                                <li class="breadcrumb-item active">Update User</li>
                            </ol>
                            <div class="container mt-3">
                                <div class="row">
                                    <div class="col-md-10 col-12 mx-auto ">
                                        <form:form method="patch" action="/admin/user/update/${user.id}" modelAttribute="user"
                                            id="userForm">
                                            <div class="mb-3">
                                                <label class="form-label"> User's Id: </label>
                                                <form:input path="id" type="email" class="form-control" readonly="true" />
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label"> Email address: </label>
                                                <form:input path="email" type="email" class="form-control fst-italic" readonly="true"/>
                                            </div>
                            
                                            <div class="mb-3">
                                                <label class="form-label">Full Name</label>
                                                <form:input path="fullName" type="text" class="form-control fst-italic" />
                                            </div>
                            
                                            <div class="mb-3">
                                                <label class="form-label">Address</label>
                                                <form:input path="address" type="text" class="form-control fst-italic" />
                                            </div>
                            
                                            <div class="mb-3">
                                                <label class="form-label">Phone Number</label>
                                                <form:input path="phone" type="text" class="form-control fst-italic" />
                                            </div>
                            
                                            <!-- Buttons -->
                                            <div class="d-flex flex-column">
                                                <button type="submit" class="btn btn-primary">
                                                    Verify
                                                </button>
                                            </div>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </main>
                    <jsp:include page="../layout/footer.jsp" />
                </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                crossorigin="anonymous"></script>
            <script src="/js/scripts.js"></script>

        </body>

        </html>


