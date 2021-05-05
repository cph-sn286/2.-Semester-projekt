<%@page contentType="text/html"  pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         <h3 style="color:darkred">Oops!</h3>
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div>

            <h2><span class="badge rounded-pill  bg-danger">${pageContext.errorData.statusCode}</span></h2>
            <br>
            <p>A problem occurred accessing: <span style="color:darkred">${pageContext.errorData.requestURI} </p></div>

            <h4>${pageContext.errorData.throwable}</h4>
            <p>${pageContext.exception.message}</p>

            <c:if test="${pageContext.errorData.statusCode == 401 }">
                <h4 style="color:darkred;font-size: larger">
                    Attempt to access a protected resource without being authenticated.
                    <a href="loginpage">Please login first!</a>
                </h4>.

                </p>
            </c:if>

            <c:if test="${pageContext.errorData.statusCode == 403 }">
                <h4 style="color:darkred">
                    Attempt to call a resource you are not authorized to view!
                </h4>
            </c:if>

            <c:if test="${requestScope.problem != null }">
                <p style="color:crimson;font-size: x-large">
                   ${requestScope.problem}
                </p>
            </c:if>

            <p>${pageContext.exception}</p>
            <p>${pageContext.exception.stackTrace}</p>
            <p>${pageContext.exception.printStackTrace()}</p>

        </div>
    </jsp:body>
</t:genericpage>