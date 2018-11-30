<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>GOTÓWKA</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>

<body>
<div class="container-fluid">
    <h3 class="header">GOTÓWKA</h3>
    <div class="card">
        <div class="card-body">
            <table class="table table">
                <thead class="thead-light">
                    <tr>
                        <th>NAZWA KONTA</th>
                        <th>DATA OSTATNIEJ OPERACJI</th>
                        <th>STAN KONTA</th>
                        <th>STRUKTURA PORTFELA</th>
                        <th>OPIS</th>
                        <th style="width:5%">OPCJE</th>

                    </tr>
                </thead>
                <c:forEach var="account" items="${cashPortf}">
                    <tr>
                        <td><strong>${account.name}</strong></td>
                        <td>${account.date}</td>
                        <td>${account.value}</td>
                        <td>${account.partOfTotalCash} %</td>
                        <td>${account.description}</td>
                        <td>
                            <a href="/opacc/histid/${account.id}" class="btn btn-success">HISTORIA</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td class="sum">${suma.name}</td>
                    <td class="sum">${suma.date}</td>
                    <td class="sum">${suma.value}</td>
                    <td class="sum">${suma.partOfTotalCash} %</td>
                    <td class="sum">${suma.description}</td>
                    <td class="sum"></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><a href="/" class="btn btn-warning" style="width:100%">MENU</a></td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>


