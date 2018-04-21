package cn.bufe.net.tcp.chatroom;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 输入流和输出流在同一个线程内
 * 应该独立出来，彼此独立
 * 
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
			Socket client=new Socket("localhost", 9999);
			//控制台的输入流
			BufferedReader console =new  BufferedReader(new InputStreamReader(System.in));
			while(true){
						String  Info=console.readLine();
						//输入流	
						DataOutputStream dos=new DataOutputStream(client.getOutputStream());
						dos.writeUTF(Info);
						dos.flush();
						//输入流
						DataInputStream dis=new DataInputStream(client.getInputStream());
						String msg=dis.readUTF();
						System.out.println(msg);	
			}
	}

}
