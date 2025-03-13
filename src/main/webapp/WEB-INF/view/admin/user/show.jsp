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
            <title>Table Users</title>
            <link href="/css/styles.css" rel="stylesheet" />
            <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        </head>

        <body class="sb-nav-fixed">
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
                <jsp:include page="../layout/sidebar.jsp" />
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                            <h1 class="mt-4">Manage User</h1>
                            <ol class="breadcrumb mb-4">
                                <li class="breadcrumb-item active">
                                    <a href="/admin"> Dashboard</a>
                                </li>
                                <li class="breadcrumb-item active">Users</li>
                            </ol>
                            <!-- main content -->
                            <div class="mt-3">
                                <div class="row">
                                    <div class="col-12 mx-auto">
                                        <div class="d-flex justify-content-between">
                                            <h3> Table User</h3>
                                            <!-- action: url /admin/user/create -->
                                            <form:form method="get" action="/admin/user/create">
                                                <button type="submit" class="btn btn-primary"> Create User</button>
                                            </form:form>
                                        </div>
                            
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Id</th>
                                                    <th scope="col">Email</th>
                                                    <th scope="col">FullName</th>
                                                    <th scope="col">Role</th>
                                                    <th scope="col">Updated At</ths>
                                                    <th scope="col">Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="user" items="${listUser}">
                                                    <tr>
                                                        <td>${user.id}</td>
                                                        <td>${user.email}</td>
                                                        <td>${user.fullName}</td>
                                                        <td>${user.getRole().getRole_name()}</td>
                                                        <td>${user.getFormattedUpdatedAt()}</td>
                                                        <td class="d-flex flex-row">
                            
                                                            <a href="/admin/user/view/${user.id}" type="submit"
                                                                class="btn btn-success me-2"> View </a>
                            
                                                            <a href="/admin/user/update/${user.id}"
                                                                class="btn btn-warning me-2">Update</a>
                            
                                                            <a href="#" class="btn btn-danger" data-bs-toggle="modal"
                                                                data-bs-target="#deleteModal${user.id}">
                                                                Delete
                                                            </a>
                            
                                                            <jsp:include page='delete.jsp'>
                                                                <jsp:param name="userId" value="${user.id}" />
                                                            </jsp:include>
                            
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
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


