<%@ page import ="java.util.*,com.bridgelabz.modal.BookDetails" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="script/welcome.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
  	<div class="row">
      	<div class="col-md-6">welcome to log in page of book library ${userName}</div>
		 <div class="col-md-6">  
		 	<form action="logout" method="post">
				<input type="hidden" name="ACTION_MODE" value="LOGOUT">
				<input class="logout" type="submit" value="logout">
			</form>
		</div>
	</div>
  </div>
</nav>

<% if(session.getAttribute("userName")==null){
	response.sendRedirect("signin.jsp");} 
%>

<div class="container ">
 <div class="modal fade" style="z-index: 10000"id="book-detail" role="dialog">
   <div class="modal-dialog">
     <div class="modal-content">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal">&times;</button>
         <h4 class="modal-title"> Book details</h4>
       </div>
     		<div class="modal-body" id="book-details">
     		</div>
      </div>
    </div>
  </div>
  <h2>Catagory of Book</h2>
  <!-- Trigger the modal with a button -->
  <button type="button" onclick="loadDoc(this.value)" value="science" class="btn btn-info btn-lg" data-toggle="modal" data-target="#science">Science</button>
  <!-- Modal -->
  
    <div class="modal fade" id="science" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Science book details</h4>
	        </div>
	        <div class="modal-body" id="demo-science"></div>
       </div>
     </div>
   </div>
     
   <button type="button" onclick="loadDoc(this.value)" value="commerce" class="btn btn-info btn-lg" data-toggle="modal" data-target="#commerce">Commerce</button>

  <!-- Modal -->
  
    <div class="modal fade" id="commerce" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Commerce book details</h4>
        </div>
        <div class="modal-body" id="demo-commerce">
        </div>
       </div>
     </div>
   </div> 
  <button type="button" onclick="loadDoc(this.value)" value="arts" class="btn btn-info btn-lg" data-toggle="modal" data-target="#arts">Arts</button>

  <!-- Modal -->
  
    <div class="modal fade" id="arts" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Arts book details</h4>
        </div>
        <div class="modal-body" id="demo-arts">
        </div>
       </div>
     </div>
   </div>
   <button type="button" class="btn" data-toggle="modal" data-target="#form">Insert</button>
   
    <div class="modal fade" id="form" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Form for book_library</h4>
        </div>
        <div class="modal-body">
           <form class="form" name="book_library" method="post" action="onsubmit" onsubmit="return validateBook()">
           <input type="hidden" value="SAVE_BOOK" name="ACTION_MODE">
              
              <div class="form-group">
                <label for="bookTitle">Enter BookTitle:</label>
                <input type="text" class="form-control" id="bookTitle" name="bookTitle" placeholder="bookTitle">
              </div>
              <div class="form-group">
                <label for="bookAuthor">Enter BookAuthor:</label>
                <input type="text" class="form-control" id="bookAuthor" name="bookAuthor" placeholder="bookAuthor">
              <br><select name="bookCatagory" id="bookCatagory">
				  <option value="commerce">commerce</option>
				  <option value="science">science</option>
				  <option value="arts">arts</option>
				</select>
			</div>

            <div class="form-group">
	              <label for="bookPrice">Enter BookPrice:</label>
	              <input type="text" class="form-control" id="bookPrice" name="bookPrice" placeholder="bookPrice">
              </div>
              <div class="form-group">
  			 	<input type="submit" value="save">
  			 </div>
			</form> 
        </div>
       </div>
     </div>
   </div>
</div>
</body>
  <script>
	var currentcatagory="";
	function loadDoc(catagory) {
		currentcatagory=catagory;
	  var xhttp = new XMLHttpRequest();
	  xhttp.open("POST", "fetchBookTitle?ACTION_MODE=FETCH_BOOK_TITLE&catagory="+catagory, true);
	  xhttp.send();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("demo-"+catagory).innerHTML = this.responseText;
	    }
	  };
	}
	function fetchDetails(bookId,isEditFlow){
		var xhttp = new XMLHttpRequest();
		  xhttp.open("POST", "fetchData?ACTION_MODE=FETCH_BOOK_DETAILS&bookId="+bookId+"&isEditFlow="+isEditFlow, true);
		  xhttp.send();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		      document.getElementById("book-details").innerHTML = this.responseText;
		    }
		  };
	}
	function deleteBook(bookId,catagory){
		var xhttp = new XMLHttpRequest();
		  xhttp.open("POST", "deleteData?ACTION_MODE=DELETE_BOOK&bookId="+bookId, true);
		  xhttp.send();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	
		    loadDoc(currentcatagory);
		    
		    }
		  };
		
	}
	function validateBook(){
		var bookTitle =document.getElementById("bookTitle").value;
		var bookAuthor = document.getElementById("bookAuthor").value;
		var bookPrice = document.getElementById("bookPrice").value;
		 
		if(bookTitle==""||bookTitle==null){
			alert("bookTitle can't be null");
			return false;
		} else if(bookAuthor==""||bookAuthor==null){
				alert("bookAuthor can't be null");
			    return false;
		}
		 else if(bookPrice==""||bookPrice==null){
			alert("bookAuthor can't be null");
			return false;
		}
		return true;
	}
	


</script> 
</html>