<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>categoryDetails</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<style>
.errors
{
color: red;
}
</style>
</head>
<body>
<h1><center>
CATEGORY FORM
</center></h1>
<f:form method="post" action="addcategory" modelAttribute="addcategory">
<table class="table table-borderless"  border="2">
<tr>
<td>
Enter category id
</td>
<td>
<f:input path="categoryid" class="form-control"/>
<f:errors path="categoryid" class="errors"/>
</td>
</tr>
<tr>
<td>
Enter category name
</td>
<td>
<f:input path="categoryName" class="form-control"/>
<f:errors path="categoryName" class="errors"/>
</td>
</tr>
<tr>
<td>
<input class="btn btn-primary" type="submit" value="add"/>
</td>
</tr>

</table>
</f:form>
<table class="table table-dark table-striped" border="2">
<th>
category id
</th>
<th>
category Name
</th>
<c:forEach items="${categorylist}" var="category">
<tr>
<td>
${category.categoryid}
</td>
<td>
${category.categoryName}
</td>
<td>
<a type="submit" class="btn btn-primary" href="categoryDetails?id=${category.categoryid}">edit</a>
</td>
<td>
<a type="submit" class="btn btn-primary" href='deletecategoryDetails?id=${category.categoryid}'>delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>