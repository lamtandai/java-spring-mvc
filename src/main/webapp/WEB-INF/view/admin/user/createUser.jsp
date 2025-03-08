<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

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
            <div class="col-md-6 col-12 mx-auto">
                <h3>Create New User</h3>
                <form:form method="post" action="/admin/user/create" modelAttribute="newUser" id="userForm">
                    <div class="mb-3">
                        <label class="form-label">Email address</label>
                        <form:input path="email" type="email" class="form-control" />
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Full Name</label>
                        <form:input path="fullName" type="text" class="form-control" />
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Address</label>
                        <form:input path="address" type="text" class="form-control" />
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Phone</label>
                        <form:input path="phone" type="text" class="form-control" />
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <form:input path="password" type="password" class="form-control" />
                    </div>

                    <!-- Buttons -->
                    <div class="d-flex flex-column">
                        <button type="button" class="btn btn-primary mb-2" onclick="setFormAction('/admin/user/create')">
                            Submit
                        </button>

                        <button type="button" class="btn btn-secondary" onclick="setFormAction('/admin/user')">
                            Display Users
                        </button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
   
</body>
</html>
