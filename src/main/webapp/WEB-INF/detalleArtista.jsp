<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle artista</title>
</head>
<body>

    <h1>Detalle del artista</h1>

    <c:choose>
        <c:when test="${artista != null}">

            <p><strong>ID:</strong> ${artista.id}</p>
            <p><strong>Nombre:</strong> ${artista.nombre}</p>
            <p><strong>Apellido:</strong> ${artista.apellido}</p>
            <p><strong>Biografía:</strong> ${artista.biografia}</p>
            <p><strong>Fecha de creación:</strong> ${artista.fechaCreacion}</p>
            <p><strong>Fecha de actualización:</strong> ${artista.fechaActualizacion}</p>

            <h2>Canciones del artista</h2>

            <c:choose>
                <c:when test="${not empty artista.canciones}">
                    <ul>
                        <c:forEach var="cancion" items="${artista.canciones}">
                            <li>
                                <a href="/canciones/detalle/${cancion.id}">
                                    ${cancion.titulo}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </c:when>

                <c:otherwise>
                    <p>Este artista no tiene canciones registradas.</p>
                </c:otherwise>
            </c:choose>

        </c:when>

        <c:otherwise>
            <p>No se encontró el artista.</p>
        </c:otherwise>
    </c:choose>

    <br>

    <a href="/artistas">Volver a lista de artistas</a>

</body>
</html>