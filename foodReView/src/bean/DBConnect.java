package bean;

/*
 * DB 세팅  
 * 
 * 
 * 
 * 
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	Connection conn;
	
	String driver = "oracle.jdbc.driver.OracleDriver"; // 상수
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";  //db의 경로  정식버전 orcl //127.0.0.1 localhost 
	String dbUser = "hr";
	String dbPwd = "hr";
		

	public DBConnect() {
			try {
				//driver loading
				Class.forName(driver);
				
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
				
			}catch (Exception ex) {
				ex.printStackTrace();
			}
	}
	
	
	
	public Connection getConn() {
		return conn;
	}


	
	
}
