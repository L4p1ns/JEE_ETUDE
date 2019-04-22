<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="admintoHeader.jsp"/>
<br>


<div class="row">
    <div class="col-8">
        <h4 class="m-t-0 header-title">Update Specialite</h4>
        <div class="card-box">
            <form action="Specialite" method="GET">
                <input type="hidden" name="command" value="UPDATE"/>

                <input type="hidden" name="id" value="${THE_SPECIALITE.id}"/>
                <input type="hidden" name="personnel_id" value="${THE_SPECIALITE.personnel_id}"/>

                <div class="form-group">
                    <label for="nom">Nom</label>
                    <input name="nom" id="nom" value="${THE_SPECIALITE.nom}" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="tarif">Tarif</label>
                    <input name="tarif" id="tarif" value="${THE_SPECIALITE.tarif}" class="form-control" required>
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
