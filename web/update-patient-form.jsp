<!DOCTYPE html>
<html>

<head>
    <title>Update Patient</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/add-patient-style.css">
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>GesCons</h2>
    </div>
</div>

<div id="container">
    <h3>Update Patient</h3>

    <form action="PatientController" method="GET">

        <input type="hidden" name="command" value="UPDATE"/>

        <input type="hidden" name="patientId" value="${THE_PATIENT.id}"/>

        <table>
            <tbody>
            <tr>
                <td><label>Matricule:</label></td>
                <td><input type="text" name="matricule" value="${THE_PATIENT.matricule}"/></td>
            </tr>

            <tr>
                <td><label>Nom:</label></td>
                <td><input type="text" name="nom" value="${THE_PATIENT.nom}"/></td>
            </tr>

            <tr>
                <td><label>Sexe:</label></td>
                <td><input type="text" name="sexe" value="${THE_PATIENT.sexe}"/></td>
            </tr>

            <tr>
                <td><label>Date de Naissance:</label></td>
                <td><input type="text" name="dateNaissance" value="${THE_PATIENT.dateNaissance}"/></td>
            </tr>
            <tr>
                <td><label>Telephone:</label></td>
                <td><input type="text" name="tel" value="${THE_PATIENT.tel}"/></td>
            </tr>
            <tr>
                <td><label>Groupe Sanguin:</label></td>
                <td><input type="text" name="groupeSanguin" value="${THE_PATIENT.groupeSanguin}"/></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>

            </tbody>
        </table>
    </form>

    <div style="clear: both;"></div>

    <p>
        <a href="PatientController">Back to List</a>
    </p>
</div>
</body>

</html>
