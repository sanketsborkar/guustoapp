package com.example.GuustoProject.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.GuustoProject.beans.MerchantData;
import com.example.GuustoProject.beans.UserAccount;
import com.example.GuustoProject.utils.DBUtils;
import com.example.GuustoProject.utils.MyUtils;

@WebServlet(urlPatterns = { "/viewMerchantData" })
public class ViewMerchantDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewMerchantDataServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		// Check User has logged on
		UserAccount loginedUser = MyUtils.getLoginedUser(session);

		// Not logged in
		if (loginedUser == null) {
			// Redirect to login page.
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		Connection conn = MyUtils.getStoredConnection(request);

		String errorString = null;
		List<MerchantData> list = null;
		try {
			list = DBUtils.queryMerchantData(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Store info in request attribute, before forward to views
		request.setAttribute("errorString", errorString);
		request.setAttribute("merchantDataList", list);
		
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/viewMerchantData.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}