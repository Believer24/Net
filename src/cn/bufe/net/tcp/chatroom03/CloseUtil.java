package cn.bufe.net.tcp.chatroom03;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭流的方法
 * @author Administrator
 *
 */
public class CloseUtil {
				public static void CloseAll(Closeable...io) {
						for(Closeable temp:io){
							if(null!=temp){
								try {
									temp.close();
								} catch (IOException e) {
								
									
								}
							}
						}
				}
}
