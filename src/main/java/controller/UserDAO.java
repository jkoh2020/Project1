package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



import model.UserAccount;

public class UserDAO {
	
	//This DAO class provides CRUD database operators for the table users in the database.
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
	private String jdbcUsername = "root";
	private String jdbcPassword = "12345";
	
	private static final String insert = "INSERT INTO demo.users(name, username, password) VALUES(?,?,?)";	
	private static final String selectUserByID = "SELECT id, name, username, password from users where id = ?";
	private static final String selectAllUsers = "SELECT * from users";
	private static final String delete = "DELETE from users where id = ?";
	private static final String update = "UPDATE users set name = ?, username = ?, password = ? where id = ?";
	
	public Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
			
	}

	//Create or insert user
	public void insertUser(UserAccount user) throws SQLException {
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(insert);){
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//Update user
	public void updateUser(UserAccount user) throws SQLException {
		//boolean rowUpdated;
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(update);){
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getId());			
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
//		return rowUpdated;
		
	}
	
	//Get values of user
	public UserAccount getUser(int id) {
		UserAccount user = new UserAccount();
		//Establishing a connection
		try(Connection con = getConnection();
				//Create a statement using connection object
				PreparedStatement ps = con.prepareStatement(selectUserByID);){
			
			ps.setInt(1, id);
			System.out.println(ps);
			//Execute the query 
			ResultSet rs = ps.executeQuery();
			
			//Process the ResultSet object
			while(rs.next()) {
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;		
	}
	
		
	//Select user my id
	public UserAccount selectUser(int id) {
		UserAccount user = null;
		//Establishing a connection
		try(Connection con = getConnection();
				//Create a statement using connection object
				PreparedStatement ps = con.prepareStatement(selectUserByID);){
			
			ps.setInt(1, id);
			System.out.println(ps);
			//Execute the query 
			ResultSet rs = ps.executeQuery();
			
			//Process the ResultSet object
			while(rs.next()) {
				String name = rs.getString("name");
				String username = rs.getString("username");
				String password = rs.getString("password");
				user = new UserAccount(id, name, username, password);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;		
	}
	
	//Select all users
	public List<UserAccount> selectAllUsers() {
		List<UserAccount> users = new ArrayList<>();
		//Establishing a connection
		try(Connection con = getConnection();
				//Create a statement using connection object
				PreparedStatement ps = con.prepareStatement(selectAllUsers);){
			ResultSet rs = ps.executeQuery();
			
			//Process the ResultSet object
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String username = rs.getString("username");
				String password = rs.getString("password");
				users.add(new UserAccount(id, name, username, password));
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;		
	}
	//Delete user
	public boolean delete (String id) throws SQLException {
		boolean rowDeleted;
		//Establishing a connection
		try(Connection con = getConnection();
				//Create a statement using connection object
				PreparedStatement ps = con.prepareStatement(delete);){
			
			ps.setString(1, id);
			rowDeleted = ps.executeUpdate() > 0;			
			
		}
		return rowDeleted;
			
	}
}
