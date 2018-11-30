<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="forr" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>KONTRAKTY</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/main.css" rel="stylesheet">
</head>
<body>
<form:form method="post" modelAttribute="tradeFut">
    <div class="container">

        <h3 class="header">DODAJ NOWĄ TRANSAKCJĘ NA KONTRAKTACH TERMINOWYCH</h3>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="fuNId">KONTRAKT </label>
                    <form:select path="future.id" items="${futures}" itemLabel="name" itemValue="id" id="fuNId" class="form-control"/>
                    <form:errors path="future.id" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="operTypeId">TYP OPERACJI </label>
                    <form:select path="transFutType" items="${operFuTypes}" id="operTypeId" class="form-control"/>
                    <form:errors path="transFutType" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="numId">LICZBA </label>
                    <form:input type="number" step="0.01" path="number" id="numId" class="form-control"/>
                    <form:errors path="number" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="valId">CENA </label>
                    <form:input type="number" step="0.01" path="price" id="valId" class="form-control"/>
                    <form:errors path="price" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="commId">PROWIZJA </label>
                    <form:input type="number" step="0.01" path="commision" id="commId" class="form-control"/>
                    <form:errors path="commision" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="dateTrId">DATA WYKONANIA TRANSAKCJI </label>
                    <form:input type="date" path="tradeDate" id="dateTrId" class="form-control"/>
                    <form:errors path="tradeDate" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="dateSeId">DATA ROZLICZENIA TRANSAKCJI </label>
                    <form:input type="date" path="settlementDate" id="dateSeId" class="form-control"/>
                    <form:errors path="settlementDate" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="descriptionId">OPIS </label>
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

