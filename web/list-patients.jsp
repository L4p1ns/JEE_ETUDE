<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="admintoHeader.jsp"/>
<br>

<div>
    <button type="submit"
            class="btn btn-success btn-trans waves-effect w-md waves-success m-b-5"
            onclick="window.location.href='add-patient-form.jsp'; return false;">
        Add Patient
    </button>
</div>

<div class="row">
    <div class="col-12">
        <div class="card-box table-responsive">
            <h4 class="m-t-0 header-title">Patient</h4>

            <table id="datatable" class="table table-bordered">
                <thead>
                <tr>
                    <th>Matricule</th>
                    <th>Nom</th>
                    <th>Date De Naissance</th>
                    <th>Telephone</th>
                    <th>Sexe</th>
                    <th>Groupe Sanguin</th>
                    <th>Action</th>
                </tr>
                </thead>

                <c:forEach var="tempPatient" items="${PATIENT_LIST}">

                    <!-- set up a link for each patient -->
                    <c:url var="tempLink" value="PatientController">
                        <c:param name="command" value="LOAD"/>
                        <c:param name="patientId" value="${tempPatient.matricule}"/>
                    </c:url>

                    <!-- set up a link to delete a patient -->
                    <c:url var="deleteLink" value="PatientController">
                        <c:param name="command" value="DELETE"/>
                        <c:param name="patientId" value="${tempPatient.matricule}"/>
                    </c:url>
                    <%-- Send id patient to Caissier--%>
                    <c:url var="loadPatienId" value="Ticket">
                        <c:param name="command" value="LOADFORSELECTBOX" />
                        <c:param name="patienId" value="${tempPatient.matricule}" />
                    </c:url>
                    <tbody>

                    <tr>
                        <td> ${tempPatient.matricule} </td>
                        <td> ${tempPatient.nom} </td>
                        <td> ${tempPatient.dateNaissance} </td>
                        <td> ${tempPatient.tel} </td>
                        <td> ${tempPatient.sexe} </td>
                        <td> ${tempPatient.groupeSanguin} </td>
                        <td>
                            <a href="${loadPatienId}">Ticket</a>
<%--                            <a href="${tempLink}">Update</a>--%>

<%--                            <a href="${deleteLink}"--%>
<%--                               onclick="if (!(confirm('Are you sure you want to delete this patient?'))) return false">--%>
<%--                                Delete</a>--%>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<jsp:include page="admintoFooter.jsp"/>



