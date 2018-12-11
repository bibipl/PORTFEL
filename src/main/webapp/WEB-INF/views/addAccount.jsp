<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="forr" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>KONTA</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/main.css" rel="stylesheet">
</head>
<body>
<form:form method="post" modelAttribute="account">

    <div class="container">

        <h3 class="header">DODAJ NOWE KONTO</h3>

        <div class="card">
            <div class="card-body">
                <div class="form-group">
                    <label for="nameId">Nazwa </label>
                    <form:input type="text" path="name" id="nameId" class="form-control"/>
                    <form:errors path="name" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="descriptionId">Opis </label>
                    <form:textarea path="description" rows="3" cols="30" id="descriptionId" class="form-control"/>
                    <form:errors path="description" element="div" cssClass="error"/>
                </div>
                <table style="width: 100%;">
                <tr>
                <td><input type="submit" class="btn btn-primary" style="width: 100%" value="ZATWIERDZAM"></td>
                    <td><a href="/" class="btn btn-secondary" style="width: 100%">ANULUJĘ</a></td>
                </tr>
                </table>
            </div>
        </div>

    </div>
</form:form>
</body>
</html>
