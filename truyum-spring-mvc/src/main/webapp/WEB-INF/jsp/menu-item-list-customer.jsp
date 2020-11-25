<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
 <style>
			<%@ include file="style.css" %>
			</style>
</head>
<body>
	<div class="header">
		<img src="image/Capture.JPG" style="float: left" height="55"> <a
			href="show-cart" style="color:white;">Cart</a> <a href="show-menu-list-customer" style="color:white;">Menu</a>

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
	 <center><p id="approved"><c:if test="${status}">Item added to cart successfully</c:if></p></center>            <br>
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
				<td>${item.freeDelivery}</td>
				<td>${item.price}</td>
				<td>${item.category}</td>
				<td><a href="/add-to-cart?menuItemId=${item.id}">Add to Cart</a></td>
			</tr>
		</c:forEach>
	</table>
	<footer>
		<img src="image/foot.JPG" style="float: left">
	</footer>
</body>
</html>