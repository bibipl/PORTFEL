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
                    <th style="width:20%">Zmiany</th>

                </tr>
                <c:forEach var="quFut" items="${quFuts}">
                    <tr>
                        <td><strong>${quFut.future.name}</strong></td>
                        <td>${quFut.future.isin}</td>
                        <td>${quFut.future.expirationDate}</td>
                        <td>${quFut.date}</td>
                        <td>${quFut.price}</td>
                        <td>
                            <a href="/acc/refresh" class="btn btn-success">Akt</a>
                            <a href="/acc/update/${account.id}" class="btn btn-success">Edy</a>
                            <a href="/acc/delete/${account.id}" class="btn btn-danger">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>


