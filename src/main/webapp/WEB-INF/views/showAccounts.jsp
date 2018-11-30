<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>KONTA</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>

<body>
<div class="container">
    <h3 class="header">Konta</h3>
    <div class="card">
        <div class="card-body">

            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>NAZWA KONTA</th>
                    <th>DATA OSTATNIEJ OPERACJI</th>
                    <th>STAN KONTA</th>
                    <th>OPIS</th>
                    <th style="width:23%">OPCJE</th>

                </tr>
                </thead>
                <c:forEach var="account" items="${accounts}">
                    <tr>
                        <td><strong>${account.name}</strong></td>
                        <td>${account.date}</td>
                        <td>${account.value}</td>
                        <td>${account.description}</td>
                        <td>
                            <a href="/opacc/histid/${account.id}" class="btn btn-success">HIS</a>
                            <a href="/acc/edit/${account.id}" class="btn btn-success">EDY</a>
                            <a href="/acc/delete/${account.id}" class="btn btn-danger">USUŃ</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td><a href="/" class="btn btn-warning" style="width:100%">MENU</a></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><a href="/acc/add" class="btn btn-warning" style="width: 87%">+</a></td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>

