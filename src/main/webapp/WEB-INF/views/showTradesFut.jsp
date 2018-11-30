<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>KONTRAKTY</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>

<body>
<div class=container-fluid>
    <h3 class="header">TRANSAKCJE NA KONTRAKTACH</h3>
    <TABLE class="table table">
        <td class="menbut"><a href="/" class="btn btn-warning" style="width:100%">MENU</a></td>
        <td class="menbut"><a href="/fuPortf/calculate" class="btn btn-warning" style="width: 95%">PORTFEL KONTRAKTÓW</a></td>
        <td class="menbut"><a href="/eqPortf/calculate" class="btn btn-warning" style="width: 95%">PORTFEL AKCJI</a></td>
        <td class="menbut"><a href="/cash/calculate" class="btn btn-warning" style="width: 95%">PORTFEL GOTÓWKOWY</a></td>
        <td class="menbut"><a href="/trafu/add" class="btn btn-warning" style="width: 95%"><STRONG>+</STRONG></a></td>
    </TABLE>
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
                    <th>EKSPOZYCJA</th>
                    <th>TRANSAKCJA</th>
                    <th>ROZLICZENIE</th>
                    <th>KOMENTARZ</th>
                    <th style="width:15%">OPCJE</th>

                </tr>
                <c:forEach var="fuTrade" items="${fuTrades}">
                    <tr>
                        <td><strong>${fuTrade.future.name}</strong></td>
                        <td>${fuTrade.future.isin}</td>
                        <td>${fuTrade.transFutType}</td>
                        <td>${fuTrade.price}</td>
                        <td>${fuTrade.number}</td>
                        <td>${fuTrade.commision}</td>
                        <td>${fuTrade.exposure}</td>
                        <td>${fuTrade.tradeDate}</td>
                        <td>${fuTrade.settlementDate}</td>
                        <td>${fuTrade.description}</td>
                        <td>
                            <a href="/trafu/edit/${fuTrade.id}" class="btn btn-success">EDY</a>
                            <a href="/trafu/delete/${fuTrade.id}" class="btn btn-danger">USUŃ</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>
</body>
</html>


