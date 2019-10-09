<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Invoice</title>
</head>
<body>
<c:url value="/resources/images/" var="image"/>
<center>
hi..  ${username}
 <%String username=(String)session.getAttribute("username") ;
 System.out.println(username);
 %>
 </center>
<div class="jumbotron text-center">
<h1>E-CART SITE

</h1>

</div>
<h4><center>INVOICE DETAILS</center></h4>
<table class="table table-dark table-striped" border="2">
<c:forEach items="${Cartlist}" var="cart">
<tr>
<td>
${cart.productid}

<img src="${image}${cart.productid}.jpg" height="50px" width="50px"/>
</td> 
         
          <td>
             ${cart.price}
          </td>
          <td>
          </c:forEach>
   
   </table>
   <label>TOTAL AMOUNT:${carttotal}</label>
   <c:forEach items="${paymentlist}" var="payment">
   <label>SHIPPING ADDRESS:${payment.shippingaddress}</label></c:forEach>
   
</body>
</html>