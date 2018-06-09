package by.htp.io.run;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainClient {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localhost", 9595);
			socket.getOutputStream().write("Hello Server!".getBytes());
			
		//	System.out.println("Client connected to the server");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
