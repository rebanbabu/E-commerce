<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>
<body>
<nav>
      <table class="table table-borderless" border='2'>
       <tr>
       
       <c:url value="ProductDetails" var="Product"/>
       <c:url value="supplierDetails" var="Supplier"/>
       <c:url value="categoryDetails" var="category"/>    <br><br>
<td> 
    <a href="${Product}" input type='submit' class="btn btn-primary"/>PRODUCT DETAILS</a>
       </td>
       <td>
        <a href="${category}"input type='submit' class="btn secondary"/>CATEGORY DETAILS</a> 
       </td>
       <td>
    <a href="${Supplier}"input type='submit' class="btn btn-warning"/>SUPPLIERDETAILS</a>
       </td>
       </tr>
      </table>
   </nav>
</body>
</html>