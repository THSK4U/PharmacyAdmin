package Pharmacy.controleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Pconnection {

private static Connection connection;
static {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection
		("jdbc:mysql://localhost:3306/produit?serverTimezone=UTC", "root", "TAHAtaha");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static Connection getConnection() {
	return connection;
}


}
