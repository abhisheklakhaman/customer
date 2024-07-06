<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Customer Form</title>
</head>
<body>
	<h1>${customer.id == null ? "New Customer" : "Edit Customer"}</h1>
    <form action="customers" method="post">
        <input type="hidden" name="id" value="${customer.id}">
        <label>Name:</label><input type="text" name="name" value="${customer.name}"><br>
        <label>Email:</label><input type="text" name="email" value="${customer.email}"><br>
        <label>Phone:</label><input type="text" name="phone" value="${customer.phone}"><br>
        <label>Address:</label><input type="text" name="address" value="${customer.address}"><br>
        <button type="submit">Save</button>
    </form>
    <a href="customers">Back to list</a>
</body>
</html>