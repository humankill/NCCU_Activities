import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class SQL_Connector {
 // mysqlb
 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
 static final String DB_URL = "jdbc:mysql://localhost:3307/nccu_activities?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
 //userid&password
 static final String USER = "Group12";
 static final String PASS = "Pleasepass01";
 static Connection conn;
 static Activity act;
 static User user;

 public static void main(String[] args) throws ClassNotFoundException {
  // run mysql
  connection_mysql();
  user = new User(getCon());
  act = new Activity(getCon());
  act.applicants(getCon());
  act.feedback(getCon());
  user.saved(getCon());
  user.viewHistory(getCon());
  user.attendHistory(getCon());
 }
 
 public static void connection_mysql() {
  try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Driver loaded!");
     } catch (ClassNotFoundException e) {
      System.out.println("Can't find driver");
      e.printStackTrace();
     }
  
    try {
     conn =  DriverManager.getConnection(DB_URL, USER, PASS);
     System.out.println("mysql Connection Success");
     java.sql.DatabaseMetaData dbm = conn.getMetaData();
     Statement stmt = conn.createStatement();
     
     ResultSet manager = dbm.getTables(null,null,"manager",null);
     if(manager.next()) {
    	 System.out.println("Manager table existed");
     }
     else {
    	 String managerTable = "CREATE TABLE MANAGER "
    			 			+"(manager_id INT not NULL AUTO_INCREMENT,"
    			 			+"m_name VARCHAR(20) not NULL, "
    			 			+"m_phone_no INT not NULL,"
    			 			+"m_email VARCHAR(30) not NULL, "
    			 			+"m_password VARCHAR(20) not NULL, "
    			 			+"PRIMARY KEY(manager_id))";
    	stmt.executeUpdate(managerTable);
    	System.out.println("Manager table created");
     }
      
     } catch (SQLException e) {
      e.printStackTrace();
     }
 }
 
 		public static Connection getCon() {
 			return conn;
 		}
}
