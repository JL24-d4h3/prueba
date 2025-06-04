package com.example.l8.dao;

import com.example.l8.config.DatabaseConfiguration;
import com.example.l8.model.Genero;
import com.example.l8.model.Pelicula;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    public void addPelicula(Pelicula pelicula) {

        String sql = "INSERT INTO Pelicula (idPelicula, titulo, director, anoPublicacion, rating, boxOffice, idGenero) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getConnection()) {
            assert connection != null;

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, pelicula.getIdPelicula());
                statement.setString(2, pelicula.getTitulo());
                statement.setString(3, pelicula.getDirector());
                statement.setInt(4, pelicula.getAnoPublicacion());
                statement.setString(5, pelicula.getDirector());
                statement.setInt(6, pelicula.getIdGenero());

                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePelicula(Pelicula pelicula) {

        String sql = "UPDATE Pelicula SET idPelicula = ?, titulo = ?, director = ?, anoPublicacion = ?, rating = ?, boxOffice = ?, idGenero = ?";

        try (Connection connection = DatabaseConfiguration.getConnection()) {
            assert connection != null;

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, pelicula.getIdPelicula());
                statement.setString(2, pelicula.getTitulo());
                statement.setString(3, pelicula.getDirector());
                statement.setInt(4, pelicula.getAnoPublicacion());
                statement.setString(5, pelicula.getDirector());
                statement.setInt(6, pelicula.getIdGenero());
                statement.executeUpdate();

            } catch (SQLException e) {

                System.out.println("SQLException: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePelicula(int idPelicula) {

        String sql = "DELETE FROM Pelicula WHERE idPelicula = ?";

        try (Connection connection = DatabaseConfiguration.getConnection()) {
            assert connection != null;

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, idPelicula);
                statement.executeUpdate();

            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Pelicula> obtenerListaDePeliculas() {

        List<Pelicula> peliculas = new ArrayList<>();

        String sql = "SELECT * FROM Pelicula";

        System.out.println("Se está haciendo uso del método obtenerListaDePelículas");

        try (Connection connection = DatabaseConfiguration.getConnection()) {
            assert connection != null;

            System.out.println("Se está estableciendo la conexión con la base de datos");

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                ResultSet resultSet = statement.executeQuery();

                System.out.println("Se ha ejecutado la consulta");

                while (resultSet.next()) {

                    Pelicula pelicula = new Pelicula();

                    pelicula.setIdPelicula(resultSet.getInt("idPelicula"));
                    pelicula.setTitulo(resultSet.getString("titulo"));
                    pelicula.setDirector(resultSet.getString("director"));
                    pelicula.setAnoPublicacion(resultSet.getInt("anoPublicacion"));
                    pelicula.setRating(resultSet.getDouble("rating"));
                    pelicula.setBoxOffice(resultSet.getDouble("boxOffice"));
                    pelicula.setDirector(resultSet.getString("director"));
                    pelicula.setIdGenero(resultSet.getInt("idGenero"));
                    peliculas.add(pelicula);

                    System.out.println("... probando, probando, probando");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Se ha terminado de ejecutar la consulta");
        System.out.println("Se imprimirá la lista de películas obtenida:");
        System.out.println(peliculas);
        return peliculas;
    }

    public List<Pelicula> filtrarPeliculaPorGenero(String genero) {

        List<Pelicula> peliculas = new ArrayList<>();

        String sql = "SELECT * FROM Pelicula p INNER JOIN genero g ON p.idGenero = g.idGenero WHERE nombre = ?";

        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, genero);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Pelicula pelicula = new Pelicula();

                pelicula.setIdPelicula(resultSet.getInt("idPelicula"));
                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setDirector(resultSet.getString("director"));
                pelicula.setAnoPublicacion(resultSet.getInt("anoPublicacion"));
                pelicula.setRating(resultSet.getDouble("rating"));
                pelicula.setBoxOffice(resultSet.getDouble("boxOffice"));
                pelicula.setDirector(resultSet.getString("director"));
                pelicula.setIdGenero(resultSet.getInt("idGenero"));
                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }

        return peliculas;
    }
}
