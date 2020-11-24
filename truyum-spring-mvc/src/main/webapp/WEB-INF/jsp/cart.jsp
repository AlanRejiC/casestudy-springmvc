<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>Cart</h1>
             <p id="approved"><c:if test="${status}">Item Deleted from cart</c:if></p>
            <table>
                <thead>
                    <b><td>Name</td>
                    <td>Free Delivery</td>
                    <td>Price</td></b>
                    <td></td>
                </thead>
            </table>
            <table>
		<c:forEach var="item" items="${cartList}">
			<tr>
				<td>${item.name}</td>
				<td>${item.freeDelivery}</td>
				<td>${item.price}</td>
				<td><a href="/remove-cart-item?menuItemId=${item.id}">Delete</a></td>
			</tr>
		</c:forEach>
		</table>
            <footer>
               <img src="image/foot.JPG" style="float:left">
           </footer>
        </body>
    </html>