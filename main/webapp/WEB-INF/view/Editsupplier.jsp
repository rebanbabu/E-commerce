<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
supplier Details
<f:form method="post" action="updateSupplier" modelAttribute="addsupplier" enctype="multipart/form-data">
<table>
<tr>
<td>
<f:input path="id" value="${currsupplier.id}" />
</td>
<td>
Enter Supplier Name
</td>
<td>
<f:input path="supplierName" value="${currsupplier.supplierName}" />
</td>
</tr>
<tr>
<td>
Enter Supplier address
</td>
<td>
<f:input path="supplieraddress" value="${currproduct.supplieraddress}" />
</td>
</tr>
</table>
<tr>
<td>
<input type='submit' value="save" required/>
</td>
</tr>
</f:form>
</body>
</html>