package JDBC;
//import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_2 {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/ERP_5THSEM";
			String user="root";
			String password="@ROOT123";
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
