<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
<h2>What would you like to shop today...</h2>
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
                  <input type="submit" value="Shop Now"/>
</form>
</body>
</html>