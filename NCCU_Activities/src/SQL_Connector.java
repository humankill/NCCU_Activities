import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL_Connector {
 // mysqlb
 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
 static final String DB_URL = "jdbc:mysql://localhost:3307/nccu_activities?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
 //userid&password
 static final String USER = "Group12";
 static final String PASS = "Pleasepass01";

 // sql server

 static final String ms_sql_conn_string = "jdbc:sqlserver://localhost;";
 static final String ms_sql_db = "database=" + "database;";
 static final String ms_sql_user = "user=" + "user;";
 static final String ms_sql_pass = "password=" + "password;";

 public static void main(String[] args) throws ClassNotFoundException {

  // run mysql
  connection_mysql();

  // run sqlserver
  //connection_sqlserver();
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
     Connection conn =  DriverManager.getConnection(DB_URL, USER, PASS);
     System.out.println("mysql Connection Success");
     Statement st= conn.createStatement();

      // Select city table
      
     } catch (SQLException e) {
      e.printStackTrace();
     }
 }
}