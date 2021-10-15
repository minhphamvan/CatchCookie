package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CookieModel;

public class CookieDao {
	public void add(CookieModel cookie) {
		try {
			Connection connection = JDBCConnection.connectToDataBase();

			String sql = "INSERT INTO cookie(value) VALUES (?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, cookie.getValue());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteAll() {
		try {
			Connection connection = JDBCConnection.connectToDataBase();

			String sql = "DELETE FROM cookie WHERE id > 0";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<CookieModel> getAll() {
		List<CookieModel> list = new ArrayList();
		
		try {
			Connection connection = JDBCConnection.connectToDataBase();

			String sql = "SELECT * FROM cookie";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String value = rs.getString("value");
				
				CookieModel c = new CookieModel(id, value);
				
				list.add(c);
			}
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
