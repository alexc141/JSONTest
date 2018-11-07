package org.usfirst.frc.team548.robot;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONTester {
	public static void main(String[]args) throws IOException, ParseException{
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader("constants.json"));
		JSONObject test = (JSONObject) object;
		
		System.out.println(test);
		
		JSONArray JSONArray = (JSONArray) test.get("name");
		/*
		//Print results
		Iterator iterator = JSONArray.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        */
		try {
		         ServerSocket srvr = new ServerSocket(1234);
		         Socket skt = srvr.accept();
		         System.out.print("Server has connected!\n");
		         PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
		         System.out.print("Sending string: '" + JSONArray + "'\n");
		         out.print(JSONArray);
		         out.close();
		         skt.close();
		         srvr.close();
		      }
		      catch(Exception e) {
		         System.out.print("Whoops! It didn't work!\n");
		      }
		
		System.out.println(JSONArray.get(0));
	}
}