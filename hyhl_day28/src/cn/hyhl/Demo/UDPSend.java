package cn.hyhl.Demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPSend {

	/**
	 * ʵ�ֲ��裺
	 * 		1������DatagramPacket���󣬷�װ���ݣ����յ�ַ�Ͷ˿�
	 * 		  DatagramPacket(byte[] buf, int offset, int length, SocketAddress address) 
	 * 		2������DatagramSocket����
	 * 		3������DatagramSocket�෽�� send���������ݰ�
	 * 		4���ر���Դ
	 * @throws UnknownHostException 
	 */
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//�������ݰ����󣬷�װҪ���͵����ݣ����ն˵�ip��ַ�Ͷ˿ں�
		byte[] data = "����UDP".getBytes();
		//����InetAddress���󣬷�װ�Լ���IP��ַ()
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		DatagramPacket dp = new DatagramPacket(data, data.length, inet, 6000);
		//����DatagramSocket����,���ݰ��ķ��ͺͽ��ܶ���
		DatagramSocket ds = new DatagramSocket();
		ds.send(dp);
		ds.close();
		
	}

}
