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
                <title>Create Product</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

                <script>
                    function setFormAction(actionUrl) {
                        document.getElementById("productForm").action = actionUrl;
                        document.getElementById("productForm").submit();
                    }
                </script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

                <script>
                    $(document).ready(() => {
                        const laptopImage = $("#laptopImage");
                        laptopImage.change(function (e) {
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
                                <h1 class="mt-4">Create New Product</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active">
                                        <a href="/admin"> Dashboard</a>
                                    </li>
                                    <li class="breadcrumb-item active">
                                        <a href="/admin/product"> Product </a>
                                    </li>
                                    <li class="breadcrumb-item active"> Create Product</li>
                                </ol>

                                <form:form method="post" action="/admin/product/create" modelAttribute="newProduct"
                                    id="productForm" class="row g-3 col-12 col-md-8 mx-auto"
                                    enctype="multipart/form-data">
                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Name</label>
                                        <form:input path="proName" type="text" class="form-control" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Manufactor</label>
                                        <form:select path="manufactor" class="form-control">
                                            <form:option value="">Select</form:option>
                                            <form:option value="Apple">Apple</form:option>
                                            <form:option value="Asus">Asus</form:option>
                                            <form:option value="Acer">Acer</form:option>
                                            <form:option value="Dell">Dell</form:option>
                                            <form:option value="Lg">Lg</form:option>
                                            <form:option value="lenovo">lenovo</form:option>
                                        </form:select>

                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Detail Description</label>
                                        <form:input path="detailDesc" type="text" class="form-control" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Short Description</label>
                                        <form:input path="shortDesc" type="text" class="form-control" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Price</label>
                                        <form:input path="price" type="text" class="form-control" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Quantity</label>
                                        <form:input path="quantity" type="text" class="form-control" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Target</label>
                                        <!--role is an object, not a text, we are selecting text,
                                        role.role_name will receive the name in the form, 
                                        but other fields (id, desc) will be null 
                                        -->
                                        <form:select path="target" class="form-control">
                                            <form:option value="Gaming">Gaming</form:option>
                                            <form:option value="Graphic Design">Graphic Design</form:option>
                                            <form:option value="On-the-go">On-the-go</form:option>
                                            <form:option value="For Office worker">For Office worker</form:option>
                                            <form:option value="Entrepreneur">Entrepreneur</form:option>
                                        </form:select>

                                    </div>
                                    <div class="mb-3 col-md-6 col-12">
                                        <label for="laptopImage" class="form-label">Image</label>
                                        <input id="laptopImage" type="file" class="form-control"
                                            accept=".png, .jpg, .jpeg" name="laptopImage" />
                                    </div>
                                    <div>
                                        <div class="col-12 mb-3">
                                            <img style="max-height: 250px; display: none;" alt="avatar preview"
                                                id="avatarPreview" />
                                        </div>
                                    </div>

                                    <!-- Buttons -->
                                    <div class="d-flex flex-column">
                                        <button type="button" class="btn btn-primary mb-2"
                                            onclick="setFormAction('/admin/product/create')">
                                            Submit
                                        </button>

                                        <button type="button" class="btn btn-secondary"
                                            onclick="setFormAction('/admin/product')">
                                            Display All Products
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


            </body>

            </html>