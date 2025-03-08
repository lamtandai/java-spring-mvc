<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>User Detail</title>

                <!-- Bootstrap CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Bootstrap JS -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <!-- jQuery -->
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

                <script>
                    function setFormAction(actionUrl) {
                        document.getElementById("userForm").action = actionUrl;
                        document.getElementById("userForm").submit();
                    }
                </script>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-12 mx-auto">
                            <h1>User View</h1>
                            <div class="card">
                                <div class="card-header fs-4">
                                    Detail Information
                                </div>
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

            </body>

            </html>