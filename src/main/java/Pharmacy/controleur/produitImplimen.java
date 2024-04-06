package Pharmacy.controleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Pharmacy.modele.produit;

public class produitImplimen implements Cproduit {
	private static final String INSERT_produits_SQL = "INSERT INTO produits (name, quantite, prix, description) VALUES (?, ?, ?, ?)";
    private static final String SELECT_produits_MAX_ID = "SELECT MAX(id) AS ID FROM produits";
    private static final String SELECT_ALL_produits = "SELECT * FROM produits";
    private static final String DELETE_produits_SQL = "DELETE FROM produits WHERE id = ?";
    private static final String UPDATE_produits_SQL = "UPDATE produits SET name = ?, quantite = ?, prix = ?, description = ? WHERE id = ?";


    @Override
    public produit save(produit p) {
        Connection connection = Pconnection.getConnection();
        try {
            PreparedStatement Statement = connection.prepareStatement(INSERT_produits_SQL);
        	Statement.setString(1, p.getname());
        	Statement.setInt(2, p.getquantite());
        	Statement.setDouble(3, p.getprix());
        	Statement.setString(4, p.getdescription());
            Statement.executeUpdate();
            PreparedStatement Statement2 = connection.prepareStatement(SELECT_produits_MAX_ID);
            ResultSet rs =Statement2.executeQuery();
            if(rs.next()) {
            	p.setid(rs.getInt("ID"));
            }
            Statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return p;
    }


	public List<produit> prduitsparmc(String mc) {
		List< produit> produits=new ArrayList<produit>();
        Connection connection = Pconnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_produits);
            statement.setString(1, "%" + mc + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	produit p = new produit();
            	p.setid(resultSet.getInt("id"));
            	p.setname(resultSet.getString("name"));;
                p.setdescription(resultSet.getString("description"));
                p.setquantite(resultSet.getInt("quantite")); ;
                p.setprix(resultSet.getInt("prix"));
                produits.add(p);
            }
            statement.close();
        } catch (Exception e) {
        
            e.printStackTrace();
        }
        return produits;
    }
	public produit getproduit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public produit update(produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


	public List<produit> getAllProducts() {
	        List<produit> products = new ArrayList<produit>();
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {
	            // Establish connection to your database
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/produit?serverTimezone=UTC", "root", "TAHAtaha");

	            // SQL query to retrieve all products
	            String sql = "SELECT * FROM products";
	            stmt = conn.prepareStatement(sql);

	            // Execute the query
	            rs = stmt.executeQuery();

	            // Iterate over the result set and create product objects
	            while (rs.next()) {
	                produit product = new produit();
	                product.setid(rs.getInt("id"));
	                product.setname(rs.getString("name"));
	                // Set other attributes as needed
	                products.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close resources
	            try {
	                if (rs != null) rs.close();
	                if (stmt != null) stmt.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return products;
	    
	}

}
