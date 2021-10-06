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
 * Servlet implementation class ApproveServlet
 */
@WebServlet("/ApproveServlet")
public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReimburseDAO reimburseDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveServlet() {
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
			int reID = Integer.parseInt(request.getParameter("reID"));
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String amount = request.getParameter("amount");
			String status = request.getParameter("status");
			int id = Integer.parseInt(request.getParameter("id"));
			
			Reimbursement newRem = new Reimbursement(reID, name, title, description, amount, status, id);
			
			reimburseDAO.updateReimburse(newRem);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("reimburseList.jsp");
	}


}
