<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>KONTA</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>

<body>
<div class=leftright>
    <h3 class="header">TRANSAKCJE NA KONTRAKTACH</h3>
    <div class="card">
        <div class="card-body">
            <table class="table table-striped">
                <tr>
                    <th>KONTO</th>
                    <th>OPIS</th>
                    <th>OPERACJA</th>
                    <th>KWOTA</th>
                    <th>PROWIZJA</th>
                    <th>DATA</th>
                    <th>ROZLICZENIE</th>
                    <th>KOMENTARZ</th>
                    <th style="width:20%">Zmiany</th>
                </tr>
                <c:forEach var="operAcc" items="${operAccs}">
                    <tr>
                        <td><strong>${operAcc.account.name}</strong></td>
                        <td>${operAcc.account.description}</td>
                        <td>${operAcc.operAccType}</td>
                        <td>${operAcc.value}</td>
                        <td>${operAcc.commision}</td>
                        <td>${operAcc.tradeDate}</td>
                        <td>${operAcc.settlementDate}</td>
                        <td>${operAcc.description}</td>
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

