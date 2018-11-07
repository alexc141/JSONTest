package org.usfirst.frc.team548.robot;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class JSONReceiver {
	public static void main(String[]args){
		
		//Test receiver for JSONTester
	      try {
	          Socket skt = new Socket("localhost", 1234);
	          BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	          System.out.print("Received string: '");

	          while (!in.ready()) {}
	          System.out.println(in.readLine()); // Read one line and output it

	          System.out.print("'\n");
	          in.close();
	       }
	       catch(Exception e) {
	          System.out.print("Whoops! It didn't work!\n");
	       }
	}
}
