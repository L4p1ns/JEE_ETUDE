<!DOCTYPE html>
<html>

<head>
    <title>Add Personnel</title>

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
    <h3>Add Personnel</h3>

    <form action="Personnel" method="GET">

        <input type="hidden" name="command" value="ADD"/>

        <table>
            <tbody>
            <tr>
                <td><label>Matricule:</label></td>
                <td><input type="text" name="matricule"/></td>
            </tr>

            <tr>
                <td><label>Nom:</label></td>
                <td><input type="text" name="nom"/></td>
            </tr>
            <tr>
                <td><label>Sexe:</label></td>
                <td><input type="text" name="sexe"/></td>
            </tr>

            <tr>
                <td><label>Date De Naissance:</label></td>
                <td><input type="date" name="dateNaissance"/></td>
            </tr>

            <tr>
                <td><label>Telephone:</label></td>
                <td><input type="number" name="tel"/></td>
            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td><input type="text" name="email"/></td>
            </tr>

            <tr>
                <td><label>Mot de passe:</label></td>
                <td><input type="text" name="password"/></td>
            </tr>
            <tr>
                <td><label>Domaine:</label></td>
                <td><input type="text" name="domaine"/></td>
            </tr>
            <tr>
                <td><label>Grade:</label></td>
                <td><input type="text" name="grade"/></td>
            </tr>
            <tr>
                <td><label>Type:</label></td>
                <td><input type="text" name="type"/></td>
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
        <a href="Personnel">Back to List</a>
    </p>
</div>
</body>

</html>

