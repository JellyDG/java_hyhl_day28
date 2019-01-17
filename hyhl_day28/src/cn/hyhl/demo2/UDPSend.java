package cn.hyhl.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSend {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		//键盘输入
		Scanner sc = new Scanner(System.in);
		InetAddress ip =  InetAddress.getByName("127.0.0.1");
		DatagramSocket ds = new DatagramSocket();
		
		while (true) {
			String message = sc.nextLine();
			//要发送的数据，放在一个字节数组
			byte [] data = message.getBytes();
			DatagramPacket dp = new DatagramPacket(data, data.length, ip, 30000);
			ds.send(dp);
		}
		
		//一直处于聊天界面 不能关闭连接
		//ds.close();
		
			
	}

}
