<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="admintoHeader.jsp"/>
<br>
<div>
    <c:url var="linkAddForm" value="Specialite">
        <c:param name="command" value="LOADPERSONNEL"/>
        <c:param name="LIST_PERSONNEL" value="${LIST_PERSONNEL}"/>
    </c:url>
    <a href="${linkAddForm}" class="btn btn-success btn-trans waves-effect w-md waves-success m-b-5">
        Add Specialite
    </a>
</div>

<div class="row">
    <div class="col-12">
        <div class="card-box table-responsive">
            <h4 class="m-t-0 header-title">Specialite</h4>

            <table id="datatable" class="table table-bordered">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Tarif</th>
                    <th>Personnel</th>
                    <th>Action</th>
                </tr>
                </thead>

                <c:forEach var="specialite" items="${SPECIALTE_LIST}">
                    <!-- set up a link for each patient -->
                    <c:url var="tempLink" value="Specialite">
                        <c:param name="command" value="LOAD"/>
                        <c:param name="specialiteId" value="${specialite.id}"/>
                    </c:url>

                    <!-- set up a link to delete a patient -->
                    <c:url var="deleteLink" value="Specialite">
                        <c:param name="command" value="DELETE"/>
                        <c:param name="specialiteId" value="${specialite.id}"/>
                    </c:url>
                    <tbody>
                    <tr>
                        <td> ${specialite.id} </td>
                        <td> ${specialite.nom} </td>
                        <td> ${specialite.tarif} </td>
                        <td> ${specialite.personnel_id} </td>
                        <td>
                            <a href="${tempLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure you want to delete this specialite?'))) return false">
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
