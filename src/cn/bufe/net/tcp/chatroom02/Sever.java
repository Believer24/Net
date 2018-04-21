package cn.bufe.net.tcp.chatroom02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  创建服务器
 *  写出数据：输出流
 *  读取数据：输入流
 * 
 *
 */
public class Sever {
		public static void main(String[] args) throws IOException {
			ServerSocket sever=new ServerSocket(9999);
			while(true){
					Socket client=sever.accept();
					//写出数据
					DataInputStream dis=new DataInputStream(client.getInputStream());
					DataOutputStream dos=new DataOutputStream(client.getOutputStream());
					while(true){
								String msg=dis.readUTF();
								System.out.println(msg);
								dos.writeUTF("服务器---》"+msg);
								dos.flush();
				}
			}
		}
}
