package cn.hyhl.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub

		//用码头去绑定端口号
		DatagramSocket ds = new DatagramSocket(30000);
		//创建字节数组，接收发送来的数据
		byte [] data = new byte[1024];
		
		while(true) {
			
			DatagramPacket dp = new DatagramPacket(data, data.length);
			
			ds.receive(dp);
			
			//获取发送端的ip地址
			String ip = dp.getAddress().getHostAddress();
			//获取发送端的数据长度
			int length = dp.getLength();
			//获取发送端的端口号
			int port = dp.getPort();
			
			System.out.println(ip + ":"+new String(data, 0 , length) + ":" +port);
		}
		
		
		//一直处于聊天界面 不能关闭连接
		//ds.close();
	}

}
