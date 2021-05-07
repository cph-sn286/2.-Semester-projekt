<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div id="body" class="img-fluid" style="max-width: 200px">
            <img src="${pageContext.request.contextPath}/images/fog-logo1.svg" class="img-fluid mb-4"/>
        </div>

        <div>
            <h2>Byg carport siden</h2>

            <div style="margin-top: 3em;margin-bottom: 3em;">
                Velkommen til Fog's byg selv carport side, sammensæt din carport her:
            </div>


            <form method="post"action="confirmationpage">

            <label for="bredde"> Vælg en bredde </label>
            <select name="bredde" id="bredde">
                <option value="240">240cm</option>
                <option value="270">270cm</option>
                <option value="300">300cm</option>
                <option value="360">360cm</option>
                <option value="390">390cm</option>
            </select>

            <br>


            <label for="længde"> Vælg en længde </label>
            <select name="længde" id="længde">
                <option value="240">240cm</option>
                <option value="270">270cm</option>
                <option value="300">300cm</option>
                <option value="360">360cm</option>
                <option value="390">390cm</option>
            </select>

            <br>


            <input type="checkbox"id="redskabsskur"name="redskabsskur"value="redskabsskur">
            <label for="redskabsskur"> Vil du tilvælge et redskabsskur?</label>

            <br>


            <button type="submit">Send forespørgsel</button>

            </form>

            <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">This is what you can do,
                    since your are logged in as an employee</p>
                 <p><a href="fc/employeepage">Employee Page</a>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">This is what you can do, since your
                    are logged in as a customer</p>
                <p><a href="fc/customerpage">Customer Page</a>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>