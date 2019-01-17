package cn.hyhl.Demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPSend {

	/**
	 * 实现步骤：
	 * 		1、创建DatagramPacket对象，封装数据，接收地址和端口
	 * 		  DatagramPacket(byte[] buf, int offset, int length, SocketAddress address) 
	 * 		2、创建DatagramSocket对象
	 * 		3、调用DatagramSocket类方法 send，发送数据包
	 * 		4、关闭资源
	 * @throws UnknownHostException 
	 */
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//创建数据包对象，封装要发送的数据，接收端的ip地址和端口号
		byte[] data = "您好UDP".getBytes();
		//创建InetAddress对象，封装自己的IP地址()
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		DatagramPacket dp = new DatagramPacket(data, data.length, inet, 6000);
		//创建DatagramSocket对象,数据包的发送和接受对象
		DatagramSocket ds = new DatagramSocket();
		ds.send(dp);
		ds.close();
		
	}

}
