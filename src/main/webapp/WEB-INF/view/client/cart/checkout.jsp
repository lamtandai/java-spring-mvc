<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="utf-8">
                    <title>Add product to cart</title>
                    <meta content="width=device-width, initial-scale=1.0" name="viewport">
                    <meta content="" name="keywords">
                    <meta content="" name="description">

                    <!-- Google Web Fonts -->
                    <link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link
                        href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
                        rel="stylesheet">

                    <!-- Icon Font Stylesheet -->
                    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
                        rel="stylesheet">

                    <!-- Libraries Stylesheet -->
                    <link href="/client/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
                    <link href="/client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


                    <!-- Customized Bootstrap Stylesheet -->
                    <link href="/client/css/bootstrap.min.css" rel="stylesheet">

                    <!-- Template Stylesheet -->
                    <link href="/client/css/style.css" rel="stylesheet">
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


                </head>

                <body>

                    <!-- Spinner Start -->
                    <div id="spinner"
                        class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
                        <div class="spinner-grow text-primary" role="status"></div>
                    </div>
                    <!-- Spinner End -->


                    <!-- Navbar start -->
                    <jsp:include page="../layout/head.jsp" />
                    <!-- Navbar End -->


                    <!-- Modal Search Start -->
                    <jsp:include page="../layout/Search.jsp" />
                    <!-- Modal Search End -->


                    <!-- Single Page Header start -->
                    <div class="container-fluid page-header py-5">
                        <h1 class="text-center text-white display-6">Shop Detail</h1>
                        <ol class="breadcrumb justify-content-center mb-0">
                            <li class="breadcrumb-item"><a href="/">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Product Detail</a></li>

                        </ol>
                    </div>
                    <!-- Single Page Header End -->


                    <!-- Cart Page Start -->

                    <div class="container-fluid py-5">
                        <div class="container py-5">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">Products</th>
                                            <th scope="col">Name</th>
                                            <th scope="col">Price</th>
                                            <th scope="col">Quantity</th>
                                            <th scope="col">Total</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="cartDetail" items="${cart.cartDetails}" varStatus="status">
                                            <tr>
                                                <th scope="row">
                                                    <div class="d-flex align-items-center">
                                                        <img src="/images/product/${cartDetail.getCartDetailId().product.image}"
                                                            class="img-fluid me-5 rounded-circle"
                                                            style="width: 80px; height: 80px;" alt="">
                                                    </div>
                                                </th>
                                                <td>
                                                    <p class="mb-0 mt-4">
                                                        ${cartDetail.getCartDetailId().product.proName}
                                                    </p>
                                                </td>
                                                <td>
                                                    <p class="mb-0 mt-4">
                                                        <fmt:formatNumber type="number" value="${cartDetail.price}" /> đ
                                                    </p>
                                                </td>
                                                <td>
                                                    <div class=" quantity mt-4" style="width: 100px;">
                                                        <input type="text"
                                                            class="form-control form-control-sm text-center border-0"
                                                            value="${cartDetail.quantity}"
                                                            data-cart-detail-id="${cartDetail.getCartDetailId()}"
                                                            data-cart-detail-price="${cartDetail.price}"
                                                            data-cart-detail-index="${status.index}" readonly="true">

                                                        </input>
                                                </td>
                                                <td>
                                                    <p class="mb-0 mt-4"
                                                        data-cart-detail-id="${cartDetail.getCartDetailId()}">
                                                        <fmt:formatNumber type="number"
                                                            value="${cartDetail.price * cartDetail.quantity}" /> đ
                                                    </p>
                                                </td>


                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <div class="row g-4 justify-content-end">
                                <div class="col-8">

                                    <div class="bg-light rounded">
                                        <h1 class="display-6 mb-4">Consignee's <span
                                                class="fw-normal">Information</span></h1>
                                        <div class="justify-content-between mb-4">
                                            <form:form action="order-verify" method="post" modelAttribute="consignee">
                                                <label> FullName</label>
                                                <div class="mb-3">
                                                    <form:input class="form-control" type="text"
                                                        value="${user.fullName}" path="fullName" />
                                                </div>
                                                <label> Address</label>
                                                <div class="mb-3">
                                                    <form:input class="form-control" type="text" value="${user.address}"
                                                        path="address" />
                                                </div>
                                                <label> Phone Number</label>
                                                <div class="mb-3">
                                                    <form:input class="form-control" type="text" value="${user.phone}"
                                                        path="phone" />
                                                </div>
                                                <button
                                                    class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mb-4 ms-4"
                                                    type="submit">Verify Checkout
                                                </button>
                                            </form:form>
                                        </div>
                                    </div>

                                </div>
                                <div class="col-sm-8 col-md-7 col-lg-6 col-xl-4">
                                    <div class="bg-light rounded">
                                        <div class="p-4">
                                            <h1 class="display-6 mb-4">Cart <span class="fw-normal">Total</span></h1>
                                            <div class="d-flex justify-content-between mb-4">
                                                <h5 class="mb-0 me-4">Subtotal:</h5>
                                                <p class="mb-0" data-cart-total-price="${totalPrice}">
                                                    <fmt:formatNumber type="number" value="${totalPrice}" /> đ

                                                </p>
                                            </div>
                                            <div class="d-flex justify-content-between">
                                                <h5 class="mb-0 me-4">Shipping</h5>
                                                <div class="">
                                                    <p class="mb-0">Flat rate: ....$</p>
                                                </div>
                                            </div>
                                            <p class="mb-0 text-end">Shipping to .....</p>
                                        </div>
                                        <div class="py-4 mb-4 border-top border-bottom d-flex justify-content-between">
                                            <h5 class="mb-0 ps-4 me-4">Total</h5>
                                            <p class="mb-0 pe-4" data-cart-total-price="${totalPrice}">
                                                <fmt:formatNumber type="number" value="${totalPrice}" /> đ
                                            </p>
                                        </div>


                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <!-- Cart Page End -->


                    <!-- Footer Start -->
                    <jsp:include page="../layout/footer.jsp" />
                    <!-- Footer End -->

                    <!-- Copyright Start -->
                    <jsp:include page="../layout/copyRight.jsp" />
                    <!-- Copyright End -->



                    <!-- Back to Top -->
                    <jsp:include page="../layout/backToTop.jsp" />

                    <!-- JavaScript Libraries -->
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
                    <script src="/client/lib/easing/easing.min.js"></script>
                    <script src="/client/lib/waypoints/waypoints.min.js"></script>
                    <script src="/client/lib/lightbox/js/lightbox.min.js"></script>
                    <script src="/client/lib/owlcarousel/owl.carousel.min.js"></script>

                    <!-- Template Javascript -->
                    <script src="/client/js/main.js"></script>
                </body>

                </html>