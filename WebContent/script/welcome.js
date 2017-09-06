var currentcatagory="";
function loadDoc(catagory) {
	currentcatagory=catagory;
  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "fetchData?ACTION_MODE=FETCH_DATA&catagory="+catagory, true);
  xhttp.send();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("demo-"+catagory).innerHTML = this.responseText;
    }
  };
}
function fetchDetails(bookId,isEditFlow){
	var xhttp = new XMLHttpRequest();
	  xhttp.open("GET", "fetchData?ACTION_MODE=FETCH_BOOK_DETAILS&bookId="+bookId+"&isEditFlow="+isEditFlow, true);
	  xhttp.send();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("book-details").innerHTML = this.responseText;
	    }
	  };
}
function deleteBook(bookId,catagory){
	var xhttp = new XMLHttpRequest();
	  xhttp.open("GET", "deleteData?ACTION_MODE=DELETE_BOOK&bookId="+bookId, true);
	  xhttp.send();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	    loadDoc(currentcatagory);
	    
	    }
	  };
	
}


