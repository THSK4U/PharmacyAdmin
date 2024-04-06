package Pharmacy.controleur;

import java.sql.*;
import Pharmacy.modele.produit;

public class produitcontrol {

    private final String jdbcurl = "jdbc:mysql://localhost:3306/produit";
    private final String jdbusername = "root";
    private final String jdbupassword = "TAHAtaha";

    private static final String INSERT_produits_SQL = "INSERT INTO produits (name, quantite, prix, description) VALUES (?, ?, ?, ?)";
    private static final String SELECT_produits_BY_ID = "SELECT id, name, quantite, prix, description FROM produits WHERE id = ?";
    private static final String SELECT_ALL_produits = "SELECT * FROM produits";
    private static final String DELETE_produits_SQL = "DELETE FROM produits WHERE id = ?";
    private static final String UPDATE_produits_SQL = "UPDATE produits SET name = ?, quantite = ?, prix = ?, description = ? WHERE id = ?";

    public produitcontrol() {

    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcurl, jdbusername, jdbupassword);
    }

    // Create insert produits
    public void insertproduits(produit Produit) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_produits_SQL)) {
            preparedStatement.setString(1, Produit.getname());
            preparedStatement.setInt(2, Produit.getquantite());
            preparedStatement.setFloat(3, Produit.getprix());
            preparedStatement.setString(4, Produit.getdescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // Select produits
    public produit selectproduit(int id) {
        produit produit = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_produits_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                int quantite = rs.getInt("quantite");
                int prix = rs.getInt("prix");
                produit = new produit(id, name, description, quantite, prix);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return produit;
    }

    // Select all produits
    public produit[] selectproduitAll() {
        produit[] produits = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_produits)) {
            ResultSet rs = preparedStatement.executeQuery();
            // Count number of rows
            int rowCount = 0;
            if (rs.last()) {
                rowCount = rs.getRow();
                rs.beforeFirst(); // Move cursor back to beginning
            }
            produits = new produit[rowCount];
            int index = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int quantite = rs.getInt("quantite");
                int prix = rs.getInt("prix");
                produits[index++] = new produit(id, name, description, quantite, prix);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return produits;
    }

    // Update
    public boolean updateproduit(produit Produit) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_produits_SQL)) {
            statement.setString(1, Produit.getname());
            statement.setInt(2, Produit.getquantite());
            statement.setFloat(3, Produit.getprix());
            statement.setString(4, Produit.getdescription());
            statement.setInt(5, Produit.getid());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    // Delete
    public boolean deleteproduit(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_produits_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    private void printSQLException(SQLException ex) {
        ex.printStackTrace();
        System.err.println("SQLState: " + ex.getSQLState());
        System.err.println("Error Code: " + ex.getErrorCode());
        System.err.println("Message: " + ex.getMessage());
    }
}
