<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>Home</title>
</head>
<body>
<div class="container-fluid">
	<c:url var="reviewURL" value="/review" />
	<a href="${reviewURL}">Add Review</a>

	<h1>
		<c:out value="Squirrel Cigar Parties For Dummies" />
	</h1>

	<c:url var="bookURL" value="/etc/forDummies.png" />
	<img src="${bookURL}" alt="book" />
</div>
<div class="container-fluid">
		<c:forEach var="post" items="${posts}">
			<div class="post container-fluid">
				<div class="container-fluid">
					<strong><c:out value="${post.title}" /></strong>
					<c:out value="(${post.username})" />
				</div>
				<div class="container-fluid">
					<c:out value="${post.dateSubmitted}" />
				</div>
				<div class="container-fluid">
					<c:forEach begin="1" end="${post.rating}" var="num">
						<c:url var="starURL" value="/etc/star.png" />
						<img src="${starURL}" alt="gold star" />
					</c:forEach>
				</div>
				<p>${post.text}</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>