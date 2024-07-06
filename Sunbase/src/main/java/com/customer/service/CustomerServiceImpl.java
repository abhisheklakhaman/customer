package com.customer.service;

import java.util.List;

import com.customer.DAO.CustomerDao;
import com.customer.DAO.CustomerDaoImpl;
import com.customer.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {

		return customerDao.updateCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerDao.getCustomerById(id);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerDao.deleteCustomer(id);
	}

}
