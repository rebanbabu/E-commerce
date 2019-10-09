<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<div class="container">
  <div class="col-md-offset-2 col-md-9">
<h1><center>SIGNUP FORM</center></h1>
<f:form method="post" action="adduser" modelAttribute="adduser">
 
<table class="table table-striped table-bordered">
<tr>
<td>
Enter   email
</td>
<td>
<f:input path="email" value="${curruser.email}"  class="form-control"/>
<f:errors path="email" class="errors"/>
</td>
</tr>
<tr>
<td>
Enter user name
</td>
<td>
<f:input path="userName" value="${curruser.userName}" class="form-control"/>
<f:errors path="userName" class="errors"/>
</td>
</tr>
<tr>
<td>
Enter password
</td>
<td>
<f:input path="password" value="${curruser.password}" class="form-control"/>
<f:errors path="password" class="errors"/>
</td>
</tr>
<td>

<tr>
<td>
Enter  Confirm password
</td>
<td>
<f:input path="Confirmpassword" value="${curruser.Confirmpassword}" class="form-control"/>
<f:errors path="Confirmpassword" class="errors"/>
</td>
</tr>

<tr> 
 <td> 

 <input class="btn btn-success" type="submit" value="save" />  
<input class="btn btn-secondary" type="submit" value="cancel"/> 
 </td>
 </tr> 
</table>
</f:form>
</div>
</div>
</body>
</html>