package com.ss.lms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import org.springframework.stereotype.Component;

@Component
public class DBConnection {
	static Connection con = null;

	public static Connection getConnection() {
		if (con != null)
			return con;
		return getConnection("library", "root", "Maitian123");
	}

	private static Connection getConnection(String db_name, String user_name, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + db_name + "?serverTimezone=UTC",
					user_name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
