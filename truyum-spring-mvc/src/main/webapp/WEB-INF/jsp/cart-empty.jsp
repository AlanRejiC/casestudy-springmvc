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
            <br>
            <p id="disapproved"><a href="show-menu-list-customer">No items in Cart please click here to add</a></p>
           <footer>
               <img src="image/foot.JPG" style="float:left">
           </footer>
        </body>
    </html>
