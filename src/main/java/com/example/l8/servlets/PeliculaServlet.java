package com.example.l8.servlets;

import com.example.l8.dao.PeliculaDAO;
import com.example.l8.model.Pelicula;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PeliculaServlet", urlPatterns = "/PeliculaServlet")

public class PeliculaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String action = request.getParameter("action");

        PeliculaDAO peliculaDAO = new PeliculaDAO();
        List<Pelicula> lista_completa_peliculas = peliculaDAO.obtenerListaDePeliculas();
        System.out.println("Lista de películas obtenidas: " + lista_completa_peliculas);

        request.setAttribute("listar_peliculas", lista_completa_peliculas);

        System.out.println("Se está evaluando el funcionamiento del Servlet con doGet");

//        response.sendRedirect("views/listar_peliculas.jsp");

        dispatcher = request.getRequestDispatcher( "views/listar_peliculas.jsp");
        dispatcher.forward(request, response);

//        switch (action) {
//
//            case "agregar-pelicula":
//
//                dispatcher = request.getRequestDispatcher("peliculas.jsp");
//                dispatcher.forward(request, response);
//                break;
//
//            case "eliminar-pelicula":
//
//
//                dispatcher = request.getRequestDispatcher("eliminar_pelicula.jsp");
//                dispatcher.forward(request, response);
//                break;
//
//            case "actualizar-pelicula":
//
//                dispatcher = request.getRequestDispatcher("actualizar_peliculas.jsp");
//                dispatcher.forward(request, response);
//                break;
//
//            default:
//
//                dispatcher = request.getRequestDispatcher("peliculas.jsp");
//                dispatcher.forward(request, response);
//                break;
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
