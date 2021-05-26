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
                <th>price</th>
                </thead>

                <c:forEach var="carportItem" items="${applicationScope.billOfMaterials.billOfMaterialsItemList}">
                <tr>
                    <td>${carportItem.name}</td>
                    <td>${carportItem.length}</td>
                    <td>${carportItem.amount}</td>
                    <td>${carportItem.price}</td>
                </tr>
                </c:forEach>
                <br></br>
                <tr>

                    <td>Total Price:</td>
                    <td>${applicationScope.totalPrice},-</td>
                    <td>sugested price:</td>
                    <td>
                        <input id="suggestedPrice" name="suggestedPrice" type="number"
                               value="${applicationScope.totalPrice}">
                        <label for="suggestedPrice"></label>

                    </td>
                </tr>

        </form>


    </jsp:body>
</t:genericpage>
