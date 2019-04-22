<%@ page import="model.Personnel" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="admintoHeader.jsp"/>
<br>


<div class="row">
    <div class="col-12">
        <h4 class="m-t-0 header-title">Ticket</h4>
        <div class="card-box">
            <form action="Ticket" method="GET">
                <input type="hidden" name="command" value="ADD"/>
                <input type="hidden" name="id_patient" value="${PATIENT.matricule}">
                <input type="hidden" name="id_personnel" value="${CAISSIER.id}">
                <div class="form-group">
                    <label for="id_specialite">Specilate</label>
                    <select name="id_specialite" id="id_specialite" class="form-control">
                        <c:forEach var="item" items="${LIST_SPECIALITES}">
                            <option value="${item.id}">
                                <c:out value="${item.nom}"/>
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
