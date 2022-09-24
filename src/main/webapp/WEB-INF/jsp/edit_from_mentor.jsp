<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24.09.2022
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/mentors/save">
    <label for="full_name" >full_name</label>
    <input id="full_name" name="full_name" type="text" value="${mentor.full_name}">



    <label for="course" >unver</label>
    <input id="course" name="cours" type="number" value="${mentor.unver_name}">
    <label for="mentor" >mentors</label>
    <select name="mentor_id" id="mentor" ><c:forEach var="unverl" items="${unver}">
        <option value="${unverl.id}">
                ${unverl.unverName}

        </option>
    </c:forEach></select>
    <button type="submit">saqlash</button>
</form>

</body>
</html>
