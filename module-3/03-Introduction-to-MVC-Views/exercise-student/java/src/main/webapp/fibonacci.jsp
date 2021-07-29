<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="common/header.jsp">
	<c:param name="title" value="Fibonacci"></c:param>
</c:import>

<nav id="page-options">
	<ul>
		<c:set var="numberOfItems" value="20" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>

		<c:set var="numberOfItems" value="50" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>

		<c:set var="numberOfItems" value="100" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>
	</ul>
</nav>



<%--
	REPLACE THIS COMMENT WITH YOUR UNORDERED LIST...
 --%>
<ul id="fibonacci">

	<c:set var = "fib1" value = "${0}" />
	<c:set var = "fib2" value = "${1}" />
	<c:forEach var="i" begin="1" end="${param.max}">
	<c:choose>
	<c:when test="${nums<= 1}">
	<li class="nums"><c:out value="${nums}"/></li>

	</c:when>

	<c:otherwise>
		<c:set var = "newFib" value = "${fib1 + fib2}" />
		<c:set var = "fib1" value = "${fib2}" />

		<c:set var = "fib2" value = "${newFib}" />
	<li class="nums"><c:out value="${fib1 + newFib}"/></li>
	</c:otherwise>
	</c:choose>
	</c:forEach>
<c:import url="common/footer.jsp"></c:import>