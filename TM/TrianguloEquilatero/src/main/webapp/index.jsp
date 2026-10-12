<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calcular Area y Perímetro de Triangulo</title>
</head>
<body>
    <h2>Formulario de Triangulo</h2>
    <form action="TrianguloServlet" method="post">
        <label>Ingresa la base:</label><br>
        <input type="text" name="base" required><br><br>

        <label>Ingresa la altura:</label><br>
        <input type="text" name="altura" required><br><br>

        <input type="submit" value="Enviar">
    </form>
</body>
</html>