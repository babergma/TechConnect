<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
    <c:param name="title" value="Favorite Season" />
</c:import>

<h2>What is your favorite season?</h2>

    <c:url var="seasonURL" value="/FavoriteThings/Page3" />

    <form action="${seasonURL}" method="POST">
        <fieldset>
        <INPUT TYPE="radio" name="input" value="Spring"/>Spring
        <INPUT TYPE="radio" NAME="input" VALUE="Winter"/>Winter
        <INPUT TYPE="radio" NAME="input" VALUE="Summer"/>Summer
        <INPUT TYPE="radio" NAME="input" VALUE="Fall"/>Fall
        <input type="submit" value="Next >>>" />
</fieldset>
    </form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />