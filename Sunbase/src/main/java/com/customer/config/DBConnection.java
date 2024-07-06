package com.customer.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

	private static Connection connection;

	public static void main(String[] args) {
		Properties properties = new Properties();

		try {
			properties.load(DBConnection.class.getClassLoader().getResourceAsStream("db.properties"));
			String url = properties.getProperty("jdbc.url");
			String username = properties.getProperty("jdbc.username");
			String password = properties.getProperty("jdbc.password");
			String driverClassName = properties.getProperty("jdbc.driverClassName");

			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				System.out.println("Connected to the database.");
			} else {
				System.out.println("Failed to connect to the database.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
