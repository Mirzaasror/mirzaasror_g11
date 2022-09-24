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
<form method="post" action="/mentors/add_mentor">
    <label for="full_name" >full_name</label>
    <input id="full_name" name="fullName" type="text">




    <label for="unver">unvers</label>
    <select name="unver_id" id="unver"><c:forEach var="unversl" items="${unvers}">
        <option value="${unversl.id}">
                ${unversl.unverName}

        </option>
    </c:forEach></select>
    <button type="submit">saqlash</button>
</form>

</body>
</html>
