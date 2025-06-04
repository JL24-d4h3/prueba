package com.example.l8.dao;

import com.example.l8.config.DatabaseConfiguration;
import com.example.l8.model.Protagonistas;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProtagonistasDAO {

    public void addProtagonista(Protagonistas protagonista){

        String sql = "INSERT INTO protagonistas (idPelicula, idActor) VALUES (?, ?)";

        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, protagonista.getIdPelicula());
            preparedStatement.setInt(2, protagonista.getIdActor());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateProtagonista(Protagonistas protagonista){

        String sql = "UPDATE Protagonistas SET idPelicula = ?, idActor = ?";

        try (Connection connection = DatabaseConfiguration.getConnection()) {
            assert connection != null;

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, protagonista.getIdPelicula());
                statement.setInt(2, protagonista.getIdActor());
                statement.executeUpdate();

            } catch (SQLException e) {

                System.out.println("SQLException: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
