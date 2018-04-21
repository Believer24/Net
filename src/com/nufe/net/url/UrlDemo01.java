package com.nufe.net.url;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo01 {

	public static void main(String[] args) throws MalformedURLException {
			//绝对路径构建
			URL url=new URL("http://study.163.com/course/courseLearn.htm?courseId=343001#/learn/video?lessonId=1051635894&courseId=343001");
			System.out.println("协议:"+url.getProtocol());
			System.out.println("域名"+url.getHost());
			System.out.println("端口"+url.getPort());
			System.out.println("资源"+url.getFile());
			System.out.println("相对路径:"+url.getPath());
			System.out.println("锚点"+url.getRef());
			System.out.println("参数"+url.getQuery());	//参数，存在锚点返回NUll,不存在返回正确
			
			
			
			
			url=new URL("http://study.163.com/course/");
			url=new URL(url,"b.txt");			//相对路径
			//System.out.println(url.toString());
	}

}
