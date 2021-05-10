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
                <th>material_id</th>
                <th>name</th>
                <th>sizes_id</th>
                <th>description</th>
                <th>price</th>
                </thead>

                    <c:forEach var="materials" items="${applicationScope.orderList}">
                <tr>
                    <td>${materials.material_id}</td>
                    <td>${materials.name}</td>
                    <td>${materials.sizes_id}</td>
                    <td>${materials.description}</td>
                    <td>${materials.price}</td>
                    <td>
                        <button class="btn btn-secondary " type="submit" name="delete"
                                value="${userItem.id}">rediger materiale
                        </button>
                    </td>
                </c:forEach>
        </form>


    </jsp:body>
</t:genericpage>