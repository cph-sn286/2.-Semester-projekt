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
        Request siden


        <table class="table">
        <thead>
        <th>order_id</th>
        <th>user_id</th>
        <th>carport_id</th>
        <th>pris</th>
        <th>dato</th>
        <th>status</th>
        </thead>

        <c:forEach var="order" items="${applicationScope.orderList}">
            <tr>
            <td>${order.order_id}</td>
            <td>${order.user_id}</td>
            <td>${order.carport_id}</td>
            <td>${order.price}</td>
            <td>${order.date}</td>
            <td>${order.status}</td>
            <td>
                <div>
                    <form action="${pageContext.request.contextPath}/fc/checkorderpage">

                        <button class="btn btn-dark " type="submit" name="order_id"
                                value="${order.order_id}">check ordre
                        </button>
                    </form>

                    <form action="">

                        <button class="btn btn-success " type="submit" name="accept"
                                value="${order.order_id}">accepter ordre
                        </button>
                    </form>

                    <form action="">
                        <button class="btn btn-danger " type="submit" name="delete"
                                value="${order.order_id}">slet ordre
                        </button>
                    </form>

                </div>
            </td>
        </c:forEach>


    </jsp:body>
</t:genericpage>
