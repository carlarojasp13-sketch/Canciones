<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle de canción</title>
</head>
<body>

    <h1>Detalle de canción</h1>

    <c:choose>
        <c:when test="${cancion != null}">

            <p><strong>ID:</strong> ${cancion.id}</p>
            <p><strong>Título:</strong> ${cancion.titulo}</p>
            <p><strong>Artista:</strong> ${cancion.artista}</p>
            <p><strong>Álbum:</strong> ${cancion.album}</p>
            <p><strong>Género:</strong> ${cancion.genero}</p>
            <p><strong>Idioma:</strong> ${cancion.idioma}</p>
            <p><strong>Fecha de creación:</strong> ${cancion.fechaCreacion}</p>
            <p><strong>Fecha de actualización:</strong> ${cancion.fechaActualizacion}</p>

        </c:when>

        <c:otherwise>
            <p>No se encontró la canción.</p>
        </c:otherwise>
    </c:choose>

    <br>

    <a href="/canciones">Volver a lista de canciones</a>

    <a href="/canciones/formulario/editar/${cancion.id}">
        <button>Actualizar canción</button>
    </a>

</body>
</html>