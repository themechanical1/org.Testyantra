package selenium_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Sample_NonSelect_Sql_Query_Execution {
	public static void main(String[] args) throws SQLException {
		//step1 : load/register the database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		//step2 : connect to database
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		//step3 : issue sql query
		Statement stat = conn.createStatement();
		//step4 : execute Query
		String query ="insert into students_info values('5','deepak','gowda','h');";
		int result=stat.executeUpdate(query);
		if(result==1) {
			System.out.println("inserted successfully====PASS");
		} else {
			 System.out.println("failed to create===Fail");	
			}
		//step5 : close the db connection
		conn.close();
		}
	}


