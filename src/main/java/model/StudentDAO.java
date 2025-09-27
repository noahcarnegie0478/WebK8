package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	public Student getStudentByEmail(String email, String password) {
		System.out.println(password);
		System.out.println(email);
		
		String sql = "SELECT * FROM student WHERE email = '" + email +  "' and password = '" + password + "'";
		System.out.println(sql);
		try (Connection conn = DatabaseConfigure.getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {
		        ResultSet result = pstmt.executeQuery();

		        if (result.next()) { 
	              return Student.builder().id(result.getInt("id")).fullName(result.getString("name")).studentClass(result.getString("class")).build();
	            }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return null;
			
	}
	
	
	
}