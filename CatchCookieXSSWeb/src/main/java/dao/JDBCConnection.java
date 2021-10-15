package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection connectToDataBase() throws SQLException {
		final String url = "jdbc:mysql://node5257-minhpham.dal.togglebox.site/catchcookiexssweb";
		final String user = "root";
		final String password = "FNAkes66903";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
