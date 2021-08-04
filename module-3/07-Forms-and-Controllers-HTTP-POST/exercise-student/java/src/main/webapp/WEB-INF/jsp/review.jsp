<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Product Review</title>
</head>
<body>
<div class="container-fluid">
	<c:url var="homeURL" value="/home" />
	<a href="${homeURL}">Home</a>

	<h1>
		<c:out value="Squirrel Cigar Parties For Dummies" />
	</h1>

	<c:url var="bookURL" value="/etc/forDummies.png" />
	<img src="${bookURL}" alt="book" />

	<c:url var="formAction" value="/review" />
</div>
	<form action="${formAction}" method="POST">
		<div class="container">
			<label for="username">Username</label>
			<input type="text"
				id="username" required>
		</div>

		<div class="container-fluid">
			<label for="rating">Rating</label>
			<select id="rating" name="rating">
				<option value="1">1 Star</option>
				<option value="2">2 Stars</option>
				<option value="3">3 Stars</option>
				<option value="4">4 Stars</option>
				<option value="5">5 Stars</option>
			</select>
		</div>
		<div>
			<label for="title">Review Title</label> <input type="text"
				id="title" required />
		</div>
		<div class="container-fluid">
			<label for="text">Review Text</label> <input type="text"
				id="text" required /> <input type="submit" value="Submit" />
		</div>
	</form>

<div class="container-fluid">
		<c:forEach var="post" items="${posts}">
			<div class="post">
				<div class="container">
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