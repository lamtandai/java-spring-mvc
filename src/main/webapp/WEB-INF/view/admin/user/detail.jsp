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
            <title>Create User</title>
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
                            <h1 class="mt-4">User View </h1>
                            <ol class="breadcrumb mb-4">
                                <li class="breadcrumb-item active">
                                    <a href="/admin"> Dashboard</a>
                                </li>
                                <li class="breadcrumb-item active">
                                    <a href="/admin/user"> User </a>
                                </li>
                                <li class="breadcrumb-item active">User View</li>
                            </ol>
                            <div class="mt-4">
                                <div class="row">
                                    <div class="col-12 mx-auto">
                                        
                                        <div class="card">
                                            
                                            <ul class="list-group list-group-flush fs-3">
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>ID</span>
                                                    <span>${user.id}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>Full Name</span>
                                                    <span>${user.fullName}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>Email</span>
                                                    <span>${user.email}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>Address</span>
                                                    <span>${user.address}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>Created At</span>
                                                    <span>${user.getFormattedCreatedAt()}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>Updated At</span>
                                                    <span>${user.getFormattedUpdatedAt()}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>Phone Number</span>
                                                    <span>${user.phone}</span>
                                                </li>
                                            </ul>
                            
                                        </div>
                                    </div>
                            
                                </div>
                                <a href="/admin/user" class="btn btn-success"> Back </a>
                            
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


