<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="forr" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>KONTRAKTY</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/main.css" rel="stylesheet">
</head>
<body>

<form:form method="post" modelAttribute="quotesFut">
<div class="container">

    <h3 class="header">DODAJ NOWE NOTOWANIE KONTRAKTU</h3>

    <div class="card">
        <div class="card-body">

            <div class="form-group">
                <label for="futName">NAZWA KONTRAKTU </label>
                <form:select path="future.id" items="${futures}" itemLabel="name" itemValue="id" id="futName" class="form-control"/>
                <form:errors path="future.id" element="div" cssClass="error"/>
            </div>

            <div class="form-group">
                <label for="priceId">CENA </label>
                <form:input type="number" step="0.01" path="price" id="priceId" class="form-control"/>
                <form:errors path="price" element="div" cssClass="error"/>
            </div>

            <div class="form-group">
                <label for="dateTrId">DATA </label>
                <form:input type="date" path="date" id="dateTrId" class="form-control"/>
                <form:errors path="date" element="div" cssClass="error"/>
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

