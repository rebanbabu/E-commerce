<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>supplierDetails</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
</head>
<body>
<h1><center>
SUPPLIER FORM
</center>
</h1>
<f:form method="post" action="addsupplier" modelAttribute="addsupplier">
<table class="table table-borderless" border="2">
<tr>
<td>
Enter supplier id
</td>
<td>
<f:input path="id" class="form-control"/>
</td>
</tr>
<tr>
<td>
Enter Supplier name
</td>
<td>
<f:input path="supplierName" class="form-control"/>
</td>
</tr>
<tr>
<td>
Enter Address
</td>
<td>
<f:textarea path="supplieraddress" class="form-control" />
</td>
</tr>
<tr>
<td>
<input class="btn btn-primary" type="submit" value="add" />
</td>
</tr>

</table>
</f:form>
<table class="table table-dark table-striped" border='2'>
<th>
supplier id
</th>
<th>
Supplier name
</th>
<th>
Supplier address
</th>

<c:forEach items="${supplierlist}" var="supplier">
<tr>
<td>
${supplier.id}
</td>

<td>
${supplier.supplierName}
</td>
<td>
${supplier.supplieraddress}
</td>
<td>
<a type="submit" class="btn btn-primary" href="supplierDetails?id=${supplier.id}">edit</a>
</td>
<td>
<a type="submit" class="btn btn-primary" href='deletesupplierDetails?id=${supplier.id}'>delete</a>
</td>
</tr>

</c:forEach>
</table>
</body>
</html>