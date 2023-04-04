package proj_201;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class Server {
	
	public static void main(String[] args) {
		Server server = new Server(6789);
	}

	public Server(int port) {
		ServerSocket ss = null;
		Socket s = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		
		try {
			System.out.println("Trying to bind to port " + port);
			//bind to port
			ss = new ServerSocket(port);
			System.out.println("Successfully bound to port" + port);
			s = ss.accept();
			System.out.println("connection from " + s.getInetAddress());
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream());
			String line = br.readLine();
			System.out.println("Received from client: " + line);
			pw.println("Msg received");
			pw.flush();
		} catch (IOException ioe) {
			System.out.println("ioe: " + ioe.getMessage());
		} finally {
			try {
				if(pw != null) pw.close();
				else if(br != null) br.close();
				else if(s != null) s.close();
				else if(ss != null) ss.close();
			} catch(IOException ioe) {
				System.out.println("ioe: " + ioe.getMessage());
			}
		}
	}
}
