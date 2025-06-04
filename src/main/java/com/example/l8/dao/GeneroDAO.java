package com.example.l8.dao;

import com.example.l8.config.DatabaseConfiguration;
import com.example.l8.model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GeneroDAO {

    public void addGenero (Genero genero) {

        String sql = "INSERT INTO genero (idGenero, nombre) VALUES (?, ?)";

        try (Connection connection = DatabaseConfiguration.getConnection()) {
            assert connection != null;

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, genero.getIdGenero());
                statement.setString(2, genero.getNombre());
                statement.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateGenero (Genero genero) {
        String sql = "UPDATE genero SET nombre = ? WHERE idGenero = ?";

        try (Connection connection = DatabaseConfiguration.getConnection()) {
            assert connection != null;

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, genero.getNombre());
                statement.setInt(2, genero.getIdGenero());
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
