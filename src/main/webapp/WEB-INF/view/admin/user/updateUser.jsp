<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Updat user</title>

                <!-- Bootstrap CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Bootstrap JS -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <!-- jQuery -->
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

            </head>

            <body>

                <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto ">
                            <h3>Update User</h3>
                            <form:form method="patch" action="/admin/user/update/${user.id}" modelAttribute="user"
                                id="userForm">
                                <div class="mb-3">
                                    <label class="form-label">Id: </label>
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

            </body>

            </html>