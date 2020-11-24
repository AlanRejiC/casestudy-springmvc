<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>
       <head>
           <link rel="stylesheet" type="text/css" href="style/style.css">
       </head>
       <body>
           <div class="header">
            <img src="image/Capture.JPG" style="float:left" height="55">
               <a href="menu-item-list-admin.html" >Menu</a>
           </div>
           <br>
           <br>
           <br>
           <br>
           <h1>Menu Items</h1>
           <br>
           <br>
           <br>
           <br>
           <table>
               <tr id="head">
                   <td><label for="mname"><b>Name</b></label></td>
                   <td></td>
                   <td><label for="price"><b>Price</b></label></td>
                   <td><label for="active"><b>Active</b></label></td>
                   <td><label for="launch"><b>Date of Launch</b></label></td>
                   <td><label for="category"><b>Category</b></label></td>
                   <td><label for="delivery"><b>Free Delivery</b></label></td><td><label for="edit"><b>Action</b></label></td>
               </tr>
               <tr>
            	<c:forEach var="item" items="${menuItemList}">
            	<td>${item.name}</td>
            	<td>${item.price}</td>
            	<td>${item.active}</td>
            	<td>${item.dateOfLaunch}</td>
            	<td>${item.category}</td>
            	<td>${item.freeDelivery}</td>
            	<td><a>Edit</a>
            	</c:forEach>
            	</tr>
           </table>
           <footer>
               <img src="image/foot.JPG" style="float:left">
           </footer>
       </body>
    </html>