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
        </head>

        <body class="sb-nav-fixed">
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
                <jsp:include page="../layout/sidebar.jsp" />
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                            <h1 class="mt-4">Manage Product</h1>
                            <ol class="breadcrumb mb-4">
                                <li class="breadcrumb-item active">
                                    <a href="/admin"> Dashboard</a>
                                </li>
                                <li class="breadcrumb-item active">Products</li>
                            </ol>
                           <!-- main content -->
                           <div class="mt-3">
                            <div class="row">
                                <div class="col-12 mx-auto">
                                    <div class="d-flex justify-content-between">
                                        <h3> Table Product</h3>
                                        <!-- action: url /admin/product/create -->
                                        <form:form method="get" action="/admin/product/create">
                                            <button type="submit" class="btn btn-primary"> Create Product</button>
                                        </form:form>
                                    </div>
                        
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th scope="col">Id</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Manufacturer</th>
                                                <th scope="col">Target</th>
                                                <th scope="col">Price</th>
                                                <th scope="col">Quantity</th>
                                                <th scope="col">Sold</th>
                                                <th scope="col">Short Desc</th>
                                                <th scope="col">Updated At</ths>
                                                <th scope="col">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="product" items="${listProduct}">
                                                <tr>
                                                    <td>${product.id}</td>
                                                    <td>${product.proName}</td>
                                                    <td>${product.manufactor}</td>
                                                    <td>${product.target}</td>
                                                    <td>${product.price}</td>
                                                    <td>${product.quantity}</td>
                                                    <td>${product.sold}</td>
                                                    <td>${product.shortDesc}</td>
                                                    <td>${product.getFormattedUpdatedAt()}</td>
                                                    <td class="d-flex flex-row">
                        
                                                        <a href="/admin/product/view/${product.id}" type="submit"
                                                            class="btn btn-success me-2"> View </a>
                        
                                                        <a href="/admin/product/update/${product.id}"
                                                            class="btn btn-warning me-2">Update</a>
                        
                                                        <a href="#" class="btn btn-danger" data-bs-toggle="modal"
                                                            data-bs-target="#deleteModal${product.id}">
                                                            Delete
                                                        </a>
                        
                                                        <jsp:include page='delete.jsp'>
                                                            <jsp:param name="productId" value="${product.id}" />
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