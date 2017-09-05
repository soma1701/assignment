<%@ page import="java.util.*,com.bridgelabz.modal.BookDetails" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}
.form{ height:900px;
       width:900px;
}
</style>

</head>
<body>
<% 
if(session.getAttribute("userName")==null){
	response.sendRedirect("signin.jsp");
}
List<BookDetails> alBookDetails=(List<BookDetails>)request.getAttribute("BookDetails");
 /* for(int i = 0;i<alBookDetails.size();i++){
	System.out.println(alBookDetails.get(i).getTitle());
}  */

%>
<p>welcome to log in page of book library ${userName} </p>
<form action="logout" method="get">
<input type="hidden" name="ACTION_MODE" value="LOGOUT">
<input class="logout" type="submit" value="logout">
</form>

<select id="science" name="science">
<option value="head">Science Book</option>
<% for(int i = 0;i<alBookDetails.size();i++){ %>
	<%if(alBookDetails.get(i).getBookCatagory().equals("Science")){ %>
  <option value=<%=alBookDetails.get(i).getTitle() %>><%= alBookDetails.get(i).getTitle() %></option>
  <%} }%>
</select>
<select id="commerce" name="commerce">
<option value="commerce">Commerce</option>
<%for(int i=0;i<alBookDetails.size();i++){ %>
<%if(alBookDetails.get(i).getBookCatagory().equals("commerce")){ %>
<option value=<%= alBookDetails.get(i).getBookTitle%>><%= alBookDetails.get(i).getTitle() %></option>
<%}} %>
</select>
<select id="arts" name="arts">
<option value="Arts">Arts</option>
<%for(int i=0;i<alBookDetails.size();i++){ 
if(alBookDetails.get(i).getBookCatagory().equals("Arts")){
%>
<option value=<%= alBookDetails.get(i).getTitle() %>><%=alBookDetails.get(i).getTitle() %></option>
<%}} %>
</select>
<button id="add">+ </button>

<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <form class="form" name="book_library" method="get" action="onsubmit">
    <input type="hidden" value="SAVE" name="ACTION_MODE"><br>
    <label id="book_id" >Enter book_id</label>
    <input type="text" name="bookId" placeholder="enter book_id">
    <label id="book_id" >Enter book_title</label>
    <input type="text" name="bookTitle" placeholder="enter book_title">
    <label id="book_id" >Enter book_author</label>
    <input type="text" name="bookAuthor" placeholder="enter book_author">
    <label id="book_id" >Enter catagories</label>
    <input type="text" name="bookCatagory"placeholder="enter book_catagories">
    <label id="book_id" >Enter book_price</label>
    <input type="text" name="bookPrice" placeholder="enter book_price">
    <button id="add" >insert</button>
    </form>
  </div>

</div>
</body>
<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("add");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
</html>