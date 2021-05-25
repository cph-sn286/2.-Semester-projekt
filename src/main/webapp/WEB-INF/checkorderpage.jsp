<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Employee Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>

        Checking order: ${sessionScope.order_id}

        Stykliste
        <form>
            <table class="table">
                <thead>
                <th>name</th>
                <th>length</th>
                <th>amount</th>
                </thead>

                    <c:forEach var="carportItem" items="${applicationScope.billOfMaterials.billOfMaterialsItemList}">
                <tr>
                    <td>${carportItem.name}</td>
                    <td>${carportItem.length}</td>
                    <td>${carportItem.amount}</td>
                </c:forEach>
        </form>


    </jsp:body>
</t:genericpage>
