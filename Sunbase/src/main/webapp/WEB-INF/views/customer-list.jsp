<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Customer List</title>
<link rel="StyleSheet" type="text/css"
	href="<c:url value='/resources/css/style.css'/>">
</head>
<body>

	<h1>Customer List</h1>
	<a href="customers?action=new">New Customer</a>
	<table border="1">
		<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Address</th>
			<th>Actions</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="customer" items="${customer}">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.phone}</td>
					<td>${customer.address}</td>
					<td>
						<a href="customers?action=edit&id=${customer.id}">Edit</a>
                        <a href="customers?action=delete&id=${customer.id}" onclick="return confirm('Are you sure?')">Delete</a>
						
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>