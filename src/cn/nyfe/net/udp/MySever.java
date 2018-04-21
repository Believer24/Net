package cn.nyfe.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.print.attribute.standard.Severity;

/**
 * 服务端
 * 1.创建服务+端口
 * 2.准备接收容器
 * 3.封装成包
 *4.接收数据
 *5.分析数据  
 */
public class MySever {

	public static void main(String[] args) throws IOException {
		//1.创建服务+端口
			DatagramSocket sever=new DatagramSocket(8888);
		// 2.准备接收容器
			byte[] container=new byte[1024];
		//3.封装成 包  DatagramPacket
			DatagramPacket packet=new DatagramPacket(container,container.length);
		//4.接收数据
			sever.receive(packet);
		//5.分析数据 	  
			byte[] data=packet.getData();
			int   len=packet.getLength();
			System.out.println(new String(data,0,len));
		//释放资源
			sever.close();
	}

}
