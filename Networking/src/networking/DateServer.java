package networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
	public static void main(String[] args) {
		try {
		ServerSocket server = new ServerSocket(9090);
		System.out.println("Listening on port 9090");
		
		while (true) {
			Socket client = server.accept();
			System.out.println("Got connection from: " + client.getInetAddress());
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}

class DateRunnable implements Runnable {
	PrintWriter output;
	
	public DateRunnable(Socket client) {
		try {
			output = new PrintWriter(client.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (true) {
			Date d = new Date();
			output.println("The current time is: " + d);
		}
	}
}
