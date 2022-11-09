<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>공영 주차장 결제 웹페이지 - 회원가입</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="../../resources/bootstrap/assets/img/favicon.png" rel="icon">
    <link href="../../resources/bootstrap/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="../../resources/bootstrap/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/bootstrap/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="../../resources/bootstrap/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="../../resources/bootstrap/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="../../resources/bootstrap/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
    <link href="../../resources/bootstrap/assets/vendor/aos/aos.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="../../resources/bootstrap/assets/css/main.css" rel="stylesheet">

    <!-- =======================================================
    * Template Name: Logis - v1.2.1
    * Template URL: https://bootstrapmade.com/logis-bootstrap-logistics-website-template/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
</head>
<body>

<%@ include file="/WEB-INF/view/include/header.jspf" %>

<main id="main">
    <div class="breadcrumbs">
        <div class="page-header d-flex align-items-center" style="background-image: url('../../../resources/bootstrap/assets/img/page-header.jpg');">
            <div class="container position-relative">
                <div class="row d-flex justify-content-center">
                    <div class="col-lg-6 text-center">
                        <h2>회원가입</h2>
                    </div>
                </div>
            </div>
        </div>
        <nav>
            <div class="container">
                <ol>
                    <li><a href="/">Home</a></li>
                    <li>회원가입</li>
                </ol>
            </div>
        </nav>
    </div>

    <section id="get-a-quote" class="get-a-quote">
        <div class="container" data-aos="fade-up">
            <div class="row g-0">
                <div class="col-lg-5 quote-bg" style="background-image: url(../../../resources/bootstrap/assets/img/quote-bg.jpg);"></div>
                <div class="col-lg-7">
                    <form action="/join" method="post" role="form" class="php-email-form">
                        <div class="form-group mt-3">
                            <input type="email" class="form-control" name="email" placeholder="Email Address" required />
                        </div>
                        <div class="form-group mt-3">
                            <input type="password" class="form-control" name="password" placeholder="Password" required />
                        </div>
                        <div class="form-group mt-3">
                            <input type="license_plate" class="form-control" name="license_plate" placeholder="License Plate [00가 0000 or 000가 0000]" required />
                        </div>
                        <br/>
                        <div class="text-center">
                            <button type="submit">Join</button>
                        </div>
                        <br>
                        <span>이미 가입하셨나요? ▶ </span>
                        <a style="text-decoration:none;" href="/login">로그인</a>
                    </form>
                </div>
            </div>
        </div>
    </section>
</main>

<%@ include file="/WEB-INF/view/include/footer.jspf" %>

<a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<div id="preloader"></div>

<!-- Vendor JS Files -->
<script src="../../resources/bootstrap/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../../resources/bootstrap/assets/vendor/glightbox/js/glightbox.min.js"></script>
<script src="../../resources/bootstrap/assets/vendor/swiper/swiper-bundle.min.js"></script>
<script src="../../resources/bootstrap/assets/vendor/aos/aos.js"></script>

<!-- Template Main JS File -->
<script src="../../resources/bootstrap/assets/js/main.js"></script>

</body>
</html>