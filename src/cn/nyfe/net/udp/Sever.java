package cn.nyfe.net.udp;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
/**
 * 服务端
 * 1.创建服务+端口
 * 2.准备接收容器
 * 3.封装成包
 *4.接收数据
 *5.分析数据 字节数--->double 
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Sever {
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
			double data=convert(packet.getData());
			System.out.println(data);
		//释放资源
			sever.close();
	}
	/**
	 * 字节数组+Data输入流
	 * @param data
	 * @return
	 * @throws IOException 
	 */
	public static 	double convert(byte[] data) throws IOException{
			DataInputStream dis=new DataInputStream(new ByteArrayInputStream(data));
			double  num=dis.readDouble();
			dis.close();
			return 0;
	}
}
