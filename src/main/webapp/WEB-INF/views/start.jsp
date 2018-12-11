<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <style>
        td {
            width: 200px;
        }
    </style>
</head>
<body class="bcg">
    <img src="">
    <h2 style="text-align: center">M E N U</h2>
    <h3 style="text-align: center">P O R T F E L   I N W E S T Y C Y J N Y</h3>

<div class=container>
        <div class="card-body">
            <TABLE>
                <tr>
                    <td><a href="/acc/list/" class="btn btn-warning width" style="width: 100%">Konta</a></td>
                    <td><a href="/equ/list/" class="btn btn-warning" style="width: 100%">Akcje</a></td>
                    <td><a href="/fut/list/" class="btn btn-warning" style="width: 100%">Kontrakty Terminowe</a></td>
                    <td><a href="/eqQ/list"  class="btn btn-danger" style="width: 100%">Notowania Akcji</a></td>


                </tr>
                <tr>
                    <td><a href="/opacc/list/" class="btn btn-primary width" style="width: 100%">Operacja na kontach</a></td>
                    <td><a href="/traeq/list/" class="btn btn-primary width" style="width: 100%">Transakcje akcje</a></td>
                    <td><a href="/trafu/list/" class="btn btn-primary width" style="width: 100%">Transakcje futures</a></td>
                    <td><a href="/fuQ/list" class="btn btn-danger width" style="width: 100%">Notowania Kontraktów</a></td>


                </tr>
                <tr>
                    <td><a href="/cash/calculate/" class="btn btn-secondary width" style="width: 100%">PORTFEL GOTÓWKA</a></td>
                    <td><a href="/eqPortf/calculate/" class="btn btn-secondary width" style="width: 100%">PORTFEL AKCJI</a></td>
                    <td><a href="/fuFifo/calculate/" class="btn btn-secondary width" style="width: 100%">PORTFEL KONTRAKTÓW</a></td>

                </tr>
                <tr>
                    <td><a href="/acc/add/" class="btn btn-success width" style="width: 100%">+NOWE KONTO</a><br></td>
                    <td><a href="/equ/add/" class="btn btn-success width" style="width: 100%">+NOWA AKCJA</a><br></td>
                    <td><a href="/fut/add/" class="btn btn-success width" style="width: 100%">+NOWY KONTRAKT</a><br></td>
                </tr>
            </TABLE>
    </div>
</div>
</body>
</html>
