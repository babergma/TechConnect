<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title" value="Favorite Color" />
</c:import>

<h2>What is your favorite color?</h2>

<c:url var="colorURL" value="/FavoriteThings/Page1" />
<form action="${colorURL}" method="POST">
	<input type="text" name="input" />
	<input type="submit" value="Next >>>" />
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />