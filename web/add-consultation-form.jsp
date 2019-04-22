<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="admintoHeader.jsp"/>
<br>
<div class="row">
    <div class="col-8">
        <h4 class="m-t-0 header-title">Consultation</h4>
        <div class="card-box">
            <form action="Consultation" method="GET">
                <input type="hidden" name="command" value="ADD"/>

                <input type="hidden" name="id_medecin" value="${MEDECIN.id}">
                <input type="hidden" name="id_ticket" value="${TICKET.id}">
                <div class="form-group">
                    <label for="motif">Motif</label>
                    <input name="motif" id="motif" class="form-control" required>
                </div>
<%--                <div class="form-group">--%>
<%--                    <label for="id_medecin">Personnel</label>--%>
<%--                    <select class="form-control" name="id_medecin" id="id_medecin">--%>
<%--                        <c:forEach var="item" items="${LIST_MEDECINS}">--%>
<%--                            <option value="${item.id}">--%>
<%--                                <c:out value="${item.nom}"/>--%>
<%--                            </option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="id_ticket">Ticket</label>--%>
<%--                    <select class="form-control" name="id_ticket" id="id_ticket">--%>
<%--                        <c:forEach var="item" items="${LIST_TICKETS}">--%>
<%--                            <option value="${item.id}">--%>
<%--                                <c:out value="${item.patient}"/>--%>
<%--                            </option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </div>--%>

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
