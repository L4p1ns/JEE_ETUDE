<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="admintoHeader.jsp"/>
<br>


<div class="row">
    <div class="col-8">
        <h4 class="m-t-0 header-title">Personnel</h4>
        <div class="card-box">
            <form action="Personnel" method="GET">
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
                    <label for="prenom">Prenom</label>
                    <input name="prenom" id="prenom" class="form-control" required>
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
                    <label for="email">Email</label>
                    <input name="email" id="email" type="email" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="password">Mot de passe</label>
                    <input name="password" id="password" type="password" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="domaine">Domaine</label>
                    <input name="domaine" id="domaine" type="text" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="type">Type Personnel</label>
                    <select name="type" id="type" class="form-control">
                        <option value="CAISSIER">Caissier</option>
                        <option value="MEDECIN">Medecin</option>
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
