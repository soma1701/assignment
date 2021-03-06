package com.bridgelabz.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bridgelabz.fetchrecords.BookDetailsDAO;
import com.bridgelabz.fetchrecords.UserDetailsDAO;
import com.bridgelabz.modal.BookDetails;
import com.bridgelabz.modal.Userdetails;

public class RequestProcessor {
	public void doLogin(HttpServletRequest req, HttpServletResponse resp){
		Userdetails objUserDetails = new Userdetails();
		AuthDao objDAO = new AuthDao();
		objUserDetails.setEmail(req.getParameter("email"));
		objUserDetails.setPassword(req.getParameter("password"));
		try {
			objUserDetails = objDAO.validateAuth(objUserDetails);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(objUserDetails.getUserName()==null){
			try {
				
				resp.sendRedirect("signin.jsp");
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
				try {
					HttpSession session=req.getSession();
					session.setAttribute("userName",objUserDetails.getUserName());
					session.setAttribute("userId",objUserDetails.getUserId());
					resp.sendRedirect("HomePage.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
	

	public void doLogout(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session=req.getSession();
		session.removeAttribute("userName");
		session.invalidate();
		try {
			resp.sendRedirect("signin.jsp");
			resp.setHeader("Cache-Control", "no-cache,no-store,must-validate");
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Expires","0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void doSaveData(HttpServletRequest req, HttpServletResponse resp) {
		BookDetails objBookDetails=new BookDetails();
		objBookDetails.setBookAuthor(req.getParameter("bookAuthor"));
		objBookDetails.setBookCatagory(req.getParameter("bookCatagory"));
		objBookDetails.setBookTitle(req.getParameter("bookTitle"));
		objBookDetails.setBookPrice(Double.parseDouble(req.getParameter("bookPrice")));
		BookDetailsDAO objBookDetailsDAO=new BookDetailsDAO();
		HttpSession session = req.getSession();
		int userId = (int) session.getAttribute("userId");
		objBookDetailsDAO.saveBookDetails(objBookDetails,userId);
		try {
			resp.sendRedirect("HomePage.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fetchBookTitle(HttpServletRequest req, HttpServletResponse resp) {
		String bookCatagory=req.getParameter("catagory");
		int userId = Integer.parseInt(req.getSession().getAttribute("userId").toString());
		BookDetailsDAO objBookDetailsDAO=new BookDetailsDAO();
		List<BookDetails> alBookDetails=objBookDetailsDAO.fetchBookTitle(bookCatagory,userId);
		req.setAttribute("BookDetails", alBookDetails);
		RequestDispatcher dispatcher=req.getRequestDispatcher("book_title.jsp");
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void fetchBookDetails(HttpServletRequest req, HttpServletResponse resp) {
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		String isEditFlow = req.getParameter("isEditFlow");
		
		BookDetailsDAO objBookDetailsDAO = new BookDetailsDAO();
		BookDetails objBookDetails = objBookDetailsDAO.fetchBookDetails(bookId);
		req.setAttribute("isEditFlow", isEditFlow);
		req.setAttribute("bookDetails", objBookDetails);
		RequestDispatcher dispatcher = req.getRequestDispatcher("book-details.jsp");
		try {
			dispatcher.include(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteBook(HttpServletRequest req, HttpServletResponse resp) {
		int bookId =Integer.parseInt(req.getParameter("bookId"));
		BookDetailsDAO objBookDetailsDAO = new BookDetailsDAO();
		 int status=objBookDetailsDAO.deleteBookDetails(bookId);
		
		
	}

	public void editBookDetails(HttpServletRequest req, HttpServletResponse resp) {
		BookDetails objBookDetails = new BookDetails();
		objBookDetails.setBookTitle(req.getParameter("bookTitle"));
		objBookDetails.setBookAuthor(req.getParameter("bookAuthor"));
		objBookDetails.setBookPrice(Double.parseDouble(req.getParameter("bookPrice")));
		objBookDetails.setBookId(Integer.parseInt(req.getParameter("bookId")));
		BookDetailsDAO objBookDetailsDAO = new BookDetailsDAO();
		objBookDetailsDAO.updateBookDetails(objBookDetails);
		try {
			resp.sendRedirect("HomePage.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void doRegister(HttpServletRequest req, HttpServletResponse resp) {
		Userdetails objUserdetails = new Userdetails();
		objUserdetails.setUserName(req.getParameter("userName"));
		objUserdetails.setEmail(req.getParameter("email"));
		objUserdetails.setPassword(req.getParameter("password"));
		objUserdetails.setConfirmPassword(req.getParameter("confirmPassword"));
		objUserdetails.setGender(req.getParameter("gender"));
		objUserdetails.setMobNo(Long.parseLong(req.getParameter("mobileNumber")));
		UserDetailsDAO objUserDetailsDAO = new UserDetailsDAO();
//		objUserDetailsDAO.doValidate(objUserdetails);
		objUserDetailsDAO.getRegister(objUserdetails);
		
		try {
			
			resp.sendRedirect("signin.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
		
	


}
