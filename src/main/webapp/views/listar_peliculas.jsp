<%--
  Created by IntelliJ IDEA.
  User: jesus
  Date: 4/06/2025
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.l8.model.Pelicula" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Pelicula> lista_completa_peliculas = (List<Pelicula>) request.getAttribute("listar_peliculas");
%>
<html lang="es">
<head>
    <title>Películas</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          rel="stylesheet" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class='mb-3'>Lista de Películas</h1>
        <table class="table table-striped">
            <tr>
                <th>Título</th>
                <th>Director</th>
                <th>Año de Publicación</th>
                <th>Rating</th>
                <th>Box Office</th>
                <th>Género</th>
                <th>Actores</th>
<%--                <th>Accionable</th>--%>
            </tr>
            <% System.out.println("Lista impresa: " + lista_completa_peliculas); %>
            <% for (Pelicula pelicula : lista_completa_peliculas) { %>
<%--                System.out.println(pelicula.getIdPelicula());--%>
<%--                System.out.println(pelicula.getTitulo());--%>
<%--                System.out.println(pelicula.getDirector());--%>
<%--                System.out.println(pelicula.getAnoPublicacion());--%>
<%--                System.out.println(pelicula.getRating());--%>
<%--                System.out.println(pelicula.getBoxOffice());--%>
<%--                System.out.println(pelicula.getIdGenero());--%>
            <tr>
                <td><%= pelicula.getIdPelicula()%></td>
                <td><%= pelicula.getTitulo() %></td>
                <td><%= pelicula.getDirector()%></td>
                <td><%= pelicula.getAnoPublicacion()%></td>
                <td><%= pelicula.getRating()%></td>
                <td><%= pelicula.getBoxOffice()%></td>
                <td><%= pelicula.getIdGenero()%></td>

<%--                <td><%= pelicula.getTitulo() %></td>--%>
<%--                <td><%= pelicula.getDirector() %></td>--%>
<%--                <td><%= pelicula.getAnoPublicacion() %></td>--%>
<%--                <td><%= pelicula.getRating() %></td>--%>
<%--                <td><%= pelicula.getBoxOffice() %></td>--%>
<%--                <td><%= pelicula.getIdGenero() %></td>--%>
<%--                <td><%= pelicula.getActores() %></td>--%>
<%--                <td><%= pelicula.getAccionable() %></td>--%>
            </tr>
            <% } %>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js">
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous"
    </script>
</body>
</html>
