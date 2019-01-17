package cn.hyhl.Demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {

	/**
	 * 实现步骤:
	 * 		1、创建DatagramSocket对象，绑定端口号，要求和发送的端口号一致
	 * 		2、创建字节数组，接受发来的数据
	 * 		3、创建数据包对象DatagramSocket
	 * 		4、调用DatagramSocket对象方法
	 * 			receive(DatagramPacket dp)接受数据，数据放在数据包中
	 * 		5、拆包：
	 * 				发送ip地址
	 * 				接收到的字节个数
	 * 				发送方的端口号
	 * 		6、关闭资源
	 * 
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		//创建DatagramSocket对象 绑定端口号
		DatagramSocket ds = new DatagramSocket(6000);
		//创建字节数组
		byte [] data = new byte[1024];
		//创建数据包对象，传递字节数组
		DatagramPacket dp = new DatagramPacket(data, data.length);
		
		ds.receive(dp);
		
		String ip = dp.getAddress().getHostAddress();
		int length = dp.getLength();
		int port = dp.getPort();
		
		System.out.println(ip + ":"+new String(data, 0 , length) + ":" +port);
		//关闭资源
		ds.close();
	}

}
