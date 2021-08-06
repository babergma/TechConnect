<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="common/header.jspf" %>

<h1>New User Registration</h1>

<c:url var="registrationURL" value="/registration" />

<form:form action="${registrationURL}" method="POST" modelAttribute="newRegister">
    <label for="firstName">First Name</label>
    <form:input path="firstName" placeholder="enter first name"/>
    <form:errors path="firstName"/>

    <label for="lastName">Last Name</label>
    <form:input path="lastName" placeholder="enter last name"/>
    <form:errors path="lastName"/>

    <label for="email">Email</label>
    <form:input path="email" placeholder="enter email address"/>
    <form:errors path="email"/>

    <label for="verifyEmail">Confirm Email</label>
    <form:input path="verifyEmail" placeholder="verify email address"/>
    <form:errors path="emailMatching"/>

    <label for="password">Password</label>
    <form:input path="password" placeholder="enter password"/>
    <form:errors path="password"/>

    <label for="verifyPassword">Confirm</label>
    <form:input path="verifyPassword" placeholder="verify password"/>
    <form:errors path="passwordMatching"/>

    <label for="birthday">Birthday</label>
    <form:input type="date" path="birthday" placeholder="enter birthday"/>
    <form:errors path="birthday"/>

    <label for="tickets"># of Tickets</label>
    <form:input path="tickets" placeholder="enter number of tickets"/>
    <form:errors path="tickets"/>

    <br />

    <input type="submit" value="Submit" />
</form:form>

<%@include file="common/footer.jspf" %>