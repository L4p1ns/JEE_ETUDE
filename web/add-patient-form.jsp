<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="admintoHeader.jsp"/>
<br>
<div class="row">
    <div class="col-8">
        <h4 class="m-t-0 header-title">Patient</h4>
        <div class="card-box">
            <form action="PatientController" method="GET">
                <input type="hidden" name="command" value="ADD"/>

                <div class="form-group">
                    <label for="matricule">Matricule</label>
                    <input name="matricule" id="matricule" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="nom">Nom</label>
                    <input name="nom" id="nom" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="sexe">Sexe</label>
                    <select name="sexe" id="sexe" class="form-control">
                        <option value="M">Homme</option>
                        <option value="F">Femme</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="dateNaissance">Date de Naissance</label>
                    <input name="dateNaissance" id="dateNaissance" type="date" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="tel">Telephone</label>
                    <input name="tel" id="tel" type="number" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="groupeSanguin">Groupe Sanguin</label>
                    <select name="groupeSanguin" id="groupeSanguin" type="groupeSanguin" class="form-control" required>
                        <option value="Oplus">Oplus</option>
                        <option value="Onegatif">Onegatif</option>
                        <option value="ABnegatif">ABnegatif</option>
                        <option value="ABplus">ABplus</option>
                        <option value="Aplus">Aplus</option>
                        <option value="Anegatif">Anegatif</option>
                        <option value="Bplus">Bplus</option>
                        <option value="Bnegatif">Bnegatif</option>
                    </select>
                </div>


                <div class="form-group text-right m-b-0">
                    <button class="btn btn-primary waves-effect waves-light" type="submit">
                        Valider
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="admintoFooter.jsp"/>
<%--<script type="text/javascript">--%>
<%--    $(document).ready(function() {--%>
<%--        $('form').parsley();--%>
<%--    });--%>
<%--</script>--%>
