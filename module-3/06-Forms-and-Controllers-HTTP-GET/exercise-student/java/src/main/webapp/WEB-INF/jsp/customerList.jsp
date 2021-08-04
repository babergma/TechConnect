<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="All Customers List" />

<%@include file="common/header.jspf"%>

<c:url var="formAction" value="/customer/search" />

<div class="customerForm">
    <form method="GET" action="${formAction}">
        <input type="text" name="name" placeholder="Search" />

        <!-- Method to disable submit button until proper sort select has been made was proposed by Varun Sharma on stackoverflow -->
        <select name="sortBy" id="selectBox"
                onchange="this.form.buttonSubmit.disabled=this.options[this.selectedIndex].value=='your-first-value'">
            <option selected disabled>Sort by</option>
            <option value="last_name">Last Name</option>
            <option value="email">Email</option>
            <option value="activebool">Active</option>
        </select> <input id="buttonSubmit" type="submit" value="Submit"
                         disabled="disabled">
    </form>
</div>

<table>
    <tr class="bold">
        <td><h4>Name</h4></td>
        <td><h4>Email</h4></td>
        <td><h4>Active</h4></td>
    </tr>

    <c:forEach var="customer" items="${customers}">
        <tr>
            <td><c:out value="${customer.firstName} ${customer.lastName}" /></td>
            <td><c:out value="${customer.email}" /></td>
            <c:choose>
                <c:when test="${customer.active == true}">
                    <td><c:out value="Yes" /></td>
                </c:when>
                <c:otherwise>
                    <td><c:out value="No" /></td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</table>

<%@include file="common/footer.jspf"%>