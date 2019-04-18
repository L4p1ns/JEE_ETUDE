<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Medecin</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>GesCons</h2>
    </div>
</div>

<div id="container">

    <div id="content">
        <input type="button" value="Add Medecin"
               onclick="window.location.href='add-medecin-form.jsp'; return false;"
               class="add-patient-button"
        />

        <table>

            <tr>
                <th>Id</th>
                <th>Matricule</th>
                <th>Nom</th>
                <th>Date De Naissance</th>
                <th>Sexe</th>
                <th>Telephone</th>
                <th>Email</th>
                <th>Grade</th>
                <th>Action</th>
            </tr>

            <c:forEach var="medecin" items="${LIST_MEDECIN}">

                <!-- set up a link for each patient -->
                <c:url var="tempLink" value="/Medecin">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="patientId" value="${medecin.id}"/>
                </c:url>

                <!-- set up a link to delete a patient -->
                <c:url var="deleteLink" value="PatientController">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="patientId" value="${medecin.id}"/>
                </c:url>

                <tr>
                    <td> ${medecin.id} </td>
                    <td> ${medecin.matricule} </td>
                    <td> ${medecin.nom} </td>
                    <td> ${medecin.dateNaissance} </td>
                    <td> ${medecin.sexe} </td>
                    <td> ${medecin.tel} </td>
                    <td> ${medecin.email} </td>
                    <td> ${medecin.grade} </td>
                    <td>
                        <a href="${tempLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this medecin?'))) return false">
                            Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
