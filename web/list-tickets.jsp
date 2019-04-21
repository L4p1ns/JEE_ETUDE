<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="admintoHeader.jsp"/>
<br>

<div>
    <c:url var="linkAddForm" value="Ticket">
        <c:param name="command" value="LOADFORSELECTBOX"/>
        <c:param name="LIST_PERSONNELS" value="${LIST_PERSONNELS}"/>
        <c:param name="LIST_PATIENTS" value="${LIST_PATIENTS}"/>
        <c:param name="LIST_SPECIALITES" value="${LIST_SPECIALITES}"/>
    </c:url>
    <a href="${linkAddForm}" class="btn btn-success btn-trans waves-effect w-md waves-success m-b-5">
        Add Ticket
    </a>

</div>

<div class="row">
    <div class="col-12">
        <div class="card-box table-responsive">
            <h4 class="m-t-0 header-title">Consultation</h4>

            <table id="datatable" class="table table-bordered">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Date Prise</th>
                    <th>Patient</th>
                    <th>Specialite</th>
                    <th>Caissier</th>
                    <th>Action</th>
                </tr>
                </thead>

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

                    <tbody>

                    <tr>
                        <td> ${ticket.id} </td>
                            <%--<td> ${ticket.date_prise} </td>--%>
                        <td> ${ticket.datePrise} </td>
                        <td> ${ticket.patient} </td>
                        <td> ${ticket.specialite} </td>
                        <td> ${ticket.personnel} </td>

                        <td>
                            <a href="${tempLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure you want to delete this ticket?'))) return false">
                                Delete</a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="admintoFooter.jsp"/>
