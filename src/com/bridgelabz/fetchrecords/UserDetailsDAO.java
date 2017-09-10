package com.bridgelabz.fetchrecords;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			preparedStatement.setString(counter++,objUserdetails.getUserName());
			preparedStatement.setString(counter++,objUserdetails.getEmail());
			preparedStatement.setString(counter++,objUserdetails.getPassword());
			preparedStatement.setLong(counter++, objUserdetails.getMobNo());
			preparedStatement.setString(counter++, objUserdetails.getGender());
			status=preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}

	/*public void doValidate(Userdetails objUserdetails) {
		String userName = objUserdetails.getUserName();
		String email = objUserdetails.getEmail();
		Connection connection=null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		connection = BookDetailsDAO.getConnection();
		try {
			connection.prepareStatement(AuthQueryUtil.GET_REGISTER_AUTHENTICATION);
			prepareStatement.setString(1, userName);
			prepareStatement.setString(2,email);
			String name,mail;
			while(resultSet.next()){
				name = resultSet.getString("user_name");
				mail = resultSet.getString("user_email");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
	

}
