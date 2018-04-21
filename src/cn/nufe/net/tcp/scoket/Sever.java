package cn.nufe.net.tcp.scoket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**必须先启动服务器，后连接
 * 1.创建服务器 指定端口
 * 2.接收客户端的连接 阻塞式的
 * @author Administrator
 *
 */
public class Sever {

	public static void main(String[] args) throws IOException {
		ServerSocket sever=new ServerSocket(8888);
		Socket	scoket=sever.accept();
		System.out.println("一个客户端建立连接");
		//发送数据
		String msg="欢迎使用";
	/*	//输出流
		BufferedWriter bw=new BufferedWriter(
					new OutputStreamWriter(
					scoket.getOutputStream()));
		bw.write(msg);
		bw.newLine();
		bw.flush();*/
		
		DataOutputStream dos=new DataOutputStream(scoket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		
		
	}
 
}
