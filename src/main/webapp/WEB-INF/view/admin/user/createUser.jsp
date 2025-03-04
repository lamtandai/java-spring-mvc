<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto">
                            <h3> Create New User</h3>
                            <form:form method="post" action="/admin/user/createUser1" modelAttribute="newUser">
                                <div class="mb-3">
                                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                                    <form:input path="email" type="email" class="form-control" />
                                </div>

                                <div class="mb-3">
                                    <label for="exampleInputFullName" class="form-label">FullName</label>
                                    <form:input path="fullName" type="text" class="form-control" />
                                </div>

                                <div class="mb-3">
                                    <label for="exampleInputAddress1" class="form-label">Address</label>
                                    <form:input path="address" type="text" class="form-control" />
                                </div>

                                <div class="mb-3">
                                    <label for="exampleInputPhone1" class="form-label">Phone</label>
                                    <form:input path="phone" type="text" class="form-control" />
                                </div>

                                <div class="mb-3">
                                    <label for="exampleInputPassword1" class="form-label">Password</label>
                                    <form:input path="password" type="password" class="form-control" />
                                </div>

                                <button type="submit" class="btn btn-primary">Submit</button>
                            </form:form>
                        </div>
                    </div>
                </div>
                </div>
            </body>

            </html>