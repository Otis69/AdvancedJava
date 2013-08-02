package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
	private PrintWriter output;
	private BufferedReader input;

	public ChatClient(String ip) {
		try {
			Socket sock = new Socket(ip, 9090);
			input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			output = new PrintWriter(sock.getOutputStream(), true);
		} catch (UnknownHostException e) {
			System.out.println("No host with that IP found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Got an eye-yo exception.");
			e.printStackTrace();
		}
	}
	
	public void send(String message) {
		output.println(message);
	}
	
	public String receive() {
		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}
}
