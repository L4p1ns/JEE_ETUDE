<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Add Yicket</title>

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
    <h3>Add Ticket</h3>

    <form action="Ticket" method="GET">

        <input type="hidden" name="command" value="ADD"/>

        <table>
            <tbody>
            <tr>
                <td><label>Montant:</label></td>
                <td><input type="number" name="montant"/></td>
            </tr>

            <tr>
                <td><label>Personnel:</label></td>
                <td>
                    <select name="id_personnel"
                            style="width: 250px; border: 1px solid #666;border-radius: 5px; padding: 4px;font-size: 16px">
                        <c:forEach var="item" items="${LIST_PERSONNELS}">
                            <option value="${item.id}">
                                <c:out value="${item.nom}"/>
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td><label>Specialite:</label></td>
                <td>
                    <select name="id_specialite"
                            style="width: 250px; border: 1px solid #666;border-radius: 5px; padding: 4px;font-size: 16px">
                        <c:forEach var="item" items="${LIST_SPECIALITES}">
                            <option value="${item.id}">
                                <c:out value="${item.nom}"/>
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td><label>Patient:</label></td>
                <td>
                    <select name="id_patient" style="width: 250px; border: 1px solid #666;border-radius: 5px; padding: 4px;font-size: 16px">
                        <c:forEach var="item" items="${LIST_PATIENTS}">
                            <option value="${item.matricule}">
                                <c:out value="${item.nom}"/>
                            </option>
                        </c:forEach>
                    </select>
                </td>
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
        <a href="Ticket">Back to List</a>
    </p>
</div>
</body>

</html>

