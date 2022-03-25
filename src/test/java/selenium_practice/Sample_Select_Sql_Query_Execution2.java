package selenium_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Sample_Select_Sql_Query_Execution2 {
	public static void main(String[] args) throws SQLException {
		//step1 : load/register the database
		Connection conn = null;
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		//step2 : connect to database
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		//step3 : issue sql query
		Statement stat = conn.createStatement();
		//step4 : execute Query
		String query = "select * from students_info";
		ResultSet result = stat.executeQuery(query);
		while(result.next()) {
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		}catch (Exception e) {
		}finally {
		//step5 : close the db connection
		conn.close();
		System.out.println("========close db connection======");
		}
	
	}

}
