<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>공영 주차장 결제 웹페이지</title>
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

  <section id="hero" class="hero d-flex align-items-center">
    <div class="container">
      <div class="row gy-4 d-flex justify-content-between">
        <div class="order-2 order-lg-1 d-flex flex-column justify-content-center">
          <section id="horizontal-pricing" class="horizontal-pricing pt-0">
            <div class="container" data-aos="fade-up">
              <div class="row gy-4 pricing-item" data-aos="fade-up" data-aos-delay="100">
                <div class="d-flex align-items-center justify-content-center">
                    <c:choose>
                        <c:when test="${authUser == null}">
                            <ul>
                                <li><h1 style="color:blue; font-weight: bold">로그인 전입니다.</h1></li>
                                <li><h3 style="color:black">로그인 해주세요.</h3></li>
                            </ul>
                        </c:when>
                        <c:when test="${mySystem.entry_time == null}">
                            <ul>
                                <li><h1 style="color:blue; font-weight: bold">${mySystem.price}공영주차장에 입차 전입니다.</h1></li>
                                <li><h3 style="color:black">공영주차장에 입차 후 새로고침 해주세요.</h3></li>
                            </ul>
                        </c:when>
                        <c:when test="${mySystem.exit_time == null}">
                            <ul>
                                <li><h1 style="color:blue; font-weight: bold">FOR TEST</h1></li>
                                <li><h3 style="color: black">${mySystem.parkingLot_id} 주차장 금액</h3></li>
                                <li><i class="bi bi-check"></i> 기본 시간(분) / 기본 요금: ${plInfo.default_minutes} / ${plInfo.default_rate}</li>
                                <li><i class="bi bi-check"></i> 추가 시간(분) / 추가 요금: ${plInfo.additional_minutes} / ${plInfo.additional_rate}</li>
                                <li><i class="bi bi-check"></i> 입차 시간: ${mySystem.entry_time}</li>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <ul>
                                <li><h1 style="color:blue; font-weight: bold">결제 INFO</h1></li>
                                <li><h3 style="color: black">${mySystem.parkingLot_id} 주차장 금액</h3></li>
                                <li><i class="bi bi-check"></i> 기본 시간: ${plInfo.default_minutes}분 / 기본 요금: ${plInfo.default_rate}원</li>
                                <li><i class="bi bi-check"></i> 추가 시간: ${plInfo.additional_minutes}분 / 추가 요금: ${plInfo.additional_rate}원</li>
                                <li><h3 style="color: black">입차, 출차 시간</h3></li>
                                <li><i class="bi bi-check"></i> 입차 시간: ${mySystem.entry_time}</li>
                                <li><i class="bi bi-check"></i> 출차 시간: ${mySystem.exit_time}</li>
                            </ul>
                        </c:otherwise>
                    </c:choose>
                </div>
              </div>
            </div>
          </section>

          <div class="col-lg-6 form-search d-flex align-items-stretch mb-3" data-aos="fade-up" data-aos-delay="200" style="margin: auto">
            <input type="text" class="form-control" placeholder="총 금액" readonly
                    <c:if test="${authUser == null || mySystem.entry_time == null}"> value = "0원"</c:if>
                    <c:if test="${authUser != null}"> value="${mySystem.price}원"</c:if> />
            <button id="paymentButton" onclick="requestPay()">결제하기</button>
          </div>
        </div>

        <section class="call-to-action">
          <div class="container" data-aos="zoom-out">
            <div class="row justify-content-center">
              <div class="col-lg-8 text-center">
                <div>
                  <c:if test="${authUser == null}">
                    <a class="cta-btn" href="/login">로그인</a>
                    <a class="cta-btn" href="/join">회원가입</a>
                  </c:if>
                  <c:if test="${authUser != null}">
                    <a class="cta-btn" href="/auth/logout">로그아웃</a>
                  </c:if>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  </section>

  <c:if test="${authUser != null}">
      <main id="main">
        <section id="call-to-action" class="call-to-action">
          <div class="container" data-aos="zoom-out">
                <div class="row justify-content-center">
                  <div class="col-lg-8 text-center">
                    <h3>입차 / 출차 버튼</h3>
                    <p>(해당 버튼은 시뮬레이션을 위한 버튼이며, 실제 구현에선 없습니다.)</p>
                    <p>(시뮬레이션을 위해 특정 값들을 파라미터로 보내지만, 실제 구현에선 해당 동작이 없습니다.)</p>
                    <a class="cta-btn" id="entryBtn" href="/auth/entryNotice?parkingLot_id=1010089&license_plate=${authUser.license_plate}">입차</a>
                    <a class="cta-btn" id="exitBtn" href="/auth/exitNotice?license_plate=${authUser.license_plate}">출차</a>
                  </div>
                </div>
          </div>
        </section>
      </main>
  </c:if>

  <script>
      function requestPay() {
          if(${mySystem.price != 0}) {
              var IMP = window.IMP;
              IMP.init("imp72680834"); //가맹점 고유 번호

              IMP.request_pay({
                  pg: "html5_inicis", //pg사명
                  pay_method: "card",
                  merchant_uid: createOrderNum(), //가맹점 주문번호
                  name: "공영주차장 이용 금액 계산",
                  amount: ${mySystem.price}
              }, function (rsp) {
                  if(rsp.success) {
                      alert("성공");
                      jQuery.ajax({
                          url: "/",
                          method: "POST",
                          headers: {"Content-Type": "application/json"},
                          data: {
                              imp_uid: rsp.imp_uid, //결제 번호
                              merchant_uid: rsp.merchant_uid
                          }
                      }).done(function (data) {

                      })
                  }
                  else {
                      alert("실패: " + rsp.error_msg);
                  }
              });
          }
          else {
              alert("결제할 금액이 없습니다.");
            return;
          }
      }

      function createOrderNum(){
          const date = new Date();
          const year = date.getFullYear();
          const month = String(date.getMonth() + 1).padStart(2, "0");
          const day = String(date.getDate()).padStart(2, "0");

          let orderNum = year + month + day;
          for(let i=0;i<10;i++) {
              orderNum += Math.floor(Math.random() * 8);
          }
          return orderNum;
      }
  </script>


  <%@ include file="/WEB-INF/view/include/footer.jspf" %>

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>

  <!-- Vendor JS Files -->
  <script src="../../resources/bootstrap/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="../../resources/bootstrap/assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="../../resources/bootstrap/assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="../../resources/bootstrap/assets/vendor/aos/aos.js"></script>
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
  <!-- Template Main JS File -->
  <script src="../../resources/bootstrap/assets/js/main.js"></script>

  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>

</body>
</html>