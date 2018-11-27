<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AKCJE</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>

<body>
<div class="container">
    <h3 class="header">AKCJE</h3>
    <div class="card">
        <div class="card-body">

            <table class="table table-striped">
                <tr>
                    <th>Nazwa</th>
                    <th>ISIN</th>
                    <th>Data wyceny</th>
                    <th>Cena</th>
                    <th>Liczba</th>
                    <th>Wartość</th>
                    <th>Opis</th>
                    <th style="width:20%">Zmiany</th>

                </tr>
                <c:forEach var="equity" items="${equities}">
                    <tr>
                        <td><strong>${equity.name}</strong></td>
                        <td>${equity.isin}</td>
                        <td>${equity.priceDate}</td>
                        <td>${equity.price}</td>
                        <td>${equity.numberOfShares}</td>
                        <td>${equity.value}</td>
                        <td>${equity.description}</td>
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


