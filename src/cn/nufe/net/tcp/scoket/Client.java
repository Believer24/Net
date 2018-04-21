package cn.nufe.net.tcp.scoket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1.创建客户端，必须指定服务器+端口，此时就在连接
 * 	Socket(String host,int port)
 * 
 * 
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// 1.创建客户端，必须指定服务器+端口，此时就在连接
		 Socket client=new Socket("localhost",8888);
		 //2.接收数据
		/* BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
		 String echo=br.readLine();		//读数据
		 System.out.println(echo);*/
		 DataInputStream dis=new DataInputStream(client.getInputStream());
		 String echo=dis.readUTF();
		 System.out.println(echo);
	}

}
