package cn.bufe.net.tcp.chatroom02;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


/**
 * 发送数据
 * @author Administrator
 *
 */
public class Send implements Runnable {
		private BufferedReader console;			//控制台的输入流
		private DataOutputStream dos;				//管道输出流
		private boolean isRunning = true;			//控制线程的标识
		public Send(){
				console=new  BufferedReader(new InputStreamReader(System.in));
		}
	
		public Send(Socket client){
				this();
				try {
					dos=new DataOutputStream(client.getOutputStream());
				} catch (IOException e) {
					isRunning=false;
					CloseUtil.CloseAll(dos,console);
				}
		}
		 //1、从控制台接收数据
		private String getMsgFromConsole(){
			 try {
				return console.readLine();
			} catch (IOException e) {
			
			}
			 	return " ";
		}
		/**
		 *
		 * 2、发送数据
		 */
		public void send(){
				String msg=getMsgFromConsole();
				if(null!=msg&&!msg.equals("")){
						try {
							dos.writeUTF(msg);
							dos.flush();		//强制刷新
						} catch (IOException e) {
							isRunning=false;
							CloseUtil.CloseAll(dos,console);
						}
				}
		}
		@Override
		public void run() {
				//线程体
				while(isRunning){
						send();
				}
			
		}

}	
