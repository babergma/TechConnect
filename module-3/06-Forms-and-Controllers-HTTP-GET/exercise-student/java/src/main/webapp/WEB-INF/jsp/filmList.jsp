<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="All Films List" />

<%@include file="common/header.jspf"%>

<c:url var="formAction" value="/filmList/search" />

<div class="filmForm">
    <form method="GET" action="${formAction}">
        <input type="text" name="minLength" placeholder="Minimum Length" />
        <input type="text" name="maxLength" placeholder="Maximum Length" />

        <!-- Method to disable submit button until proper sort select has been made was proposed by Varun Sharma on stackoverflow -->
        <select name="genre" id="selectBox"
                onchange="this.form.buttonSubmit.disabled=this.options[this.selectedIndex].value=='your-first-value'">
            <option selected disabled>Genre</option>
            <option value="Action">Action</option>
            <option value="Animation">Animation</option>
            <option value="Children">Children</option>
            <option value="Classics">Classics</option>
            <option value="Comedy">Comedy</option>
            <option value="Documentary">Documentary</option>
            <option value="Drama">Drama</option>
            <option value="Family">Family</option>
            <option value="Foreign">Foreign</option>
            <option value="Games">Games</option>
            <option value="Horror">Horror</option>
            <option value="Music">Music</option>
            <option value="New">New</option>
            <option value="Sci-Fi">Sci-Fi</option>
            <option value="Sports">Sports</option>
            <option value="Travel">Travel</option>
        </select>

        <input id="buttonSubmit" type="submit" value="Submit"
               disabled="disabled">
    </form>
</div>

<table>
    <tr class="bold">
        <td><h4>Title</h4></td>
        <td><h4>Description</h4></td>
        <td class="align-center"><h4>Release Year</h4></td>
        <td class="align-center"><h4>Length</h4></td>
        <td class="align-center"><h4>Rating</h4></td>
    </tr>

    <c:forEach var="film" items="${films}">
        <tr>
            <td><c:out value="${film.title}" /></td>
            <td><c:out value="${film.description}" /></td>
            <td class="align-center"><c:out value="${film.releaseYear}" /></td>
            <td class="align-center"><c:out value="${film.length}" /></td>
            <td class="align-center"><c:out value="${film.rating}" /></td>
        </tr>
    </c:forEach>
</table>

<%@include file="common/footer.jspf"%>