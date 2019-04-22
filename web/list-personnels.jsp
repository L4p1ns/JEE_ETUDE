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
    <div class="col">

        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a href="#home1" data-toggle="tab" aria-expanded="false" class="nav-link active">
                    Personnels
                </a>
            </li>
            <li class="nav-item">
                <a href="#profile1" data-toggle="tab" aria-expanded="true" class="nav-link">
                    Caissiers
                </a>
            </li>
            <li class="nav-item">
                <a href="#messages1" data-toggle="tab" aria-expanded="false" class="nav-link">
                    Medecins
                </a>
            </li>
        </ul>

        <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade show active" id="home1">
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
                                    <a href="${deleteLink}"
                                       class="btn btn-danger btn-trans waves-effect w-md waves-danger m-b-5"
                                       onclick="if (!(confirm('Are you sure you want to delete this personnel?'))) return false">
                                        Delete</a>
                                </td>
                            </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane fade" id="profile1">
                <div class="card-box table-responsive">
                    <h4 class="m-t-0 header-title">Caissiers</h4>

                    <table id="datatableCaissier" class="table table-bordered">
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

                        <c:forEach var="personnel" items="${CAISSIER_LIST}">

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
                                    <a href="${deleteLink}"
                                       class="btn btn-danger btn-trans waves-effect w-md waves-danger m-b-5"
                                       onclick="if (!(confirm('Are you sure you want to delete this personnel?'))) return false">
                                        Delete</a>
                                </td>
                            </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane fade" id="messages1">
                <div class="card-box table-responsive">
                    <h4 class="m-t-0 header-title">Medecins</h4>

                    <table id="datatableMedecin" class="table table-bordered">
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

                        <c:forEach var="personnel" items="${MEDECIN_LIST}">

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
                                    <a href="${deleteLink}"
                                       class="btn btn-danger btn-trans waves-effect w-md waves-danger m-b-5"
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
    </div>
</div>
<jsp:include page="admintoFooter.jsp"/>
<script type="text/javascript">
    $(document).ready(function () {

        // Default Datatable
        $('#datatable').DataTable();
        $('#datatableMedecin').DataTable();
        $('#datatableCaissier').DataTable();

        //Buttons examples
        var table = $('#datatable-buttons').DataTable({
            lengthChange: false,
            buttons: ['copy', 'excel', 'pdf']
        });

        // Key Tables

        $('#key-table').DataTable({
            keys: true
        });

        // Responsive Datatable
        $('#responsive-datatable').DataTable();

        // Multi Selection Datatable
        $('#selection-datatable').DataTable({
            select: {
                style: 'multi'
            }
        });

        table.buttons().container()
            .appendTo('#datatable-buttons_wrapper .col-md-6:eq(0)');
    });

</script>
