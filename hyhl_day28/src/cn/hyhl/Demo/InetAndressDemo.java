package cn.hyhl.Demo;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAndressDemo {

	public static void main(String[] args) throws UnknownHostException{
		// TODO Auto-generated method stub

		//function();
		function_1();
	}

	/**
	 * 静态方法：
	 * 		static InetAddress getByName(String hostName) 传递主机名 获取ip地址
	 * 
	 */
	private static void function_1() throws UnknownHostException{
		// TODO Auto-generated method stub
		InetAddress inet = InetAddress.getByName("ZNJIDS5Q20YVC0Q");
		//System.out.println(inet);
		String ip = inet.getHostAddress();
		System.out.println(ip);
	}

	/*
	 * 静态方法： 
	 * 		static InetAddress getLocalHost() 获取本地主机
	 * 
	 * 非静态方法：
	 * 		String getHostAddress() 获取主机IP地址
	 * 		String getHostName()获取主机名称
	 */
	private static void function() throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress inet = InetAddress.getLocalHost();
		System.out.println(inet);
		String ip = inet.getHostAddress();
		String host = inet.getHostName();
		System.out.println(ip+"\t"+host);
	}

}
