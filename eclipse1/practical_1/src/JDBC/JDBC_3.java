package JDBC;
import java.sql.*;
public class JDBC_3 {

	public static void main(String[] args) {
		/* driver load
		 * connection establish
		 * statement create
		 * execute query
		 * connection close
		 */

		try {
			// driver load
			Class.forName("com.mysql.jdbc.driver");
			//connection establish
			String url = "jdbc:mysql://localhost:3306:/ERP_5THSEM";
			String user ="root";
			String password = "@ROOT123";
			Connection conn = DriverManager.getConnection(url,user,password);
			//statement create
			Statement smt = conn.createStatement();
			
			//String query = "create database DB";
			
			
		}catch() {
			
		}
	}

}
