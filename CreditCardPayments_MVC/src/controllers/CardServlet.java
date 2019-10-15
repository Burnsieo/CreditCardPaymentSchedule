package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CreditCard;

/**
 * Servlet implementation class CardServlet
 */
@WebServlet(
		description = "Servlet which controls the creation of a payment schedule", 
		urlPatterns = { 
				"/CardServlet", 
				"/doCalculate"
		})
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get input
		//doGet(request, response);
		CreditCard card = new CreditCard();
		
		card.setfName(request.getParameter("firstName"));
		card.setlName(request.getParameter("lastName"));
		card.setAccountNumber(Integer.parseInt(request.getParameter("accountNumber")));
		card.setCurrentBalance(Double.parseDouble(request.getParameter("currentBalance")));
		card.setPayoffRate(Double.parseDouble(request.getParameter("payoffRate")));
		
		String url = "/paymentSchedule.jsp";
		String msg = "Working";
		String html = card.calculate();
		
		request.setAttribute("html", html);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
