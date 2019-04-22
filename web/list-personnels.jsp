<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="admintoHeader.jsp"/>
<br>
<div>
    <button type="submit"
            class="btn btn-success btn-trans waves-effect w-md waves-success m-b-5"
            onclick="window.location.href='add-personnel-form.jsp'; return false;">
        Add Personnel
    </button>
</div>

<div class="row">
    <div class="col-12">
        <div class="card-box table-responsive">
            <h4 class="m-t-0 header-title">Personnel</h4>

            <table id="datatable" class="table table-bordered">
                <thead>
                <tr>
                    <th>Matricule</th>
                    <th>Nom</th>
                    <th>Date De Naissance</th>
                    <th>Telephone</th>
                    <th>Sexe</th>
                    <th>Email</th>
                    <th>Domaine</th>
                    <th>Type</th>
                    <th>Action</th>
                </tr>
                </thead>

                <c:forEach var="personnel" items="${PERSONNEL_LIST}">

                    <c:url var="tempLink" value="Personnel">
                        <c:param name="command" value="LOAD"/>
                        <c:param name="personnelId" value="${personnel.id}"/>
                    </c:url>

                    <c:url var="deleteLink" value="Personnel">
                        <c:param name="command" value="DELETE"/>
                        <c:param name="personnelId" value="${personnel.id}"/>
                    </c:url>
                    <tbody>

                    <tr>
                        <td> ${personnel.matricule} </td>
                        <td> ${personnel.nom} </td>
                        <td> ${personnel.dateNaissance} </td>
                        <td> ${personnel.tel} </td>
                        <td> ${personnel.sexe} </td>
                        <td> ${personnel.email} </td>
                        <td> ${personnel.domaine} </td>
                        <td> ${personnel.type} </td>
                        <td>
                            <a href="${tempLink}" class="btn btn-secondary btn-trans waves-effect w-md m-b-5">Update</a>
                            <a href="${deleteLink}" class="btn btn-danger btn-trans waves-effect w-md waves-danger m-b-5"
                               onclick="if (!(confirm('Are you sure you want to delete this personnel?'))) return false">
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
