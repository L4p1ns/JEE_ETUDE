<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="admintoHeader.jsp"/>
<br>
<div>
    <button type="submit" value="Add Medecin"
            class="btn btn-success btn-trans waves-effect w-md waves-success m-b-5"
            onclick="window.location.href='add-medecin-form.jsp'; return false;">
        Add Medecin
    </button>
</div>

<div class="row">
    <div class="col-12">
        <div class="card-box table-responsive">
            <h4 class="m-t-0 header-title">Medecin</h4>

            <table id="datatable" class="table table-bordered">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Matricule</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Date De Naissance</th>
                    <th>Sexe</th>
                    <th>Telephone</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                </thead>

                <c:forEach var="medecin" items="${LIST_MEDECIN}">

                    <!-- set up a link for each patient -->
                    <c:url var="tempLink" value="/Medecin">
                        <c:param name="command" value="LOAD"/>
                        <c:param name="patientId" value="${medecin.id}"/>
                    </c:url>

                    <!-- set up a link to delete a patient -->
                    <c:url var="deleteLink" value="PatientController">
                        <c:param name="command" value="DELETE"/>
                        <c:param name="patientId" value="${medecin.id}"/>
                    </c:url>
                    <tbody>
                    <tr>
                        <td> ${medecin.id} </td>
                        <td> ${medecin.matricule} </td>
                        <td> ${medecin.nom} </td>
                        <td> ${medecin.prenom} </td>
                        <td> ${medecin.dateNaissance} </td>
                        <td> ${medecin.sexe} </td>
                        <td> ${medecin.tel} </td>
                        <td> ${medecin.email} </td>
                        <td>
                            <a href="${tempLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure you want to delete this medecin?'))) return false">
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
