<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24.09.2022
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/mentors/add_mentor">+mentortqoshish</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">full_name</th>
        <th scope="col">Unver-</th>

    </tr>
    </thead>
    <tbody>

    <c:forEach items="${mentors}" var="mentorss">
        <tr>
            <td scope="row">${mentorss.id}</td>
            <td>${mentorss.full_name}</td>
            <td>${mentorss.unver_name}</td>

            <td>
                <a href="/mentors/edit/${mentorss.id}"> edit</a>
                <a href="/mentors/delete/${mentorss.id}"> delete</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
