package cn.bufe.net.tcp.chatroom03;

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
			new Thread(new Send(client) ).start();		//一条路径
			new Thread(new Receive(client) ).start();		//一条路径
	}

}
