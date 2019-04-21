<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="admintoHeader.jsp"/>
<br>

<div>
    <button type="submit"
            class="btn btn-success btn-trans waves-effect w-md waves-success m-b-5"
            onclick="window.location.href='add-caissier-form.jsp'; return false;">
        Add Caissier
    </button>
</div>

<div class="row">
    <div class="col-12">
        <div class="card-box table-responsive">
            <h4 class="m-t-0 header-title">Caissier</h4>

            <table id="datatable" class="table table-bordered">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Matricule</th>
                    <th>Nom</th>
                    <th>Date De Naissance</th>
                    <th>Sexe</th>
                    <th>Telephone</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                </thead>

                <c:forEach var="caissier" items="${LIST_CAISSIER}">

                    <!-- set up a link for each patient -->
                    <c:url var="tempLink" value="/Caissier">
                        <c:param name="command" value="LOAD"/>
                        <c:param name="patientId" value="${caissier.id}"/>
                    </c:url>

                    <!-- set up a link to delete a patient -->
                    <c:url var="deleteLink" value="Caissier">
                        <c:param name="command" value="DELETE"/>
                        <c:param name="patientId" value="${caissier.id}"/>
                    </c:url>
                    <tbody>
                    <tr>
                        <td> ${caissier.id} </td>
                        <td> ${caissier.matricule} </td>
                        <td> ${caissier.nom} </td>
                        <td> ${caissier.dateNaissance} </td>
                        <td> ${caissier.sexe} </td>
                        <td> ${caissier.tel} </td>
                        <td> ${caissier.email} </td>
                        <td>
                            <a href="${tempLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure you want to delete this caissier?'))) return false">
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
