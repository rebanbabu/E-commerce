<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>e-cart</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style>
.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
}

.pagination a:hover:not(.active) {background-color: #ddd;}



.c {
  position: relative;
  width: 50%;
}

.image {
  display: block;
  width: 100%;
  height: auto;
}

.overlay {
  position: absolute;
  bottom: 100%;
  left: 0;
  right: 0;
  background-color: white;
  overflow: hidden;
  width: 100%;
  height:0;
  transition: .5s ease;
}

.c:hover .overlay {
  bottom: 0;
  height: 100%;
}

.text {
  color: black;
  font-size: 10px;
  position: absolute;
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  text-align: center;
}

</style>
</head>

<body>
<c:url value="cartdetails" var="gotocart"/>
 <c:if test="${logoutstatus}==true"> 
 <jsp:forward page="login"/></c:if>
<center>
hi..  ${username}
 <%String username=(String)session.getAttribute("username") ;
 System.out.println(username);
 %>
 </center>






<c:url value="/resources/images/" var="image"/>

<div class="jumbotron text-center">
        <h1>E-CART SITE</h1>
</div>
<div class="container">
<div class="dropdown" style="float:left">
<label type="label" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-th-list">Menu</span></label>&nbsp&nbsp&nbsp
<div class="dropdown-menu">
 <label><a class="dropdown-item"href="#">PROFILE</a></label></br>
 <label><a class="dropdown-item"href="#">MY ACCOUNT</a></label></br>
 <label><a class="dropdown-item"href="#">MY ORDERS</a></label></br>
 </div></div>
 <div class="dropdown" style="float:left">
<label type="label" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-home">Home</span></label>&nbsp&nbsp&nbsp
  <div class="dropdown-menu">
  <label><a class="dropdown-item"href="#">ABOUT US</a></label></br>
  <label><a class="dropdown-item"href="#">CONTACT NUMBER</a></label></div></div>
  <div class="dropdown" style="float:left">
<label class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-filter">Category</span></label>&nbsp&nbsp&nbsp
  <div class="dropdown-menu">
  <label><a class="dropdown-item"href="#">FASHION</a></label></br>
  <label><a class="dropdown-item"href="#">ELECTRONICS</a></label></br>
  <label><a class="dropdown-item"href="#">HOME&FURNITURE</a></label></br>
  </label></div></div>
  
  <div class="row"><div class="col-xs-5"><div class="input-group"><span class="input-group-addon"><span class="glyphicon glyphicon-search"></span></span><input type="text" class="form-control" placeholder="Search for products,brands and more"></div></div>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp


<a class="btn btn-primary" type="submit" href="${gotocart}">CART<span class="badge" id="count">${cartsize}</span></a> &nbsp&nbsp&nbsp
	<div class="dropdown" style="float:left">
        <label class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span></label>
<div class="dropdown-menu">
<label><a class="dropdown-item"href="login">LOGIN</a></label></br>
  <label><a class="dropdown-item"href="signup">SIGN-UP</a></label></br>
  <label><a class="dropdown-item"href="logout">LOGOUT</a></label></br>
  
  </label></div></div>


</div>
</div>




<br>  <br>


<div class="container">
<div class="row">
<c:forEach items="${productlist}" var="product">

<div class="col-sm-3">
<div class="c">
<img src="${image}${product.productid}.jpg" class="image" alt="Avatar" width="150" height="200"/> <br> <br> 
<div class="overlay">
    <div class="text">
    ${product.description}
    </div>
  </div>
</div>

${product.productName }
<br>
RS:<del>  ${product.price} </del><ins>1500</ins>

 <f:form method="post" action="addtocart" modelAttribute="mycart">
 <input type='hidden' name="email" value=<%=username%>/>
 <input type='hidden' name='productid' value='${product.productid}'/>
 <input type='hidden' name='price' value='${product.price}'/>
 <input type='hidden' name="productName" value='${product.productName}'/>
 
<input type='submit' class="btn btn-primary" value='ADD TO CART'/>
<a href="#">
          <span class="glyphicon glyphicon-heart"></span>
        </a>
</div>
</f:form>

</c:forEach>
 </div>
</div>
 
 <div class="pagination">
  <a href="#">&laquo;</a>
  <a href="#" class="active">1</a>
  <a href="#" >2</a>
  <a href="#">3</a>
  <a href="#">4</a>
  <a href="#">&raquo;</a>
  
</div>
 
 
 



</body>
</html>