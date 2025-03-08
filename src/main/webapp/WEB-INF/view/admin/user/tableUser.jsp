<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-10 col-12 mx-auto">
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
                                        <th scope="col">Created At</ths>
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
                                            <td>${user.getFormattedCreatedAt()}</td>
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

                                                <jsp:include page='modal/modal-delete.jsp'>
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

                
            </body>

            </html>