<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Consultation</title>
    <style type="text/css">
        <jsp:include page="header.jsp" />
    </style>

    <%--<link type="text/css" rel="stylesheet" href="css/style.css">--%>
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>GesCons</h2>
    </div>
</div>

<div id="container">

    <div id="content">
        <c:url var="linkAddForm" value="Consultation">
            <c:param name="command" value="LOADFORSELECTBOX"/>
            <c:param name="LIST_MEDECINS" value="${LIST_MEDECINS}"/>
            <c:param name="LIST_TICKETS" value="${LIST_TICKETS}"/>
        </c:url>
        <a href="${linkAddForm}" class="add-patient-button">
            Add Consultation
        </a>
        <br/>
        <table>

            <tr>
                <th>Id</th>
                <th>Date Prise</th>
                <th>Medecin</th>
                <th>Ticket</th>
                <th>Motif</th>
                <th>Action</th>
            </tr>

            <c:forEach var="consultation" items="${LIST_CONSULTATIONS}">

                <!-- set up a link for each patient -->
                <c:url var="tempLink" value="/Consultation">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="consultationId" value="${consultation.id}"/>
                </c:url>

                <!-- set up a link to delete a patient -->
                <c:url var="deleteLink" value="/Consultation">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="patientId" value="${consultation.id}"/>
                </c:url>

                <tr>
                    <td> ${consultation.id} </td>
                    <td> ${consultation.date} </td>
                    <td> ${consultation.medecin_id} </td>
                    <td> ${consultation.ticket_id} </td>
                    <td> ${consultation.motif} </td>

                    <td>
                        <a href="${tempLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this consultation?'))) return false">
                            Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
<jsp:include page="footer.jsp" />
</html>
