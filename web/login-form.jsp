<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Login</title>

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
    <h3>Login</h3>

    <form action="Login" method="GET">

        <input type="hidden" name="command" value="LOGIN"/>

        <table>
            <tbody>
            <tr>
                <td><label>Email:</label></td>
                <td><input type="text" name="email"/></td>
            </tr>
            <tr>
                <td><label>Mot de passe:</label></td>
                <td><input type="text" name="password"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Login" class="save"/></td>
            </tr>

            </tbody>
        </table>
    </form>

    <div style="clear: both;"></div>

</div>
</body>

</html>

