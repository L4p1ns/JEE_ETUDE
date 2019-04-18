<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Patient</title>

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

        <!-- put new button: Add Patient -->

        <input type="button" value="Add Patient"
               onclick="window.location.href='add-patient-form.jsp'; return false;"
               class="add-patient-button"
        />

        <table>

            <tr>
                <th>Matricule</th>
                <th>Nom</th>
                <th>Date De Naissance</th>
                <th>Telephone</th>
                <th>Sexe</th>
                <th>Groupe Sanguin</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempPatient" items="${PATIENT_LIST}">

                <!-- set up a link for each patient -->
                <c:url var="tempLink" value="PatientController">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="patientId" value="${tempPatient.matricule}"/>
                </c:url>

                <!-- set up a link to delete a patient -->
                <c:url var="deleteLink" value="PatientController">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="patientId" value="${tempPatient.matricule}"/>
                </c:url>

                <tr>
                    <td> ${tempPatient.matricule} </td>
                    <td> ${tempPatient.nom} </td>
                    <td> ${tempPatient.dateNaissance} </td>
                    <td> ${tempPatient.tel} </td>
                    <td> ${tempPatient.sexe} </td>
                    <td> ${tempPatient.groupeSanguin} </td>
                    <td>
                        <a href="${tempLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
                            Delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>
</body>


</html>








