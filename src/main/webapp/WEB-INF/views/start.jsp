<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <style>
        td {width: 200px;}
    </style>
</head>
    <body>

            <%--
            <div class="dropdown show">
                <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    TABELE
                </a>

                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="/acc/list">Konta</a>
                    <a class="dropdown-item" href="/equ/list">Akcje</a>
                    <a class="dropdown-item" href="/fut/list">Kontrakty Terminowe</a>
                </div> <br>
            </div>--%>
            <div class="container">
            <TABLE>
                <tr>
                    <td><a href="/acc/list/">Konta</a></td>
                    <td><a href="/equ/list/">Akcje</a></td>
                    <td><a href="/fut/list/">Kontrakty Terminowe</a></td>
                    <td><a href="/portf/calculate/">PORTFEL</a></td>

                </tr>
                <tr>
                    <td><a href="/opacc/list/">Operacja na kontach</a></td>
                    <td><a href="/traeq/list/">Transakcje akcje</a></td>
                    <td><a href="/trafu/list/">Transakcje futures</a></td>
                </tr>
                <tr>
                    <td><a href="/acc/add/">+NOWE KONTO</a><br></td>
                    <td><a href="/equ/add/">+NOWA AKCJA</a><br></td>
                    <td><a href="/fut/add/">+NOWY KONTRAKT</a><br></td>
                </tr>
            </TABLE>
                <br><br><br>
            <div class="container">
                <a href="/acc/list">Konta</a><br>
                <a href="/equ/list">Akcje</a><br>
                <a href="/fut/list">Kontrakty Terminowe</a><br>
                <a href="/traeq/list">Transakcje akcje</a><br>
                <a href="/trafu/list">Transakcje futures</a><br>
                <a href="/opacc/list">Operacja na kontach</a><br>
                <a href="/eqQ/list">Notowania Akcji</a><br>
                <a href="/fuQ/list">Notowania Kontraktów</a><br>
                <a href="/acc/add">Dodaj nowe konto</a><br>
            </div>
    </body>
</html>
