<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TRANSAKCJE AKCJE</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>

<body>
<div class=leftright>
    <h3 class="header">TRANSAKCJE NA AKCJACH</h3>
    <div class="card">
        <div class="card-body">
            <table class="table table-striped">
                <tr>
                    <th>Nazwa</th>
                    <th>ISIN</th>
                    <th>RODZAJ</th>
                    <th>CENA</th>
                    <th>LICZBA</th>
                    <th>PROWIZJA</th>
                    <th>WARTOŚĆ</th>
                    <th>TRANSAKCJA</th>
                    <th>ROZLICZENIE</th>
                    <th>KOMENTARZ</th>
                    <th style="width:20%">Zmiany</th>

                </tr>
                <c:forEach var="eqTrade" items="${eqTrades}">
                    <tr>
                        <td><strong>${eqTrade.equity.name}</strong></td>
                        <td>${eqTrade.equity.isin}</td>
                        <td>${eqTrade.transEquType}</td>
                        <td>${eqTrade.price}</td>
                        <td>${eqTrade.number}</td>
                        <td>${eqTrade.commision}</td>
                        <td>${eqTrade.value}</td>
                        <td>${eqTrade.tradeDate}</td>
                        <td>${eqTrade.settlementDate}</td>
                        <td>${eqTrade.description}</td>
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


