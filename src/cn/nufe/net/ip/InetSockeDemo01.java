package cn.nufe.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 *封装端口：在InetAdress基础上+端口
 * 
 *
 */
public class InetSockeDemo01 {

	public static void main(String[] args) throws UnknownHostException {
			InetSocketAddress adress=new InetSocketAddress("127.0.0.1",9999);
			adress=new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 9999);
			System.out.println(adress.getHostName());
			System.out.println(adress.getPort());
			InetAddress addr=adress.getAddress();
			System.out.println(addr.getHostAddress());			//返回：地址
			System.out.println(addr.getHostName());				//输出计算机名
	}

}
