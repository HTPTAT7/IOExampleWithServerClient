package by.htp.io.run;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

	private static int clientCount;
	
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9595);

			System.out.println("Server started ...");
			
			while (true) {
				Socket client = serverSocket.accept();
				clientCount++;
				System.out.println("Client connected ... " + clientCount);
				
				byte[] data = new byte[1024];
				
				client.getInputStream().read(data);
				System.out.println(new String(data));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			serverSocket.close();
		}
	}

}
