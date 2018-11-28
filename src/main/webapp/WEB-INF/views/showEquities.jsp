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
                    <th style="width:22%">Zmiany</th>

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
                            <a href="/equ/refresh/" class="btn btn-success">AKT</a>
                            <a href="/equ/edit/${equity.id}" class="btn btn-success">EDY</a>
                            <a href="/equ/delete/${equity.id}" class="btn btn-danger">USUŃ</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td><td></td><td></td><td></td></td><td></td></td></td><td></td><td></td>
                    <td><a href="/equ/add" class="btn btn-warning" style="width: 96%">NOWA SPÓŁKA</a></td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>


