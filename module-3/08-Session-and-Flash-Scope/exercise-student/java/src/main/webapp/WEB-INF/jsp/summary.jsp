<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Favorite Things Exercise</h1>

<div>
    <h2>Favorite Color:</h2>
    <c:out value="${color.name}" />
</div>

<div>
    <h2>Favorite Food: </h2>
    <c:out value="${food.name}" />
</div>

<div>
    <h2>Favorite Season: </h2>
    <c:out value="${season.name}" />
</div>