package view;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ReimburseDAO;
import model.Reimbursement;

/**
 * Servlet implementation class ReimburseServlet
 */
@WebServlet("/ReimburseServlet")
public class ReimburseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReimburseDAO reimburseDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimburseServlet() {
      this.reimburseDAO = new ReimburseDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String amount = request.getParameter("amount");	
			String status = request.getParameter("status");
			int id = Integer.parseInt(request.getParameter("id"));
			Reimbursement newReimburse = new Reimbursement(name, title, description, amount, status, id);
			
			reimburseDAO.insertReimburse(newReimburse);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("user-home.html");
	}

}
