<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PORTFELE</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>

<body>
<div class=leftright>
    <h3 class="header">PORTFEL</h3>
    <h4 class="header">AKCJE</h4>
    <div class="card">
        <div class="card-body">
            <table class="table table-striped">
                <tr>
                    <th>Nazwa</th>
                    <th>ISIN</th>
                    <th>LICZBA</th>
                    <th>CENA OTW.</th>
                    <th>CENA AKT</th>
                    <th>ZMIANA %</th>
                    <th>WARTOŚĆ OTW.</th>
                    <th>WARTOŚĆ AKT</th>
                    <th>ZYSK/STRATA %</th>
                    <th>Struktura %</th>
                    <th style="width:15%">Zmiany</th>
                </tr>
                <%--###### TU KONTYNUOWAĆ !!! ##############--%>
                <c:forEach var="equityP" items="${eqPortf}">
                    <tr>
                        <td><strong>${equityP.name}</strong></td>
                        <td>${equityP.isin}</td>
                        <td>${equityP.number}</td>
                        <td>${equityP.purchasePrice}</td>
                        <td>${equityP.currentPrice}</td>
                        <td>${equityP.changePrice}</td>
                        <td>${equityP.purchaseValuation}</td>
                        <td>${equityP.currentValuation}</td>
                        <td>${equityP.changeValuation}</td>
                        <td>${equityP.percenOfThePortfolio}</td>
                        <td>
                            <a href="/portf/refresh/" class="btn btn-success">AKT</a>
                            <a href="/portf/hist/${eqTrade.id}" class="btn btn-success">HIS</a>
                        </td>
                    </tr>
                </c:forEach>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="/" class="btn btn-warning" style="width: 95%"><STRONG>MENU</STRONG></a></td>
            </table>
        </div>
    </div>
</div>
</body>
</html>





