<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<div class="header">
		<img src="image/Capture.JPG" style="float: left" height="55"> <a
			href="cart.html">Cart</a> <a href="menu-item-list-customer.html">Menu</a>

	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h1>Menu Items</h1>
	<table>
		<tr id="head">
			<td><label for="mname">Name</label></td>
			<td></td>
			<td><label for="delivery">Free Delivery</label></td>
			<td><label for="price">Price</label></td>
			<td><label for="category">Category</label></td>
			<td><label for="edit">Action</label></td>
		</tr>
		<c:forEach var="item" items="${menuItemList}">
			<tr>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.active}</td>
				<td>${item.dateOfLaunch}</td>
				<td>${item.category}</td>
				<td>${item.freeDelivery}</td>
				<td><a>Edit</a>
			</tr>
		</c:forEach>
	</table>
	<footer>
		<img src="image/foot.JPG" style="float: left">
	</footer>
</body>
</html>