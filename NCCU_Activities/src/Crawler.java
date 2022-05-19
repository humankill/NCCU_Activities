import java.net.*;  
import java.io.*;  


public class Crawler{  
	
	
	public static void main(String[] args){  
		    String output  = getUrlContents("https://moltke.nccu.edu.tw/Registration/registration.do?action=conferenceList");  
		    System.out.println(output);  
		  }  
		  
		  private static String getUrlContents(String theUrl){
			  
		    StringBuilder content = new StringBuilder();  
		  // Use try and catch to avoid the exceptions  
		    try  
		    {  
		      String retVal="";
		      URL url = new URL(theUrl); // creating a url object  
		      URLConnection urlConnection = url.openConnection(); // creating a urlconnection object 
		      
		      urlConnection.setRequestProperty("User-agent", "Chrome/7.0.517.44");

				InputStream in = urlConnection.getInputStream();
		  
		      // wrapping the urlconnection in a bufferedreader  
		      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in,"utf-8"));  
		      String line;  
		      // reading from the urlconnection using the bufferedreader  
		      while ((line = bufferedReader.readLine()) != null)  
		      {  
		        retVal+=line;
		      }  
		      return retVal;
		    }  
		    catch(Exception e)  
		    {  
		      e.printStackTrace();  
		    }  
		    return content.toString();  
		  }  
		}  