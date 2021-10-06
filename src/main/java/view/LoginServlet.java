package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.UserDAO;
import model.Admin;
import model.UserAccount;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Admin admin = new Admin();
	UserDAO userDAO = new UserDAO();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
	
		
		UserDAO userDAO = new UserDAO();
		PrintWriter pw = response.getWriter();
		
		try {
			ResultSet rs;
			PreparedStatement ps;
			Connection con = userDAO.getConnection();
			ps = con.prepareStatement("SELECT * from users where username = ? and password = ?" );
			ps.setString(1, username);
			ps.setString(2,  password);
						
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				
			
				
				response.sendRedirect("user-home.jsp");
		//		response.sendRedirect("user-home.html");
				
//				pw.println("Welcome: " + name);
//				pw.println("Your employee ID: " + id);
			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("reimburseForm.html");
//			request.setAttribute("id", id);
//			dispatcher.forward(request, response);
				
				
				
			}
			else if(username.equals(admin.getAdminUsername()) && password.equals(admin.getAdminPassword())) {
				
//				HttpSession session = request.getSession();
//				session.setAttribute("username", username);
				
				
				response.sendRedirect("admin-home.html");
		
			} 
			else {
				
				response.sendRedirect("index.html");
				response.getWriter().append("Invalid login");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	}

}
