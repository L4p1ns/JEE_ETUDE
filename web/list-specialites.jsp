<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Spécialté</title>

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
        <c:url var="linkAddForm" value="Specialite">
            <c:param name="command" value="LOADPERSONNEL"/>
            <c:param name="LIST_PERSONNEL" value="${LIST_PERSONNEL}"/>
        </c:url>
        <a href="${linkAddForm}" class="add-patient-button">
            Add Specialite
        </a>
        <table>

            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Tarif</th>
                <th>Personnel</th>
                <th>Action</th>
            </tr>

            <c:forEach var="specialite" items="${SPECIALTE_LIST}">
                <!-- set up a link for each patient -->
                <c:url var="tempLink" value="Specialite">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="specialiteId" value="${specialite.id}"/>
                </c:url>

                <!-- set up a link to delete a patient -->
                <c:url var="deleteLink" value="Specialite">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="specialiteId" value="${specialite.id}"/>
                </c:url>

                <tr>
                    <td> ${specialite.id} </td>
                    <td> ${specialite.nom} </td>
                    <td> ${specialite.tarif} </td>
                    <td> ${specialite.personnel_id} </td>
                    <td>
                        <a href="${tempLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this specialite?'))) return false">
                            Delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>
