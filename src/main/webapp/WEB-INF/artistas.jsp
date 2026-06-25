<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Lista de artistas</title>
        </head>

        <body>

            <h1>Lista de artistas</h1>
            <c:choose>
                <c:when test="${not empty artistas}">
                    <ul>
                        <c:forEach var="artista" items="${artistas}">
                            <li>
                                <a href="/artistas/detalle/${artista.id}">
                                    ${artista.nombre} ${artista.apellido}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </c:when>
                <c:otherwise>
                    <p>No hay artistas registrados.</p>
                </c:otherwise>
            </c:choose>

            <br>
            <a href="/artistas/formulario/agregar">
                <button>Agregar artista</button>
            </a>
            <br>
            <a href="/canciones">
                <button>Ir a canciones</button>
            </a>
        </body>

        </html>
