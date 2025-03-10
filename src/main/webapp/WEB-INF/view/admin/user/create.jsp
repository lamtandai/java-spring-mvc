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
                 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

                 <script>
                     $(document).ready(() => {
                         const avatarFile = $("#avatarFile");
                         avatarFile.change(function (e) {
                             const imgURL = URL.createObjectURL(e.target.files[0]);
                             $("#avatarPreview").attr("src", imgURL);
                             $("#avatarPreview").css({ "display": "block" });
                         });
                     });
                 </script>
 
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Create New User</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active">
                                        <a href="/admin"> Dashboard</a>
                                    </li>
                                    <li class="breadcrumb-item active">
                                        <a href="/admin/user"> User </a>
                                    </li>
                                    <li class="breadcrumb-item active"> Create User</li>
                                </ol>

                                <form:form method="post" action="/admin/user/create" modelAttribute="newUser"
                                    id="userForm" class="row g-3 col-12 col-md-8 mx-auto"
                                    enctype="multipart/form-data"
                                    >
                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Email address</label>
                                        <form:input path="email" type="email" class="form-control" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Full Name</label>
                                        <form:input path="fullName" type="text" class="form-control" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Phone</label>
                                        <form:input path="phone" type="text" class="form-control" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Password</label>
                                        <form:input path="password" type="password" class="form-control" />
                                    </div>

                                    <div class="mb-3 col-12">
                                        <label class="form-label">Address</label>
                                        <form:input path="address" type="text" class="form-control" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Role</label>
                                        <!--role is an object, not a text, we are selecting text,
                                        role.role_name will receive the name in the form, 
                                        but other fields (id, desc) will be null 
                                        -->
                                        <form:select path="role.role_name" class="form-control">
                                            <form:option value="ADMIN">Admin</form:option>
                                            <form:option value="USER">User</form:option>
                                        </form:select>

                                    </div>
                                    <div class="mb-3 col-md-6 col-12">
                                        <label for="avatarFile" class="form-label">Avatar</label>
                                        <input 
                                        id="avatarFile" 
                                        type="file" 
                                        class="form-control" 
                                        accept=".png, .jpg, .jpeg"
                                        name="avatarFile"
                                        />
                                    </div>
                                    <div>
                                        <div class="col-12 mb-3">
                                            <img style="max-height: 250px; display: none;" alt="avatar preview" id="avatarPreview"/> 
                                        </div>
                                    </div>

                                    <!-- Buttons -->
                                    <div class="d-flex flex-column">
                                        <button type="button" class="btn btn-primary mb-2"
                                            onclick="setFormAction('/admin/user/create')">
                                            Submit
                                        </button>

                                        <button type="button" class="btn btn-secondary"
                                            onclick="setFormAction('/admin/user')">
                                            Display Users
                                        </button>
                                    </div>
                                </form:form>



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