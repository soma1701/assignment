package com.bridgelabz.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;

import org.omg.PortableInterceptor.DISCARDING;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bridgelabz.fetch_records.BookDetailsDAO;
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
		if(objUserDetails.getUsername()==null){
			try {
				resp.sendRedirect("Registration.jsp");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
				try {
					BookDetailsDAO objBookDetailsDAO=new BookDetailsDAO();
					List<BookDetails> objal  =objBookDetailsDAO.fetchBookDetails(objBookDetailsDAO);
					HttpSession session=req.getSession();
					req.setAttribute("BookDetails", objal);
					session.setAttribute("userName",objUserDetails.getUsername());
					resp.sendRedirect("Welcomefile.jsp");
//					RequestDispatcher dispatcher = req.getRequestDispatcher("Welcomefile.jsp");
//					dispatcher.include(req, resp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
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
		objBookDetails.setBookId(Integer.parseInt(req.getParameter("bookId")));
		objBookDetails.setBookCatagory(req.getParameter("bookCatagory"));
		objBookDetails.setBookTitle(req.getParameter("bookTitle"));
		objBookDetails.setBookPrice(Double.parseDouble(req.getParameter("bookPrice")));
		BookDetailsDAO objBookDetailsDAO=new BookDetailsDAO();
		objBookDetailsDAO.saveBookDetails(objBookDetails);
		try {
			resp.sendRedirect("Welcomefile.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doFetchData(HttpServletRequest req, HttpServletResponse resp) {
		String bookCatagory=req.getParameter("catagory");
		BookDetailsDAO objBookDetailsDAO=new BookDetailsDAO();
		List<BookDetails> alBookDetails=objBookDetailsDAO.fetchBookTitle(bookCatagory);
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
		objBookDetails.setBookId(Integer.parseInt(req.getParameter("bookId")));
		objBookDetails.setBookCatagory(req.getParameter("bookCatagory"));
		objBookDetails.setBookAuthor(req.getParameter("bookAuthor"));
		objBookDetails.setBookTitle(req.getParameter("bookTitle"));
		BookDetailsDAO objBookDetailsDAO = new BookDetailsDAO();
		objBookDetailsDAO.updateBookDetails(objBookDetails);
		try {
			resp.sendRedirect("book-details.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		
	


}
