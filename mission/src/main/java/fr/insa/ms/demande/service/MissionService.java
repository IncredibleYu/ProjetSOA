package fr.insa.ms.demande.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MissionService {

    private final DataSource dataSource;

    @Autowired
    public MissionService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Map<String, Object>> getAllMissions() {
        List<Map<String, Object>> missions = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM mission")) {

            while (resultSet.next()) {
                Map<String, Object> mission = new HashMap<>();
                mission.put("idmission", resultSet.getInt("idmission"));
                mission.put("iddemandeur", resultSet.getInt("iddemandeur"));
                mission.put("state", resultSet.getString("state"));
                mission.put("score", resultSet.getInt("score"));
                mission.put("comment", resultSet.getString("comment"));
                missions.add(mission);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return missions;
    }

    public Map<String, Object> getMissionById(int id) {
        Map<String, Object> mission = new HashMap<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mission WHERE idmission = ?")) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    mission.put("idmission", resultSet.getInt("idmission"));
                    mission.put("iddemandeur", resultSet.getInt("iddemandeur"));
                    mission.put("state", resultSet.getString("state"));
                    mission.put("score", resultSet.getInt("score"));
                    mission.put("comment", resultSet.getString("comment"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mission;
    }

    public void saveMission(int id, int iddemandeur, String state, int score, String comment) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO mission (idmission, iddemandeur, state, score, comment) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, iddemandeur);
            preparedStatement.setString(3, state);
            preparedStatement.setInt(4, score);
            preparedStatement.setString(5, comment);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void validateMission(int id) {
        updateMissionState(id, "Validée");
    }

    public void refuseMission(int id) {
        updateMissionState(id, "Refusée");
    }

    public void finishMission(int id, int score, String comment) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE mission SET state = 'Terminée', score = ?, comment = ? WHERE idmission = ?")) {

            preparedStatement.setInt(1, score);
            preparedStatement.setString(2, comment);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMissionState(int id, String state) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE mission SET state = ? WHERE idmission = ?")) {

            preparedStatement.setString(1, state);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMission(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM mission WHERE idmission = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}