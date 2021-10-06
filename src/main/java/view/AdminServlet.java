package view;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.UserDAO;
import model.Admin;


/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Admin admin = new Admin();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int employeeID = employeeLogin(username, password);
		
		
		if (employeeID >= 0) {
			response.sendRedirect("employeeMenu");
		}
		
		else if(username.equals(admin.getAdminUsername()) && password.equals(admin.getAdminPassword())) {
			
//			HttpSession session = request.getSession();
//			session.setAttribute("username", username);
			
			
			response.sendRedirect("admin-home.jsp");
	
		} 
		
		else {
			
			response.sendRedirect("index.html");
			response.getWriter().append("Invalid login");
		}
	}

	public static int employeeLogin(String username, String password) {
		UserDAO userDAO = new UserDAO();
		ResultSet rs;
		
		PreparedStatement ps;
		int employeeID = -1;
		
		try {
			ps = userDAO.getConnection().prepareStatement("SELECT id, name, username, password from users where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2,  password);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				employeeID = rs.getInt("id");
			}
			return employeeID;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return employeeID;
		
	}

}
