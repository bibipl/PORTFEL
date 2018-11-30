<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PORTFELE</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>

<body>
<div class="container-fluid">
    <h3 class="header">AKCJE</h3>
    <div class="card">
        <div class="card-body">
            <table class="table table">
                <thead class="thead-light">
                    <tr>
                        <th>Nazwa</th>
                        <th>ISIN</th>
                        <th>LICZBA</th>
                        <th>CENA OTW.</th>
                        <th>CENA AKT</th>
                        <th>ZMIANA %</th>
                        <th>WARTOŚĆ OTW.</th>
                        <th>WARTOŚĆ AKT</th>
                        <th>ZYSK/STRATA PLN</th>
                        <th>Struktura %</th>
                        <th style="width:5%">OPCJE</th>
                    </tr>
                </thead>
                <c:forEach var="equityP" items="${eqPortf}">
                    <tr>
                        <td><strong>${equityP.name}</strong></td>
                        <td>${equityP.isin}</td>
                        <td>${equityP.number}</td>
                        <td>${equityP.purchasePrice}</td>
                        <td>${equityP.currentPrice}</td>
                        <td>${equityP.changePrice} %</td>
                        <td>${equityP.purchaseValuation}</td>
                        <td>${equityP.currentValuation}</td>
                        <td>${equityP.changeValuation}</td>
                        <td>${equityP.percenOfThePortfolio} %</td>
                        <td>
                            <a href="/traeq/histid/${equityP.id}" class="btn btn-success">HISTORIA</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td class="sum"><strong>${sum.name}</strong></td>
                    <td class="sum"></td>
                    <td class="sum"></td>
                    <td class="sum"></td>
                    <td class="sum"></td>
                    <td class="sum">${sum.changePrice}%</td>
                    <td class="sum">${sum.purchaseValuation}</td>
                    <td class="sum">${sum.currentValuation}</td>
                    <td class="sum">${sum.changeValuation} PLN</td>
                    <td class="sum">${sum.percenOfThePortfolio}%</td>
                    <td class="sum"></td>
                </tr>
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
                <td><a href="/" class="btn btn-warning" style="width: 100%">MENU</a></td>
            </table>
        </div>
    </div>
</div>
</body>
</html>





