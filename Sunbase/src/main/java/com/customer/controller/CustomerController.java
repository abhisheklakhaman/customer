package com.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.model.Customer;
import com.customer.service.CustomerService;
import com.customer.service.CustomerServiceImpl;

@WebServlet("/customers")
public class CustomerController extends HttpServlet {

	private CustomerService customerService = new CustomerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "list";
		}

		switch (action) {
		case "new":
			showNewForm(request, response);
			break;
		case "edit":
			showEditForm(request, response);
			break;
		case "delete":
			deleteCustomer(request, response);
			break;
		default:
			listCustomer(request, response);
			break;
		}

	}

	private void listCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Customer> customers = customerService.getAllCustomer();
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/WEB-INF/views/customer-list.jsp").forward(request, response);

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		Customer existingCustomer = customerService.getCustomerById(id);
		request.setAttribute("customer", existingCustomer);
		request.getRequestDispatcher("/WEB-INF/views/customer-form.jsp").forward(request, response);

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/customer-form.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = request.getParameter("id") != null && !request.getParameter("id").isEmpty()
				? Long.parseLong(request.getParameter("id"))
				: null;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setEmail(email);
		customer.setPhone(phone);
		customer.setAddress(address);

		if (id == null) {
			customerService.saveCustomer(customer);
		} else {
			customerService.updateCustomer(customer);
		}
		response.sendRedirect("customers");

	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		long id = Long.parseLong(request.getParameter("id"));
		customerService.deleteCustomer(id);
		response.sendRedirect("customers");

	}

}
