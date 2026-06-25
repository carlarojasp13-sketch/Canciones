<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar artista</title>
</head>
<body>

    <h1>Agregar artista</h1>

    <form:form action="/artistas/procesa/agregar" method="post" modelAttribute="artista">
        <div>
            <form:label path="nombre">Nombre:</form:label>
            <form:input path="nombre" />
            <form:errors path="nombre" cssStyle="color:red;" />
        </div>

        <br>

        <div>
            <form:label path="apellido">Apellido:</form:label>
            <form:input path="apellido" />
            <form:errors path="apellido" cssStyle="color:red;" />
        </div>

        <br>

        <div>
            <form:label path="biografia">Biografía:</form:label>
            <form:textarea path="biografia" />
            <form:errors path="biografia" cssStyle="color:red;" />
        </div>

        <br>

        <button type="submit">Agregar artista</button>
    </form:form>

    <br>

    <a href="/artistas">Volver a lista de artistas</a>

</body>
</html>
