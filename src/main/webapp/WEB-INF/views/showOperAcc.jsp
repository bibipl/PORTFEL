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
    <h3 class="header">OPERACJE NA KONTACH</h3>
    <TABLE class="table table">
        <td class="menbut"><a href="/" class="btn btn-warning" style="width:100%">MENU</a></td>
        <td class="menbut"><a href="/cash/calculate" class="btn btn-warning" style="width: 95%">PORTFEL GOTÓWKOWY</a></td>
        <td class="menbut"><a href="/fuFifo/calculate/" class="btn btn-warning" style="width: 95%">PORTFEL KONTRAKTÓW</a></td>
        <td class="menbut"><a href="/eqPortf/calculate" class="btn btn-warning" style="width: 95%">PORTFEL AKCJI</a></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td class="menbut"><a href="/opacc/add" class="btn btn-warning" style="width: 95%"><STRONG>+</STRONG></a></td>
    </TABLE>
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
                    <th style="width:15%">OPCJE</th>
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
                            <a href="/opacc/edit/${operAcc.id}" class="btn btn-success">EDY</a>
                            <a href="/opacc/delete/${operAcc.id}" class="btn btn-danger">USUŃ</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>
</body>
</html>

