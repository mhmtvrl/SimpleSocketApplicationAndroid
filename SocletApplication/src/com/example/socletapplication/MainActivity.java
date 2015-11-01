package com.example.socletapplication;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	//Component references
	Button send;
	EditText text, text2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Binding XML components to references
		send = (Button) findViewById(R.id.bSend);
		text = (EditText) findViewById(R.id.tvDisplay);
		text2 = (EditText) findViewById(R.id.tvDisplay1);
		
		
		//Button function
		send.setOnClickListener(new View.OnClickListener() {	
			
			public void onClick(View v) {
				String serverName = text.getText().toString();			//taking server adress from text field
				int port = 13;											//port number
				Socket client;
				try {
					client = new Socket(serverName, port);				//new port
					Scanner scanner = new Scanner(client.getInputStream());		//Scanner object to read Input stream
					Vector<String> vector = new Vector<String>();			//Container for server response
					while(scanner.hasNextLine())		//Controls whether scanner has object or not
					{
						String received = scanner.nextLine();	//takes line
						vector.add(received);			//add to string line to container						
					}
					text2.setText(vector.get(1).substring(6, 23));			//insert time to other text field
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
		});
	}
	
}


