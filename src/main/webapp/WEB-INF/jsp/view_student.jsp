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
<a href="/students/add-student">+studentqoshish</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">full_name</th>
        <th scope="col">Corse_name</th>
        <th scope="col">Mentor_Full_name</th>
        <th scope="col">course</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${studentlar}" var="student">
        <tr>
            <td scope="row">${student.id}</td>
            <td>${student.full_name}</td>
            <td>${student.course_name}</td>
            <td>${student.mentor_name}</td>
            <td>${student.course}</td>
            <td>
                <a href="/students/edit/${student.id}"> edit</a>
                <a href="/students/delete/${student.id}"> delete</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
