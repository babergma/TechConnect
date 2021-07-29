<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="common/header.jsp">
	<c:param name="title" value="FizzBuzz"></c:param>
</c:import>

<nav id="page-options">
	<ul>
		<c:set var="numberOfItems" value="20" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>

		<c:set var="numberOfItems" value="50" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>

		<c:set var="numberOfItems" value="100" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>
	</ul>
</nav>

<%--
	REPLACE THIS COMMENT WITH YOUR UNORDERED LIST...
 --%>
<!DOCTYPE html>
<html>
<head>
	<style>
		li {
			list-style-type: none;
		}

		.fizz {
			color: blue;
		}

		.buzz {
			color: red;
		}

		.fizzbuzz {
			color: purple;
			font-size: 150%;
		}
	</style>
</head>
<body>

<ul id="fizzbuzz">
	<c:forEach var="i" begin="1" end="${param.number}" >
		<c:set var="rowClassAttribute" value=""/>
		<c:choose>
			<c:when test="${i % 3 == 0 && i % 5 == 0 }">
				<li class="fizzbuzz"><c:out value="FizzBuzz!"/></li>
			</c:when>
			<c:when test="${i % 3 == 0}">
				<li class="fizz"><c:out value="Fizz!"/></li>
			</c:when>
			<c:when test="${i % 5 == 0}">
				<li class="buzz"><c:out value="Buzz!"/></li>
			</c:when>

			<c:otherwise>
				<li class="nums"><c:out value="${i}"/></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</ul>
</body>
</html>


<c:import url="common/footer.jsp"></c:import>