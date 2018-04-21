package cn.bufe.net.tcp.chatroom03;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import cn.nyfe.net.udp.MyClient;

/**
 *  创建服务器
 *  写出数据：输出流
 *  读取数据：输入流
 * 
 *
 */
public class Sever {
		private List<MyChannel> all=new ArrayList<MyChannel>();
		public static void main(String[] args) throws IOException {
			new Sever().start();
		}
		public void start() throws IOException{
				ServerSocket sever=new ServerSocket(9999);
				while(true){
						Socket client=sever.accept();
						MyChannel  channel=new MyChannel(client);
						all.add(channel);
						new Thread(channel).start();		//一条道路
			}
		}	
		

		
		
		/**
		 * 一个客户端一条道路
		 * 1、输入流
		 * 2、输出流
		 * 3、接收数据
		 * 4、发送数据
		 *
		 */
		 private class  MyChannel implements Runnable{
					private DataInputStream dis;
					private DataOutputStream dos;
					private boolean isRunning=true;
					public MyChannel(Socket client){
							try {
								dis=new DataInputStream(client.getInputStream());
								dos=new DataOutputStream(client.getOutputStream());
							} catch (IOException e) {
								CloseUtil.CloseAll(dis,dos);
								isRunning=false;
							}
					}
					/**
					 * 读取数据
					 * @return
					 */
					private  String receive(){
						String msg="";
							try {
								msg=dis.readUTF();
							} catch (IOException e) {
								CloseUtil.CloseAll(dis);
								isRunning=false;
								
							}
							return  msg;
					}
					/**
					 * 发送数据
					 */
					private void send(String msg){
						if(null==msg||msg.equals("")){
							return  ;
						}
						try {
							dos.writeUTF(msg);
							dos.flush();
						} catch (IOException e) {
							CloseUtil.CloseAll(dos);
							isRunning=false;
					}
					}
					private void sendOthers(){
							String  msg=receive();
							//遍历容器
							for(MyChannel other:all){
								if(other==this){
									 continue;
								}
								//发送给其他客户端
								 other.send(msg);
							}
							
							
					}
					@Override 
					public void run() {
						while(isRunning){
								send(receive());
						}
						
					}
					
				}
		
		}


