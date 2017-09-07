package com.bridgelabz.fetchrecords;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bridgelabz.modal.Userdetails;

public class UserDetailsDAO {

	public int getRegister(Userdetails objUserdetails) {
		Connection conn=null;
		PreparedStatement ps=null;
		int status=0;
		BookDetailsDAO objBookDetailsDAO = new BookDetailsDAO();
		conn = objBookDetailsDAO.getConnection();
		int counter=0;
		try {
			ps=conn.prepareStatement("SET_USER_DETAILS");
			ps.setString(counter++,objUserdetails.getUserName());
			ps.setString(counter++,objUserdetails.getEmail());
			ps.setString(counter++,objUserdetails.getPassword());
			ps.setString(counter++, objUserdetails.getGender());
			ps.setLong(counter++, objUserdetails.getMobNo());
			status=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}

	

}
