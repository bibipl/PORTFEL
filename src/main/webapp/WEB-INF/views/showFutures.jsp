<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>KONTRAKTY</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>

<body>
<div class="leftright">
    <h3 class="header">KONTRAKTY TERMINOWE</h3>
    <div class="card">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Nazwa</th>
                    <th>ISIN</th>
                    <th>Data wyceny</th>
                    <th>Cena</th>
                    <th>Liczba</th>
                    <th>Ekspozycja</th>
                    <th>Data wygaśnięcia</th>
                    <th>Konto powiązane</th>
                    <th style="width:30%">Opis</th>
                    <th style="width: 15%">Zmiany</th>

                </tr>
                <c:forEach var="future" items="${futures}">
                    <tr>
                        <td><strong>${future.name}</strong></td>
                        <td>${future.isin}</td>
                        <td>${future.priceDate}</td>
                        <td>${future.price}</td>
                        <td>${future.numberOfContracts}</td>
                        <td>${future.exposure}</td>
                        <td>${future.expirationDate}</td>
                        <td>${future.account.name}</td>
                        <td>${future.description}</td>
                        <td>
                            <a href="/fut/edit/${future.id}" class="btn btn-success">EDY</a>
                            <a href="/fut/delete/${future.id}" class="btn btn-danger">USUŃ</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td><a href="/" class="btn btn-warning" style="width:100%">MENU</a></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><a href="/fut/add" class="btn btn-warning" style="width: 95%">NOWY KONTRAKT</a></td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>


