package com.bridgelabz.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.modal.Userdetails;


public class AuthDao {
	public Userdetails validateAuth(Userdetails objUserDetails) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		int counter = 1;
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soma","root","giftalife");
			ps = conn.prepareStatement(AuthQueryUtil.GET_LOGIN_AUTHENTICATION);
			ps.setString(counter++, objUserDetails.getEmail());
			ps.setString(counter++, objUserDetails.getPassword());
			rs = ps.executeQuery();
			while(rs.next()){
				objUserDetails.setUserId(rs.getInt("user_id"));
				objUserDetails.setUserName(rs.getString("user_name"));
			}
		}catch(Exception sqlExp){
			
			sqlExp.printStackTrace();
		}finally{
			conn.close();
			rs.close();
			ps.close();
			
			
		}
		return objUserDetails;
	}
	

}
