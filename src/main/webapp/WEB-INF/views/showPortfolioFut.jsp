<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>KONTRAKTY</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>

<body>
<div class="container-fluid">
    <h3 class="header">KONTRAKTY TERMINOWE</h3>
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
                        <th>ZMIANA PTS</th>
                        <th>POCZ EKSPOZYCJA</th>
                        <th>AKT EKPOZYCJA</th>
                        <th>ZYSK/STRATA PLN</th>
                        <th>Struktura %</th>
                        <th style="width:5%">OPCJE</th>
                    </tr>
                </thead>
                <c:forEach var="futureP" items="${fuPortf}">
                    <tr>
                        <td><strong>${futureP.name}</strong></td>
                        <td>${futureP.isin}</td>
                        <td>${futureP.numberOfContracts}</td>
                        <td>${futureP.purchasePrice}</td>
                        <td>${futureP.price}</td>
                        <td>${futureP.changepts}</td>
                        <td>${futureP.purchaseExposure}</td>
                        <td>${futureP.exposure}</td>
                        <td>${futureP.changeValuation} PLN</td>
                        <td>${futureP.percentOfTheExposure} %</td>
                        <td>
                            <a href="/trafu/histid/${futureP.id}" class="btn btn-success">HISTORIA</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td class="sum">${sum.name}</td>
                    <td class="sum"></td>
                    <td class="sum"></td>
                    <td class="sum"></td>
                    <td class="sum"></td>
                    <td class="sum"></td>
                    <td class="sum">${sum.purchaseExposure}</td>
                    <td class="sum">${sum.exposure}</td>
                    <td class="sum">${sum.changeValuation} PLN</td>
                    <td class="sum">${sum.percentOfTheExposure} %</td>
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
                <td><a href="/" class="btn btn-warning" style="width: 100%"><STRONG>MENU</STRONG></a></td>
            </table>
        </div>
    </div>
</div>
</body>
</html>





