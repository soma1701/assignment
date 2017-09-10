package com.bridgelabz.fetchrecords;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.bridgelabz.login.AuthQueryUtil;
import com.bridgelabz.modal.BookDetails;

public class BookDetailsDAO {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/soma","root","giftalife");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
	
	public List<BookDetails> fetchBookDetails(BookDetailsDAO objBookDetailsDAO) throws SQLException{
	ArrayList<BookDetails> alBookDetails=new ArrayList<BookDetails>();	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection conn = null;

	try {
		conn=BookDetailsDAO.getConnection();
		ps = conn.prepareStatement(AuthQueryUtil.GET_BOOK_DETAILS);
	
		rs = ps.executeQuery();
		while(rs.next()){
			BookDetails objBookDetails =new BookDetails();
			objBookDetails.setBookId(rs.getInt("book_id"));
			objBookDetails.setBookTitle(rs.getString("book_title"));
			objBookDetails.setBookAuthor(rs.getString("book_author"));
			objBookDetails.setBookCatagory(rs.getString("catagories"));
			objBookDetails.setBookPrice(rs.getDouble("book_price"));
			alBookDetails.add(objBookDetails);
    	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		conn.close();
		rs.close();
		ps.close();		
	}
	
		return alBookDetails;
	} 
	public int saveBookDetails(BookDetails objBookDetails,int userId){
		int status=0;
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet resultSet=null;
		try {
			
			conn = BookDetailsDAO.getConnection();
			
			ps = conn.prepareStatement(AuthQueryUtil.SET_BOOK_DETAILS);
			ps.setString(1, objBookDetails.getBookTitle());
			ps.setString(2, objBookDetails.getBookAuthor());
			ps.setString(3, objBookDetails.getBookCatagory());
			ps.setDouble(4, objBookDetails.getBookPrice());
		    status=ps.executeUpdate();
		    ps = conn.prepareStatement(AuthQueryUtil.MAX_COUNT_BOOKID);
		    resultSet =  ps.executeQuery();
		    int maxCount=0;
		    while(resultSet.next())
		    {
		    	 maxCount = resultSet.getInt("max_book_id");
		    }
		    ps = conn.prepareStatement(AuthQueryUtil.INSERT_USER_ID);
			ps.setInt(1 ,maxCount);
			ps.setInt(2,userId);
			status= ps.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				resultSet.close();
				conn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return status;
		
		
	}
	 public int updateBookDetails(BookDetails objBookDetails){  
	        int status=0; 
	        Connection con=null;
	        PreparedStatement ps=null;
	        int counter=1;
	        try{  
	             con=BookDetailsDAO.getConnection();  
	             ps=con.prepareStatement(AuthQueryUtil.UPDATE_BOOK_DETAILS); 
	             ps.setString(counter++,objBookDetails.getBookTitle());
	             ps.setString(counter++, objBookDetails.getBookAuthor());
	             ps.setDouble(counter++, objBookDetails.getBookPrice());
	            ps.setInt(counter++,objBookDetails.getBookId() );
	            status=ps.executeUpdate();  
	            
	        }catch(Exception ex){
	        	ex.printStackTrace();
	        }  
	        finally {
	        	try {
					ps.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
			}
	        return status;
	      
	    }
	 

		
	public List<BookDetails> fetchBookTitle(String bookCatagory, int userId) {
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs=null;
		List<BookDetails> alBookDetails= new ArrayList<BookDetails>();
		try {
			 con=BookDetailsDAO.getConnection();
			 ps=con.prepareStatement(AuthQueryUtil.GET_BOOK_TITLE);
			 ps.setString(1,bookCatagory);
			 ps.setInt(2, userId);
			 rs=ps.executeQuery();
			 
			 while(rs.next()){
				 BookDetails objBookdetails=new BookDetails();
				
				 objBookdetails.setBookTitle(rs.getString("book_title"));
				 objBookdetails.setBookId(rs.getInt("book_id"));
				 alBookDetails.add(objBookdetails);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alBookDetails;
	}

	public BookDetails fetchBookDetails(int bookId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int counter = 1;
		BookDetails objBookDetails = new BookDetails();
		try{
			conn = BookDetailsDAO.getConnection();
			ps = conn.prepareStatement(AuthQueryUtil.FETCH_BOOK_DETAILS);
			ps.setInt(counter++, bookId);
			rs = ps.executeQuery();
			while(rs.next()){
				objBookDetails.setBookAuthor(rs.getString("book_author"));
				objBookDetails.setBookCatagory(rs.getString("catagories"));
				objBookDetails.setBookPrice(rs.getDouble("book_price"));
				objBookDetails.setBookId(rs.getInt("book_id"));
				objBookDetails.setBookTitle(rs.getString("book_title"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return objBookDetails;
	}

	public int deleteBookDetails(int bookId) {
		Connection con=null;
		PreparedStatement ps= null;
		int counter=1;
		int status=0;
		 con = BookDetailsDAO.getConnection();
		 try {
			ps= con.prepareStatement(AuthQueryUtil.DELETE_BOOK_TITAL);
			ps.setInt(counter++,bookId );
			status = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return status;
	}
	 
	
		
	
}

