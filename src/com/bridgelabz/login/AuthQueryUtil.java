package com.bridgelabz.login;

public class AuthQueryUtil {
	public static final String GET_LOGIN_AUTHENTICATION = "select user_name from m_login where user_email=? and password=?";
	public static final String GET_BOOK_DETAILS="select * from book_library";
	public static final String SET_BOOK_DETAILS="insert into book_library (book_id,book_title,book_author,catagories,book_price) values(?,?,?,?,?)";
	public static final String UPDATE_BOOK_DETAILS="UPDATE book_library SET book_title=?, book_author=?,book_price=? WHERE book_id=?";
	public static final String GET_BOOK_TITLE="select book_title,book_id from book_library where catagories=?";
	public static final String FETCH_BOOK_DETAILS = "select * from book_library where book_id = ?";
	public static final String DELETE_BOOK_TITAL = "delete from book_library where book_id = ?";
	public static final String SET_USER_DETAILS ="insert into m_login(user_name,user_email,password,mob_no,gender,confirm_password)"+
			" values(?,?,?,?,?,?)";
}
