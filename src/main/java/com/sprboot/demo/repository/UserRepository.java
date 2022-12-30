package com.sprboot.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.sprboot.demo.dto.UserData;


@Repository
public class UserRepository {
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if(ObjectUtils.isEmpty(connection)) {
			
		}
		//dbconnection
		Connection connection = DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/mysql_demo_tnj", "mysql_demo_tnj", "Ebrain@20");
		return connection;
		
	}
	//public void save(User user) {
		public void save(UserData user) throws  SQLException {
	        Connection connection = getConnection();
			//String result="value entered successfully";
			//String insertQuery = "insert into tb_ragu_database (name,email,phone,address) values (?,?,?,?)";
	      
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into tb_ragu_database values (?,?,?,?,?)");
			preparedStatement.setInt(1, user.getId());	   
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setString(5, user.getAddress());
			
			preparedStatement.executeUpdate();
		
		
			
		
	}
		public void update(UserData user) throws  SQLException {
	        Connection connection = getConnection();
			//String result="value entered successfully";
			String insertQuery = " update tb_ragu_database set name=?,email=?,phone=?,address=? where id=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement( insertQuery);
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPhone());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setInt(5, user.getId());	   
			preparedStatement.executeUpdate();
		
		}
		public void delete(UserData user) throws  SQLException {
	        Connection connection = getConnection();
			//String result="value entered successfully";
			String insertQuery = "delete from tb_ragu_database where id=?";
	      
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, user.getId());	   
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		}
		
		public List<UserData> getAllUsers() throws SQLException {
			
			Connection con = getConnection();
			String selectQuery = "select * from tb_ragu_database";

			PreparedStatement ps = con.prepareStatement(selectQuery);

			ResultSet resultSet = ps.executeQuery();

			List<UserData> users = new ArrayList<UserData>();
			UserData user = null;
			while (resultSet.next()) {
				user = new UserData();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setPhone(resultSet.getString(4));
				user.setAddress(resultSet.getString(5));
				users.add(user);
			}
			return users;
		
			
			
		}
		
		public  UserData getbyId(Integer id) throws SQLException {
				Connection con = getConnection();
				String sql = "SELECT id,name,email,phone,address FROM tb_ragu_database WHERE id=?;";

				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet resultSet = ps.executeQuery();
				
				UserData user = null;
				while (resultSet.next()) {
					user = new UserData();
					user.setId(resultSet.getInt(1));
					user.setName(resultSet.getString(2));
					user.setEmail(resultSet.getString(3));
					user.setPhone(resultSet.getString(4));
					user.setAddress(resultSet.getString(5));
					
				}
				return user;
				
		
			
		}
		
			
		}

		


