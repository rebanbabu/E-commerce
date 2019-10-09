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
<title>Product Details</title>
<style>
.errors
{
color: red;
}
</style>
</head>
<body>
<h1><center>PRODUCT FORM</center></h1>
<c:url value="/resources/images/" var="image"/>

<f:form method="post" action="addproduct" modelAttribute="addproduct" enctype="multipart/form-data">
<table class="table table-borderless" border='2'>
<tr>
<td>
Enter product id
</td>
<td>
<f:input path="productid" class="form-control"/>
<f:errors path="productid" class="errors"/>
</td>
</tr>
<tr>
<td>
Enter Product Name
</td>
<td>
<f:input path="productName" value="${currproduct.productName}" class="form-control" />
<f:errors path="productName" class="errors"/>
</td>
</tr>
<tr>
<td>
Enter Price
</td>
<td>
<f:input path="price" value="${currproduct.price}" class="form-control"/>
<f:errors path="price" class="errors"/>
</td>
</tr>

<tr>
<td>
Enter Quantity
</td>
<td>
<f:input path="quantity" value="${currproduct.quantity}" class="form-control"/>
<f:errors path="quantity" class="errors"/>
</td>
</tr>
<tr>
<td>
Enter description
</td>
<td>
<f:textarea path="description" value="${currproduct.description}" class="form-control"/>
<f:errors path="description" class="errors"/>
</td>
</tr>
<tr>
<td>
Select Category Id
</td>
<td>
<f:input path="categoryid" class="form-control"/>
<f:errors path="categoryid" class="errors"/>
</td>
</tr>
<tr>
<td>
Select Supplier Id
</td>
<td>
<select name="id" class="custom-select">
<c:forEach items="${supplierlist}" var="supplier">
    <option value="${supplier.id}">
       ${supplier.supplierName} ${supplier.supplieraddress}
    </option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>
Select Product Image
</td>
<td>
<input type="file" class= "custom-file-input" name="image"/>
</td>
</tr>

<tr>
<td>
<input class="btn btn-primary" type='submit' value="save"/>
</td>
</tr>
<br> <br>
</table>
</f:form>
<table class="table table-dark table-striped" border="2">
<th>
product id
</th>
<th>
Product Name
</th>
<th>
Price
</th>
<th>
discountPrice
</th>
<th>
Quantity
</th>
<th>
image
</th>
<c:forEach items="${productlist}" var="product">
<tr>
<td>
${product.productid}
</td>
<td>
${product.productName}
</td>
<td>
${product.price}
</td>

<td>
${product.quantity}
</td>
<td>
<img src="${image}${product.productid}.jpg" height="50" width="50"/>
</td>
<td>
<a type="submit" class="btn btn-primary" href="ProductDetails?id=${product.productid}">edit</a>
</td>
<td>
<a type="submit" class="btn btn-primary" href='deleteproduct?id=${product.productid}'>delete</a>
</td>
</tr>

</c:forEach>
</table>

</body>
</html>