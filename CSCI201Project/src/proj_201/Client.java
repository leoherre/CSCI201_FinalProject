package proj_201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Client {
     public Client(String hostname, int port) {
    	 Socket s = null;
    	 BufferedReader br = null;
    	 PrintWriter pw = null;
    	 try {
    		 System.out.println("Trying to connect to " + hostname + " on port " + port);
    		 s = new Socket(hostname, port);
    		 System.out.println("Connected!");
    		 br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    		 pw = new PrintWriter(s.getOutputStream());
    		 String str = "Hello from the client!";
    		 System.out.println("Sending: " + str);
    		 pw.println(str);
    		 pw.flush();
    		 String line = br.readLine();
    		 System.out.println("Line Received: " + line);
    	 } catch (IOException ioe) {
    		 System.out.println("IOE: " + ioe.getMessage());
    	 } finally {
    		 try {
    			 if (pw != null)
    				 pw.close();
    			 if (br != null)
    				 br.close();
    			 if (s != null)
    				 s.close();
    		 } catch (IOException ioe) {
    			 System.out.println("ioe: " + ioe.getMessage());
    		 }
    	 } // ends finally
    } // ends NetworkingClient()
    public static void main(String [] args) {
      new Client("localhost", 6789);
    }
}
