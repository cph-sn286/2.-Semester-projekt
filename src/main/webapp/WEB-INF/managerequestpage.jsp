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

        <form>
            <table class="table">
                <thead>
                <th>order_id</th>
                <th>user_id</th>
                <th>carport_id</th>
                <th>pris</th>
                <th>dato</th>
                <th>status</th>
                </thead>

                    <c:forEach var="orderlist" items="${applicationScope.orderlist}">
                <tr>
                    <td>${orderlist.order_id}</td>
                    <td>${orderlist.user_id}</td>
                    <td>${orderlist.carport_id}</td>
                    <td>${orderlist.price}</td>
                    <td>${orderlist.date}</td>
                    <td>${orderlist.status}</td>
                    <td>
                        <button class="btn btn-danger " type="submit" name="delete"
                                value="${userItem.id}">slet kunde!
                        </button>
                    </td>
                </c:forEach>
        </form>


    </jsp:body>
</t:genericpage>
