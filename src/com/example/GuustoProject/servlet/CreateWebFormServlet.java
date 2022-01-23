package com.example.GuustoProject.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.GuustoProject.beans.MerchantData;
import com.example.GuustoProject.utils.DBUtils;
import com.example.GuustoProject.utils.MyUtils;

@WebServlet(urlPatterns = { "/submitTelusData" })
public class CreateWebFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateWebFormServlet() {
		super();
	}

	// Show product creation page.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/webForm.jsp");
		dispatcher.forward(request, response);
	}

	// When the user enters the product information, and click Submit.
	// This method will be called.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		String businessName = (String) request.getParameter("businessName");
		String emailAddress = (String) request.getParameter("emailAddress");
		String address = (String) request.getParameter("address");
		String city = (String) request.getParameter("city");
		String province = (String) request.getParameter("province");
		String postalCode = (String) request.getParameter("postalCode");
		String phoneNumber = (String) request.getParameter("phoneNumber");
		String dateOfBirth = (String) request.getParameter("dateOfBirth");
		String carrier = (String) request.getParameter("carrier");
		
		if ("Other".equalsIgnoreCase(carrier))
			carrier = (String) request.getParameter("carrierText");
		
		MerchantData merchantData = new MerchantData(firstName, lastName, businessName, emailAddress);

		String errorString = null;

		if (errorString == null) {
			try {
				DBUtils.insertMerchantData(conn, merchantData);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}

		// Store infomation to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("webForm", merchantData);

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/webForm.jsp");
			dispatcher.forward(request, response);
		}
		// If everything nice.
		// Redirect to the product listing page.
		else {
			response.sendRedirect(request.getContextPath() + "/submitTelusData");
		}
	}

}