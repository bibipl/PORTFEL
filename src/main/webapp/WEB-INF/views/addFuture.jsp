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
<c:if test="${not empty orders.planStartDate}">
    <fmt:parseDate value="${orders.planStartDate}" pattern="yyyy-MM-dd" var="parsedStartDate" type="date" />
    <fmt:formatDate value="${parsedStartDate}" var="newParsedPlanDate" type="date" pattern="dd.MM.yyyy" />
</c:if>
<form:form method="post" modelAttribute="future">

    <div class="container">

        <h3 class="header">DODAJ NOWY KONTRAKT TERMINOWY</h3>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="nameId">NAZWA </label>
                    <form:input type="text" path="name" id="nameId" class="form-control"/>
                    <form:errors path="name" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="isinId">ISIN </label>
                    <form:input type="text" path="isin" id="isinId" class="form-control"/>
                    <form:errors path="isin" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="multiId">MNOŻNIK </label>
                    <form:input type="number" step="0.01" path="multiplier" id="multiId" class="form-control" />
                    <form:errors path="multiplier" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="dateId">DATA WYGAŚNIĘCIA </label>
                    <form:input type="date" path="expirationDate" id="dateId" class="form-control"/>
                    <form:errors path="expirationDate" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="accId">KONTO ROZLICZENIOWE </label>
                    <form:select path="account.id" items="${accounts}" itemLabel="name" itemValue="id" id="accId" class="form-control"/>
                    <form:errors path="account.id" element="div" cssClass="error"/>
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

