package com.bridgelabz.auth;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.login.RequestProcessor;


public class RequestController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String actionMode = req.getParameter("ACTION_MODE");
		RequestProcessor objRequestProcessor = new RequestProcessor(); 
		switch(actionMode){
		case "LOGIN":
//			com.bridgelabz.login.Authentication objLogin = new com.bridgelabz.login.Authentication();
			objRequestProcessor.doLogin(req,resp);
			break;
		case "LOGOUT":
//			Authentication objLogout = new Authentication();
			objRequestProcessor.doLogout(req,resp);
			break;
		case "SAVE_BOOK":
			objRequestProcessor.doSaveData(req,resp);
			break;
		case "FETCH_DATA":
			objRequestProcessor.doFetchData(req,resp);
			break;
		case "FETCH_BOOK_DETAILS":
			objRequestProcessor.fetchBookDetails(req,resp);
			break;
		case "DELETE_BOOK":
			objRequestProcessor.deleteBook(req,resp);
			break;
		case "EDIT_BOOK_DETAILS":
			objRequestProcessor.editBookDetails(req,resp);
			break;
			default :
				
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
	}
}
