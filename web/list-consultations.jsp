<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="admintoHeader.jsp"/>
<br>

<div>
    <c:url var="linkAddForm" value="Consultation">
        <c:param name="command" value="LOADFORSELECTBOX"/>
        <c:param name="LIST_MEDECINS" value="${LIST_MEDECINS}"/>
        <c:param name="LIST_TICKETS" value="${LIST_TICKETS}"/>
    </c:url>
    <a href="${linkAddForm}" class="btn btn-success btn-trans waves-effect w-md waves-success m-b-5">
        Add Consultation
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
                    <th>Medecin</th>
                    <th>Ticket</th>
                    <th>Motif</th>
                    <th>Action</th>
                </tr>
                </thead>

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
                    <tbody>

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
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="admintoFooter.jsp"/>
