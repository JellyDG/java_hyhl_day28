package cn.hyhl.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub

		//����ͷȥ�󶨶˿ں�
		DatagramSocket ds = new DatagramSocket(30000);
		//�����ֽ����飬���շ�����������
		byte [] data = new byte[1024];
		
		while(true) {
			
			DatagramPacket dp = new DatagramPacket(data, data.length);
			
			ds.receive(dp);
			
			//��ȡ���Ͷ˵�ip��ַ
			String ip = dp.getAddress().getHostAddress();
			//��ȡ���Ͷ˵����ݳ���
			int length = dp.getLength();
			//��ȡ���Ͷ˵Ķ˿ں�
			int port = dp.getPort();
			
			System.out.println(ip + ":"+new String(data, 0 , length) + ":" +port);
		}
		
		
		//һֱ����������� ���ܹر�����
		//ds.close();
	}

}
