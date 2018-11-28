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
    <h3 class="header">NOTOWANIA AKCJI</h3>
    <div class="card">
        <div class="card-body">

            <table class="table table-striped">
                <tr>
                    <th>Nazwa</th>
                    <th>ISIN</th>
                    <th>Data wyceny</th>
                    <th>Cena</th>
                    <th style="width:22%">Zmiany</th>

                </tr>
                <c:forEach var="quEq" items="${quEqs}">
                    <tr>
                        <td><strong>${quEq.equity.name}</strong></td>
                        <td>${quEq.equity.isin}</td>
                        <td>${quEq.date}</td>
                        <td>${quEq.price}</td>
                        <td>
                            <a href="/eqQ/refresh/" class="btn btn-success">AKT</a>
                            <a href="/eqQ/edit/${quEq.id}" class="btn btn-success">EDY</a>
                            <a href="/eqQ/delete/${quEq.id}" class="btn btn-danger">USUŃ</a>
                        </td>
                    </tr>
                </c:forEach>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="/eqQ/add" class="btn btn-warning" style="width: 96%"><STRONG>+</STRONG></a></td>
            </table>
        </div>
    </div>
</div>
</body>
</html>


