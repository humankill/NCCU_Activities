import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	
	
public User(Connection con) {
	 try {
	     java.sql.DatabaseMetaData dbm = con.getMetaData();
	     Statement stmt = con.createStatement();
	     
	     ResultSet user = dbm.getTables(null,null,"user",null);
	     if(user.next()) {
	    	 System.out.println("User table existed");
	     }
	     else {
	    	 String userTable = "CREATE TABLE USER "
	    			 			+"(user_id INT not NULL AUTO_INCREMENT,"
	    			 			+"name VARCHAR(20) not NULL, "
	    			 			+"phone_no INT not NULL,"
	    			 			+"email VARCHAR(30) not NULL, "
	    			 			+"password VARCHAR(20) not NULL, "
	    			 			+"manager_id INT, "
	    			 			+"PRIMARY KEY(user_id),"
	    			 			+"FOREIGN KEY(manager_id) REFERENCES MANAGER(manager_id))";
	    	stmt.executeUpdate(userTable);
	    	System.out.println("User table created");
	     }
	      
	     } catch (SQLException e) {
	      e.printStackTrace();
	     }
}


		public void saved(Connection con) {
			 try {
			     java.sql.DatabaseMetaData dbm = con.getMetaData();
			     Statement stmt = con.createStatement();
			     
			     ResultSet save = dbm.getTables(null,null,"saved",null);
			     if(save.next()) {
			    	 System.out.println("Saved table existed");
			     }
			     else {
			    	 String saveTable = "CREATE TABLE SAVED "
				    			+"(user_id INT not NULL,"
		 			 			+"activity_id INT,"
		 			 			+"FOREIGN KEY(user_id) REFERENCES USER(user_id),"
	    			 			+"FOREIGN KEY(activity_id) REFERENCES ACTIVITY(activity_id))";
			    	stmt.executeUpdate(saveTable);
			    	System.out.println("Saved table created");
			     }
			      
			     } catch (SQLException e) {
			      e.printStackTrace();
			     }
		}
		
		
		
		public void viewHistory(Connection con) {
			 try {
			     java.sql.DatabaseMetaData dbm = con.getMetaData();
			     Statement stmt = con.createStatement();
			     
			     ResultSet view = dbm.getTables(null,null,"view",null);
			     if(view.next()) {
			    	 System.out.println("View history table existed");
			     }
			     else {
			    	 String viewTable = "CREATE TABLE VIEW_HISTORY "
				    			+"(user_id INT not NULL,"
		 			 			+"activity_id INT,"
				    			+"view_time TIMESTAMP not NULL,"
		 			 			+"FOREIGN KEY(user_id) REFERENCES USER(user_id),"
	    			 			+"FOREIGN KEY(activity_id) REFERENCES ACTIVITY(activity_id))";
			    	stmt.executeUpdate(viewTable);
			    	System.out.println("View history table created");
			     }
			      
			     } catch (SQLException e) {
			      e.printStackTrace();
			     }
		}
		
		
		public void attendHistory(Connection con) {
			 try {
			     java.sql.DatabaseMetaData dbm = con.getMetaData();
			     Statement stmt = con.createStatement();
			     
			     ResultSet attend = dbm.getTables(null,null,"attend_history",null);
			     if(attend.next()) {
			    	 System.out.println("Attend history table existed");
			     }
			     else {
			    	 String attendTable = "CREATE TABLE ATTEND_HISTORY "
				    			+"(user_id INT not NULL,"
		 			 			+"activity_id INT,"
				    			+"attend_status BOOLEAN DEFAULT FALSE,"   //update value to TRUE if attended
		 			 			+"FOREIGN KEY(user_id) REFERENCES USER(user_id),"
	    			 			+"FOREIGN KEY(activity_id) REFERENCES ACTIVITY(activity_id))";
			    	stmt.executeUpdate(attendTable);
			    	System.out.println("Attend history table created");
			     }
			      
			     } catch (SQLException e) {
			      e.printStackTrace();
			     }
		}
}
