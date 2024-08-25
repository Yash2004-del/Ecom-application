<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
 <jsp:include page="Header.jsp"></jsp:include>
 
  <section id="billboard" class="position-relative overflow-hidden bg-light-blue">
      <div class="swiper main-swiper">
        <div class="swiper-wrapper">
         
          <div class="swiper-slide">
            <div class="container">
              <div class="row d-flex flex-wrap align-items-center">
                <div class="col-md-6">
                  <div class="banner-content">
                    <h1 class="display-2 text-uppercase text-dark pb-5">What would you like to shop today...</h1>
                   
 <form action="ListProductServlet" method="post">
                  <select name="Option">
                  <option>Select Category</option>
                  <option>Electronics</option>
                  <option>CLOTHES</option>
                  <option>SHOES</option>
                  <option>BAGS</option>
                  <option>HOME APPLIANCES</option>
                  <option>JWELLERY</option>
                  <option>STATIONERY ASSCESSORIES</option>
                  </select><br><br>
                  <input type="submit" value="Shop Now"/><br>
</form>
                  </div>
                </div>
                <div class="col-md-5">
                  <div class="image-holder">
                    <img src="images/banner-image.png" alt="banner">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
     

</section>
<%@include file="footer.jsp" %>
</body>
</html>