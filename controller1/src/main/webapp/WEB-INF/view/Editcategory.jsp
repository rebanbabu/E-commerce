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
category Details
<f:form method="post" action="updateCategory" modelAttribute="addcategory" enctype="multipart/form-data">
<table>
<tr>
<td>
<f:input path="categoryid" value="${currcategory.categoryid}"/>
</td>
<td>
Enter category Name
</td>
<td>
<f:input path="categoryName" value="${currcategory.categoryName}" />
</td>
</tr>
</table>
<tr>
<td>
<input type='submit' value="save"/>
</td>
</tr>
</f:form>
</body>
</html>