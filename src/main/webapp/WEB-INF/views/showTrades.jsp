<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TRANSAKCJE AKCJE</title>
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
                    <th>Trans</th>
                    <th>Rozl</th>
                    <th>Typ</th>
                    <th>Nazwa</th>
                    <th>ISIN</th>
                    <th>Cena</th>
                    <th>Liczba</th>
                    <th>Prowizja</th>
                    <th>Wartość</th>
                    <th>Opis</th>
                    <th style="width:20%">Zmiany</th>

                </tr>
                <c:forEach var="trade" items="${trades}">
                    <tr>
                        <td><strong>${trade.tradeDate}</strong></td>
                        <td>${trade.settlementDate}</td>
                        <td>${trade.transType}</td>
                        <td>${trade.equity.name}</td>
                        <td>${trade.equity.isin}</td>
                        <td>${trade.price}</td>
                        <td>${trade.number}</td>
                        <td>${trade.commision}</td>
                        <td>${trade.value}</td>
                        <td>${trade.description}</td>
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


