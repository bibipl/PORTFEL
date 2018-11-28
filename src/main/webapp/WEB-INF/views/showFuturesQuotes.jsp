<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>KONTRAKTY</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>

<body>
<div class="container">
    <h3 class="header">NOTOWANIA KONTRAKTÓW</h3>
    <div class="card">
        <div class="card-body">

            <table class="table table-striped">
                <tr>
                    <th>Nazwa</th>
                    <th>ISIN</th>
                    <th>NOTOWANE DO</th>
                    <th>DATA WYCENY</th>
                    <th>CENA</th>
                    <th style="width:22%">Zmiany</th>

                </tr>
                <c:forEach var="quFut" items="${quFuts}">
                    <tr>
                        <td><strong>${quFut.future.name}</strong></td>
                        <td>${quFut.future.isin}</td>
                        <td>${quFut.future.expirationDate}</td>
                        <td>${quFut.date}</td>
                        <td>${quFut.price}</td>
                        <td>
                            <a href="/fuQ/refresh" class="btn btn-success">AKT</a>
                            <a href="/fuQ/edit/${quFut.id}" class="btn btn-success">EDY</a>
                            <a href="/fuQ/delete/${quFut.id}" class="btn btn-danger">USUŃ</a>
                        </td>
                    </tr>
                </c:forEach>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="/fuQ/add" class="btn btn-warning" style="width: 96%"><STRONG>+</STRONG></a></td>
            </table>
        </div>
    </div>
</div>
</body>
</html>


