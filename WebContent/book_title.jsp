<%@page import="java.util.*,com.bridgelabz.modal.BookDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<body>
<% List<BookDetails> alBookDetails=(List<BookDetails>)request.getAttribute("BookDetails"); 
	for(int i=0;i<alBookDetails.size();i++){%>
	<div class="row">
		<div class="col-md-3"><%= i+1 %></div>
		<div class="col-md-3"><span onclick="fetchDetails(<%=alBookDetails.get(i).getBookId() %>,'N')" data-toggle="modal" data-target="#book-detail"><%=alBookDetails.get(i).getBookTitle()%></span></div>
		<div class="col-md-3" ><button class="btn" onclick="deleteBook(<%=alBookDetails.get(i).getBookId() %>)" id="deletemodal" type="button" name="delete"  value="delete">Delete</button></div>
		<div class="col-md-3"><button onclick="fetchDetails(<%=alBookDetails.get(i).getBookId() %>,'Y')" class="btn" type="button" name="edit" value="edit" data-toggle="modal" data-target="#book-detail">Edit</button></div>
		 <div class="modal fade" id="book-detail" role="dialog">
		    <div class="modal-dialog">
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Science book details</h4>
		        </div>
        		<div class="modal-body" id="book-details">
        		</div>
		       </div>
		     </div>
		   </div>
		</div>
<% } %>

</body>
</html>