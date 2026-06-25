<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de canciones</title>
</head>
<body>

    <h1>Lista de canciones</h1>

    <table border="1">
        <thead>
            <tr>
                <th>Título</th>
                <th>Autor</th>
                <th>Detalle</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="cancion" items="${canciones}">
                <tr>
                    <td>${cancion.titulo}</td>
                    <td>
                        <c:choose>
                            <c:when test="${cancion.artista != null}">
                                ${cancion.artista.nombre} ${cancion.artista.apellido}
                            </c:when>
                            <c:otherwise>
                                Sin artista
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="/canciones/detalle/${cancion.id}">Detalle</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        <br>
                <a href="/canciones/formulario/agregar">
                <button>Agregar canción</button>
                </a>
        <br>
        <a href="/artistas">Ir a artistas</a>
</body>
</html>
