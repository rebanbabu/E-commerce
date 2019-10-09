
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
<title>Insert title here</title>
<script>
$(document).ready(function(){
  $("#flip").click(function(){
    $("#panel").slideDown( "slow");
  });
  
});
$(document).ready(function(){
	  $("#cashpanel").click(function(){
	    $("#panel").slideUp("slow");
	  });
	  
	});
</script>
<style>
#panel, #flip {
  padding: 5px;
  text-align: center;
  background-color:white;
 
}

#panel {
  padding: 50px;
   border: solid 1px #c3c3c3;
  display: none;
 
}
.errors
{
color: red;
}
</style>
</head>
<body>
<c:url value="/resources/images/" var="image"/>
<c:url value="invoice" var="invoice"/>
<center>
hi..  ${username}
 <%String username=(String)session.getAttribute("username") ;
 System.out.println(username);
 %>
 </center>
<div class="jumbotron text-center">
<h1><center>E-CART SITE</center></h1></div>
<h4><center>PAYMENT DETAILS</center></h4>

<f:form method="post" action="addpayment" modelAttribute="addpayment" >

<table class="table table-borderless" border='2'>
<tr>
<td>
Enter payment method :
</td>

<td>
<div id="flip">
<f:radiobutton path="paymentmethod" value="card" />
<f:errors path="paymentmethod" class="errors"/>

CARD 

<div id="panel">
<div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>




            ENTER THE CARD NUMBER
<input type='text' placeholder='CARD NUMBER' class="form-control"/>
             ENTER THE EXP-DATE
<input type='text' placeholder='EXP-DATE' class="form-control"/>
ENTER THE CCV
<input type='password' placeholder='CCV' class ="form-control"/>
ENTER THE NAME
<input type='text' placeholder='NAME' class="form-control"/>
</div>
</div>

</td>
<td>
<div id="cashpanel">

<f:radiobutton path="paymentmethod" value="cash" />CASH ON DELIVERY<br>
</div>
</td>
</tr>
<br><br>
<tr>
<td>
Enter shippingaddress
</td>
<td>
<f:textarea path="shippingaddress" value="${currproduct.shippingaddress}" class="form-control"/>
<f:errors path="shippingaddress" class="errors"/>
</td>
</tr>
<c:forEach items="${Cartlist}" var="cart">
<input type="hidden" path="Cartid" value="${cart.cartid}"/>
</c:forEach>
</table><br><br>
<table class="table table-borderless">
<tr>
<td>
<input type='submit' class="btn btn-secondary" value="save"/>
<a type="submit" class="btn btn-secondary" href="cartdetails">back</a>
<a href="${invoice}" input type='submit' class="btn btn-success" value="pay"/>pay</a>

</td>
</tr>
</f:form>
</table>
</body>
</html>