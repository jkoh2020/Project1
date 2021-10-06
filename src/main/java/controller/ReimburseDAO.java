package controller;

import java.sql.*;

import model.Reimbursement;
import model.UserAccount;


public class ReimburseDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "12345";
		
	private static final String insert = "INSERT INTO demo.rem(name, title, description, amount, status, id) VALUES(?,?,?,?,?,?)";	
	private static final String selectReimburseById = "SELECT * from rem where id = ?";
//	private static final String selectAllReimbursement = "SELECT * from rem";
	private static final String delete = "DELETE from rem where reID = ?";
	private static final String update = "UPDATE rem set name = ?, title = ?, description = ?, amount = ?, status = ?, id = ? where reID = ?";

	
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
	
	//Create reimbursement
	public void insertReimburse(Reimbursement reimburse) throws SQLException {
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(insert);) {
		
			ps.setString(1, reimburse.getName());
			ps.setString(2, reimburse.getTitle());
			ps.setString(3, reimburse.getDescription());
			ps.setString(4, reimburse.getAmount());
			ps.setString(5, reimburse.getStatus());
			ps.setInt(6, reimburse.getEmployeeID());
			ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Update user
		public void updateReimburse(Reimbursement reimburse) throws SQLException {
			//boolean rowUpdated;
			try(Connection con = getConnection();
					PreparedStatement ps = con.prepareStatement(update);){
				ps.setString(1, reimburse.getName());
				ps.setString(2, reimburse.getTitle());
				ps.setString(3, reimburse.getDescription());
				ps.setString(4, reimburse.getAmount());
				ps.setString(5, reimburse.getStatus());
				ps.setInt(6, reimburse.getEmployeeID());
				ps.setInt(7, reimburse.getReimbursementID());
				ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
//			return rowUpdated;
			
		}
	
	//Get values of reimbursement
	
	//Select user by id
		public Reimbursement getReimbursement(int id) {
			Reimbursement user = new Reimbursement();
			
			try(Connection con = getConnection();
					//Create a statement using connection object
					PreparedStatement ps = con.prepareStatement(selectReimburseById);){
				
				ps.setInt(1, id);
				System.out.println(ps);
				//Execute the query
				ResultSet rs = ps.executeQuery();
				
				//Process the ResultSet object
				while(rs.next()) {
					user.setReimbursementID(Integer.parseInt(rs.getString("reID")));
					user.setName(rs.getString("name"));
					user.setTitle(rs.getString("title"));
					user.setDescription(rs.getString("description"));
					user.setAmount(rs.getString("amount"));
					user.setStatus(rs.getString("status"));
								
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
		}
	
	//Select user by id
	public Reimbursement select(int id) {
		Reimbursement user = null;
		
		try(Connection con = getConnection();
				//Create a statement using connection object
				PreparedStatement ps = con.prepareStatement(selectReimburseById);){
			
			ps.setInt(1, id);
			System.out.println(ps);
			//Execute the query
			ResultSet rs = ps.executeQuery();
			
			//Process the ResultSet object
			while(rs.next()) {
				int reimburseID = rs.getInt("reID");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String amount = rs.getString("amount");
				String status = rs.getString("status");
				
				user = new Reimbursement(id, reimburseID, name, title, description, amount, status);
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	//Delete Reimbursement
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
		
	//Approve
		public Reimbursement status(int reID) {
			Reimbursement user = new Reimbursement();
			
			try(Connection con = getConnection();
					//Create a statement using connection object
					PreparedStatement ps = con.prepareStatement("SELECT * from rem where reID = ?");){
				
				ps.setInt(1, reID);
				System.out.println(ps);
				//Execute the query
				ResultSet rs = ps.executeQuery();
				
				//Process the ResultSet object
				while(rs.next()) {
					
					user.setName(rs.getString("name"));
					user.setTitle(rs.getString("title"));
					user.setDescription(rs.getString("description"));
					user.setAmount(rs.getString("amount"));
					user.setStatus(rs.getString("status"));
					user.setEmployeeID(rs.getInt("id"));
					
							
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
		}
		
		//Select user by id
				public Reimbursement getRem(int reID) {
					Reimbursement user = new Reimbursement();
					
					try(Connection con = getConnection();
							//Create a statement using connection object
							PreparedStatement ps = con.prepareStatement("SELECT * from rem where reID = ?");){
						
						ps.setInt(1, reID);
						System.out.println(ps);
						//Execute the query
						ResultSet rs = ps.executeQuery();
						
						//Process the ResultSet object
						while(rs.next()) {
							user.setReimbursementID(Integer.parseInt(rs.getString("id")));
							user.setName(rs.getString("name"));
							user.setTitle(rs.getString("title"));
							user.setDescription(rs.getString("description"));
							user.setAmount(rs.getString("amount"));
							user.setStatus(rs.getString("status"));
										
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return user;
				}
		
	
	
}
