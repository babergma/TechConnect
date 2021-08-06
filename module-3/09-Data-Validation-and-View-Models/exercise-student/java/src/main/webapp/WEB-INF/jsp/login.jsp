<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="common/header.jspf" %>

<h1>Login</h1>

<c:url var="loginURL" value="/login" />

<form:form action="${loginURL}" method="POST" modelAttribute="newLogin">
    <label for="email">Email</label>
    <form:input path="email" placeholder="enter email"/>
    <form:errors path="email"/>

    <label for="password">Password</label>
    <form:input path="password" placeholder="enter password"/>
    <form:errors path="password"/>

    <br/>

    <input type="submit" value="Submit" />
</form:form>

<%@include file="common/footer.jspf" %>