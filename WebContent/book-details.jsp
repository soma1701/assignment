<%@ page import="com.bridgelabz.modal.BookDetails" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
.text{text-align:left}
</style>
<body>
<% BookDetails objBookDetails = (BookDetails)request.getAttribute("bookDetails");
	boolean isEditFlow = "Y".equalsIgnoreCase(request.getAttribute("isEditFlow").toString());
%>
<div class="container">
<%if(isEditFlow){ %>
<form action="editBook" class="form-group">

<div class="row">
<div class="col-md-4">Author-Name:</div><div class="col-md-8 text"><input type="text" name="bookAuthor" value="<%=objBookDetails.getBookAuthor() %>"/></div></div><br>
<div class="row">
<div class=" col-md-4">Book-Title:</div><div class="col-md-8"><input type="text" name="bookTitle" value="<%=objBookDetails.getBookTitle() %>"/></div></div><br>
<div class="row">
<div class="col-md-4">Book-Price:</div><div class="col-md-8"><input type="text" name="bookPrice" value="<%=objBookDetails.getBookPrice() %>"/></div></div><br>
<input type="hidden" value="<%= objBookDetails.getBookId()%>" name="bookId">
<input type="hidden" name="ACTION_MODE" value="EDIT_BOOK_DETAILS">
<input type="button" value="Save">
</form>
</div>
<%}else{ %>
<form action="editBook">

<div class="row">
<div class="form-group">
<div class="col-md-4">Author-Name:</div><div class="col-md-8 text"><input type="text" name="bookAuthor" value="<%=objBookDetails.getBookAuthor() %>" readonly="readonly"/></div></div></div><br>
<div class="row">
<div class=" col-md-4">Book-Title:</div><div class="col-md-8"><input type="text" name="bookTitle" value="<%=objBookDetails.getBookTitle() %>"readonly="readonly"/></div></div><br>
<div class="row"></div>
<div class="col-md-4">Book-Price:</div><div class="col-md-8"><input type="text" name="bookPrice" value="<%=objBookDetails.getBookPrice() %>"readonly="readonly"/></div></div><br>
</form>
</div>
<%} %>
<%-- <div class="row">

<div class="col-md-4">Author-Name:</div><div class="col-md-8 text"><%=objBookDetails.getBookAuthor() %></div></div><br>
<div class="row">
<div class=" col-md-4">Book-Title:</div><div class="col-md-8"><%=objBookDetails.getBookTitle() %></div></div><br>
<div class="row"></div>
<div class="col-md-4">Book-Price:</div><div class="col-md-8"><%=objBookDetails.getBookPrice() %></div></div><br>
<input type="text" value="testing" readonly> --%>



</body>
</html>