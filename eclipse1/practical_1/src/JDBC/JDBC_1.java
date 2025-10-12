package JDBC;
import java.sql.*;

public class JDBC_1 {

	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/ERP_5THSEM";
		String user="root";
		String password="@ROOT123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				System.out.println("connectionn successful");
				connection.close();
			}
			
		}catch(Exception e){
			
			System.out.println("connection failed"+e.getMessage());
		}
	}

}
