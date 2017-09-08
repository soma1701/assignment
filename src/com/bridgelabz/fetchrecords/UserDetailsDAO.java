package com.bridgelabz.fetchrecords;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bridgelabz.login.AuthQueryUtil;
import com.bridgelabz.modal.Userdetails;

public class UserDetailsDAO {

	public int getRegister(Userdetails objUserdetails) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int status=0;
		connection = BookDetailsDAO.getConnection();
		int counter=1;
		try {
			preparedStatement=connection.prepareStatement(AuthQueryUtil.SET_USER_DETAILS);
			preparedStatement.setString(1,objUserdetails.getUserName());
			preparedStatement.setString(2,objUserdetails.getEmail());
			preparedStatement.setString(3,objUserdetails.getPassword());
			preparedStatement.setString(4, objUserdetails.getGender());
			preparedStatement.setLong(5, objUserdetails.getMobNo());
			preparedStatement.setString(6, objUserdetails.getConfirmPassword());
			status=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}

	

}
