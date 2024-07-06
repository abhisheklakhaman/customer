package com.customer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customer.config.DBConnection;
import com.customer.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	private Connection connection = DBConnection.getConnection();

	@Override
	public Customer saveCustomer(Customer customer) {

		String query = "INSERT INTO customer (name,email,phone,address) VALUES (?,?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getPhone());
			ps.setString(4, customer.getAddress());
			ps.executeQuery();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				customer.setId(rs.getLong(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		String query = "UPDATE customer SET name = ?, email = ?, phone = ?, address = ? WHERE id = ?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getPhone());
			ps.setString(4, customer.getAddress());
			ps.setLong(5, customer.getId());

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customers = new ArrayList<>();
		String query = "SELECT *FROM customer";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getLong("id"));
				customer.setName(rs.getString("name"));
				customer.setEmail(rs.getString("email"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer getCustomerById(Long id) {
		Customer customer = null;
		String query = "SELECT * FROM customer WHERE id = ?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getLong("id"));
				customer.setName(rs.getString("name"));
				customer.setEmail(rs.getString("email"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public void deleteCustomer(Long id) {

		String query = "DELETE FROM customer WHERE id = ?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
