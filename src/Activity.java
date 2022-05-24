import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Activity {
	
	
public Activity(Connection con) {
	activityType(con);
	 try {
	     java.sql.DatabaseMetaData dbm = con.getMetaData();
	     Statement stmt = con.createStatement();
	     
	     ResultSet activity = dbm.getTables(null,null,"activity",null);
	     if(activity.next()) {
	    	 System.out.println("Activity table existed");
	     }
	     else {
	    	 String activityTable = "CREATE TABLE ACTIVITY "
	    			 			+"(activity_id INT not NULL AUTO_INCREMENT,"
	    			 			+"type_id INT not NULL,"
	    			 			+"organizer_id INT not NULL,"
	    			 			+"manager_id INT not NULL,"
	    			 			+"create_time TIMESTAMP not NULL,"
	    			 			+"a_name VARCHAR(20) not NULL, "
	    			 			+"description VARCHAR(100),"
	    			 			+"website VARCHAR(25), "
	    			 			+"a_date_time INT not NULL, "		//I'm still not sure if it is correct to use int or should we use datetime
	    			 			+"place VARCHAR(25), "
	    			 			+"no_of_applicant INT not NULL, "
	    			 			+"view_count INT, "		//update value each time the activity is viewed by user
	    			 			+"PRIMARY KEY(activity_id),"
	    			 			+"FOREIGN KEY(type_id) REFERENCES ACTIVITY_TYPE(type_id),"
	    			 			+"FOREIGN KEY(organizer_id) REFERENCES USER(user_id),"
	    			 			+"FOREIGN KEY(manager_id) REFERENCES MANAGER(manager_id))";
	    	stmt.executeUpdate(activityTable);
	    	System.out.println("Activity table created");
	     }
	      
	     } catch (SQLException e) {
	      e.printStackTrace();
	     }
}

	public void activityType(Connection con) {
		 try {
		     java.sql.DatabaseMetaData dbm = con.getMetaData();
		     Statement stmt = con.createStatement();
		     
		     ResultSet type = dbm.getTables(null,null,"activity_type",null);
		     if(type.next()) {
		    	 System.out.println("Activity type table existed");
		     }
		     else {
		    	 String typeTable = "CREATE TABLE ACTIVITY_TYPE "
		    			 			+"(type_id INT not NULL AUTO_INCREMENT,"
		    			 			+"type_name VARCHAR(20) not NULL, "
		    			 			+"PRIMARY KEY(type_id))";
		    	stmt.executeUpdate(typeTable);
		    	System.out.println("Activity type table created");
		     }
		      
		     } catch (SQLException e) {
		      e.printStackTrace();
		     }
	}
	
	public void applicants(Connection con) {
		 try {
		     java.sql.DatabaseMetaData dbm = con.getMetaData();
		     Statement stmt = con.createStatement();
		     
		     ResultSet applicants = dbm.getTables(null,null,"applicants",null);
		     if(applicants.next()) {
		    	 System.out.println("Applicants type table existed");
		     }
		     else {
		    	 String applyTable = "CREATE TABLE APPLICANTS "
					    			+"(activity_id INT not NULL,"
			 			 			+"user_id INT,"
		    			 			+"FOREIGN KEY(activity_id) REFERENCES ACTIVITY(activity_id),"
		    			 			+"FOREIGN KEY(user_id) REFERENCES USER(user_id))";
		    	stmt.executeUpdate(applyTable);
		    	System.out.println("Applicants type table created");
		     }
		      
		     } catch (SQLException e) {
		      e.printStackTrace();
		     }
	}
	
	public void feedback(Connection con) {
		 try {
		     java.sql.DatabaseMetaData dbm = con.getMetaData();
		     Statement stmt = con.createStatement();
		     
		     ResultSet feed = dbm.getTables(null,null,"feedback",null);
		     if(feed.next()) {
		    	 System.out.println("Feedback type table existed");
		     }
		     else {
		    	 String feedTable = "CREATE TABLE FEEDBACK "
		    			 			+"(feedback_id INT not NULL AUTO_INCREMENT,"
					    			+"activity_id INT not NULL,"
			 			 			+"user_id INT not NULL,"
					    			+"content VARCHAR(100),"
					    			+"manager_id INT,"
			 			 			+"feedback_time TIMESTAMP not NULL,"
					    			+"PRIMARY KEY(feedback_id),"
					    			+"FOREIGN KEY(manager_id) REFERENCES MANAGER(manager_id),"
		    			 			+"FOREIGN KEY(activity_id) REFERENCES ACTIVITY(activity_id),"
		    			 			+"FOREIGN KEY(user_id) REFERENCES USER(user_id))";
		    	stmt.executeUpdate(feedTable);
		    	System.out.println("Feedback type table created");
		     }
		      
		     } catch (SQLException e) {
		      e.printStackTrace();
		     }
	}
}
