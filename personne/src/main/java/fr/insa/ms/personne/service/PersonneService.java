package fr.insa.ms.personne.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PersonneService {
	private final DataSource dataSource;

    @Autowired
    public PersonneService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Map<String, Object>> getAllPersonnes() {
        List<Map<String, Object>> personnes = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM personne")) {

            while (resultSet.next()) {
                Map<String, Object> personne = new HashMap<>();
                personne.put("id", resultSet.getInt("id"));
                personne.put("nom", resultSet.getString("nom"));
                personne.put("prenom", resultSet.getString("prenom"));
                personne.put("age", resultSet.getInt("age"));
                personne.put("sexe", resultSet.getString("sexe"));
                personnes.add(personne);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnes;
    }

    public Map<String, Object> getPersonneById(int id) {
        Map<String, Object> personne = new HashMap<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM personne WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    personne.put("id", resultSet.getInt("id"));
                    personne.put("nom", resultSet.getString("nom"));
                    personne.put("prenom", resultSet.getString("prenom"));
                    personne.put("age", resultSet.getInt("age"));
                    personne.put("sexe", resultSet.getString("sexe"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personne;
    }

    public void savePersonne(String nom, String prenom, int age, String sexe) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO personne (nom, prenom, age, sexe) VALUES (?, ?, ?, ?)")) {

            System.out.println("Executing SQL query: " + preparedStatement.toString());

            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, sexe);

            System.out.println("nom: " + nom + ", prenom: " + prenom + ", age: " + age + ", sexe: " + sexe);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ajout erreur");
        }
    }

    public void deletePersonne(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM personne WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
