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
                    <th style="width:15%">Zmiany</th>

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


