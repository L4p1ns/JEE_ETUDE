<%@ page import="model.Personnel" %>
<jsp:include page="admintoHeader.jsp"/>
<br>
<div class="row">
    <div class="col-12">
        <h4 class="m-t-0 header-title">Profile</h4>
        <div class="card-box">
            <%Personnel personnel = (Personnel) session.getAttribute("PERSONNEL");%>
            <p>Matricule : <%=personnel.getMatricule()%></p>
            <p>Prenom : <%=personnel.getPrenom()%></p>
            <p>Nom : <%=personnel.getNom()%></p>
            <p>Telephone : <%=personnel.getTel()%></p>
            <p>Type : <%=personnel.getType()%></p>
            <p>Email : <%=personnel.getEmail()%></p>
        </div>
    </div>
</div>
<jsp:include page="admintoFooter.jsp"/>
