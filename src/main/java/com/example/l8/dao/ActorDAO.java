package com.example.l8.dao;

import com.example.l8.config.DatabaseConfiguration;
import com.example.l8.model.Actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActorDAO {

    public void addActor(Actor actor) {

        String sql = "INSERT INTO Actor (idActor, nombre, apellido, anoNacimiento, premioOscar) VALUES  (?,?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfiguration.getConnection()) {
            assert connection != null;

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, actor.getIdActor());
                statement.setString(2, actor.getNombre());
                statement.setString(3, actor.getApellido());
                statement.setInt(4, actor.getAnoNacimiento());
                statement.setInt(5, actor.getPremioOscar());
                statement.execute();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateActor(Actor actor) {

        String sql = "UPDATE Actor SET nombre = ?, apellido = ?, anoNacimiento = ?, premioOscar = ? WHERE idActor = ?";

        try (Connection connection = DatabaseConfiguration.getConnection()) {
            assert connection != null;

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, actor.getNombre());
                statement.setString(2, actor.getApellido());
                statement.setInt(3, actor.getAnoNacimiento());
                statement.setInt(4, actor.getPremioOscar());
                statement.setInt(5, actor.getIdActor());
                statement.execute();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
