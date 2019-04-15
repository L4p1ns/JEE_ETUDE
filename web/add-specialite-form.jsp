<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Add Specialite</title>

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
    <h3>Add Specialite</h3>

    <form action="Specialite" method="GET">

        <input type="hidden" name="command" value="ADD"/>

        <table>
            <tbody>
            <tr>
                <td><label>Nom:</label></td>
                <td><input type="text" name="nom"/></td>
            </tr>
            <tr>
                <td><label>Tarif:</label></td>
                <td><input type="text" name="tarif"/></td>
            </tr>

            <tr>
                <td><label>Personnel:</label></td>
                <td>
                    <select name="personnel_id" style="width: 250px; border: 1px solid #666;border-radius: 5px; padding: 4px;font-size: 16px">
                        <c:forEach var="item" items="${LIST_PERSONNEL}">
                            <option value="${item.id}">
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
        <a href="Specialite">Back to List</a>
    </p>
</div>
</body>

</html>

