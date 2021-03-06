<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="admintoHeader.jsp"/>
<br>
<div class="row">
    <div class="col-8">
        <h4 class="m-t-0 header-title">Specialite</h4>
        <div class="card-box">
            <form action="Specialite" method="GET">
                <input type="hidden" name="command" value="ADD"/>

                <div class="form-group">
                    <label for="nom">Nom</label>
                    <input name="nom" id="nom" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="tarif">Tarif</label>
                    <input name="tarif" id="tarif" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="tarif">Personnel</label>
                    <select name="personnel_id" class="form-control">
                        <c:forEach var="item" items="${LIST_PERSONNEL}">
                            <option value="${item.id}">
                                <c:out value="${item.prenom} ${item.nom}"/>
                            </option>
                        </c:forEach>
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
