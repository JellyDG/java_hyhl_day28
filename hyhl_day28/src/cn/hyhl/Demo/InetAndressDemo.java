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
	 * ��̬������
	 * 		static InetAddress getByName(String hostName) ���������� ��ȡip��ַ
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
	 * ��̬������ 
	 * 		static InetAddress getLocalHost() ��ȡ��������
	 * 
	 * �Ǿ�̬������
	 * 		String getHostAddress() ��ȡ����IP��ַ
	 * 		String getHostName()��ȡ��������
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
