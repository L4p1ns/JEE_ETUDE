<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Personnel</title>

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
        <input type="button" value="Add Personnel"
               onclick="window.location.href='add-personnel-form.jsp'; return false;"
               class="add-patient-button"
        />

        <table>

            <tr>
                <th>Matricule</th>
                <th>Nom</th>
                <th>Date De Naissance</th>
                <th>Telephone</th>
                <th>Sexe</th>
                <th>Email</th>
                <th>Password</th>
                <th>Domaine</th>
                <th>Grade</th>
                <th>Type</th>
                <th>Action</th>
            </tr>

            <c:forEach var="personnel" items="${PERSONNEL_LIST}">

                <c:url var="tempLink" value="PatientController">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="patientId" value="${personnel.id}"/>
                </c:url>

                <c:url var="deleteLink" value="PatientController">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="personnelId" value="${personnel.id}"/>
                </c:url>

                <tr>
                    <td> ${personnel.matricule} </td>
                    <td> ${personnel.nom} </td>
                    <td> ${personnel.dateNaissance} </td>
                    <td> ${personnel.tel} </td>
                    <td> ${personnel.sexe} </td>
                    <td> ${personnel.email} </td>
                    <td> ${personnel.password} </td>
                    <td> ${personnel.domaine} </td>
                    <td> ${personnel.grade} </td>
                    <td> ${personnel.type} </td>
                    <td>
                        <a href="${tempLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this personnel?'))) return false">
                            Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
