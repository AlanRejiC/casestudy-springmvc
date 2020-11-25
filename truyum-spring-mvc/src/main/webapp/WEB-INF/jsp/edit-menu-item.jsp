<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
    <html>
       <head>
            <style>
			<%@ include file="style.css" %>
			</style>
       </head>
       <body>
           <div class="header">
            <img src="Capture.JPG" style="float:left" height="55">
               <a href="show-menu-list-admin" style="color:white;">Menu</a>
           </div>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <h1>Edit Menu Item</h1>
            <form:form class="form-edit-menu" modelAttribute="menuItem" name="menuItemForm" method="POST" action="edit-menu-item-status">
                <form:hidden path="id" />
                <table>
                    <tr id="head">
                        <td><label for="pname">Name</label></td></tr>
                    
                </table>
                <table>
                    <tr>
                        <td id="om"><form:input path="name" type="text" name="pname" id="pname" minlength="2" maxlength="65" value="${menuItem.name}"/>
                        <form:errors path="name"></form:errors></td>
                    </tr>
                    <tr id="head">
                        <td><label for="price">Price in Rs</label></td>
                        <td><label for="status">Active</label></td>
                        <td><label for="launch">Date of Launch</label></td>
                        <td><label for="category">Category</label></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="price" id="price" required value="${menuItem.price}"></td>
                        <td>Yes<input type="radio" name="launch" id="launch1" value="yes" <c:if test="${menuItem.active}">checked</c:if> /> 
                            No<input type="radio" name="launch" id="launch2" value="no" <c:if test="${not menuItem.active}">checked</c:if> /></td>
                        <td><form:input path="dateOfLaunch" type="text" name="dateOfLaunch" id="dateOfLaunch" value="${menuItem.dateOfLaunch}" /></td>
                        <td><select name="category" id="category" >
							<c:forEach var="x" items="${categoryList}">
								<option value="${x}">${x}</option>
							</c:forEach>
					</select>
                        </td>
                    </tr>
                    <tr><td><input type="checkbox" id="yes1" value="yes1" <c:if test="${menuItem.freeDelivery}">checked</c:if>><b>Free Delivery</b></td></tr>
                    <tr><a href="edit-menu-item-status.html"><td><input type="submit" name="submit" value="Save" id="submit1"></td></a></tr>
                </table>
            </form:form>
            <footer>
               <img src="foot.JPG" style="float:left">
           </footer>
        </body>
    </html>