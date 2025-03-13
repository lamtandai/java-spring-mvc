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
            <title>View Product</title>
            <link href="/css/styles.css" rel="stylesheet" />
            <link href="/css/avatar_style_modal.css" rel="stylesheet" />
            <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            
             <div class="modal fade" id="avatarModal" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header ">
                            <h5 class="modal-title ">Avatar Preview</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body text-center mt-5">
                            <img id="modalImage" src="../../../../images/product/${product.image}" alt="Full Avatar">
                        </div>
                    </div>
                </div>
            </div>
            
        </head>

        <body class="sb-nav-fixed">
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
                <jsp:include page="../layout/sidebar.jsp" />
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                            <div>
                                <div class="d-flex justify-content-between"> 
                                    <div><h1 class="mt-3">Product View </h1>
                                        <ol class="breadcrumb mb-4">
                                            <li class="breadcrumb-item active">
                                                <a href="/admin"> Dashboard</a>
                                            </li>
                                            <li class="breadcrumb-item active">
                                                <a href="/admin/product"> Product </a>
                                            </li>
                                            <li class="breadcrumb-item active">Product View</li>
                                        </ol>
                                    </div>
                                    <div class="image-container">
                                        <img src="../../../../images/product/${product.image}" style="border-radius: 50%; object-fit: cover;" width="100" height="100" data-bs-toggle="modal" data-bs-target="#avatarModal"/> 
                                    </div>
                                </div>

                            </div>
                            
                            <div >
                                <div class="row">
                                    <div class="col-12 mx-auto">
                                        <div class="card">
                                            <ul class="list-group list-group-flush fs-3">
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>ID</span>
                                                    <span>${product.id}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>Name</span>
                                                    <span>${product.proName}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>Price </span>
                                                    <span>${product.price}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>Quantity</span>
                                                    <span>${product.quantity}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>Sold</span>
                                                    <span>${product.sold}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>Manufacturer</span>
                                                    <span>${product.manufactor}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>short Description</span>
                                                    <span>${product.shortDesc}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>Detail Description</span>
                                                    <span>${product.detailDesc}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>Created At</span>
                                                    <span>${product.getFormattedCreatedAt()}</span>
                                                </li>
                                                <li class="list-group-item d-flex justify-content-between">
                                                    <span>Updated At</span>
                                                    <span>${product.getFormattedUpdatedAt()}</span>
                                                </li>
                                                
                                            </ul>
                            
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-end mt-2">
                                        <a href="/admin/product" class="btn btn-success me-2"> Back </a>
                                        <a href="/admin/product/update/${product.id}" class="btn btn-warning me-2 ">Update</a>
                                        <a href="#" class="btn btn-danger" data-bs-toggle="modal"
                                                                        data-bs-target="#deleteModal${product.id}">
                                                                        Delete
                                                                    </a>
                                                                    <jsp:include page='delete.jsp'>
                                                                        <jsp:param name="productId" value="${product.id}" />
                                                                    </jsp:include>
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


