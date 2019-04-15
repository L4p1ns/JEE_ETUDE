<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Tickets</title>
    <style>
        <%--<jsp:include page="header.jsp" />--%>
    </style>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>GesCons</h2>
    </div>
</div>

<div id="container">

    <div id="content">
        <c:url var="linkAddForm" value="Ticket">
            <c:param name="command" value="LOADFORSELECTBOX"/>
            <c:param name="LIST_PERSONNELS" value="${LIST_PERSONNELS}"/>
            <c:param name="LIST_PATIENTS" value="${LIST_PATIENTS}"/>
            <c:param name="LIST_CAISSIERS" value="${LIST_CAISSIERS}"/>
            <c:param name="LIST_SPECIALITES" value="${LIST_SPECIALITES}"/>
        </c:url>
        <a href="${linkAddForm}" class="add-patient-button">
            Add Ticket
        </a>
        <br />
        <table>

            <tr>
                <th>Id</th>
                <%--<th>Date Prise</th>--%>
                <th>Montant</th>
                <th>Action</th>
            </tr>

            <c:forEach var="ticket" items="${LIST_TICKETS}">

                <!-- set up a link for each patient -->
                <c:url var="tempLink" value="/Ticket">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="ticketId" value="${ticket.id}"/>
                </c:url>

                <!-- set up a link to delete a patient -->
                <c:url var="deleteLink" value="/Ticket">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="patientId" value="${ticket.id}"/>
                </c:url>

                <tr>
                    <td> ${ticket.id} </td>
                    <%--<td> ${ticket.date_prise} </td>--%>
                    <td> ${ticket.montant} </td>

                    <td>
                        <a href="${tempLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
                            Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
<%--<jsp:include page="footer.jsp" />--%>
</html>
