package com.example.b.e.m;

import java.net.*;
import java.io.*;

public class Client extends Thread{

	private PrintWriter s_out; 
	private Socket socket;
	private String serverIp = "192.168.1.107";
	private static final int PORT = 1238;
	
	public void Connect() throws IOException {
		 InetAddress serverAddr = InetAddress.getByName(serverIp);
         socket = new Socket(serverAddr, PORT);
	}
	public void SendMsg(String msg) throws IOException {
		s_out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
		s_out.print(msg);
		s_out.flush();
		
	}
}