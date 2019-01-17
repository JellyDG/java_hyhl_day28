package cn.hyhl.Demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {

	/**
	 * ʵ�ֲ���:
	 * 		1������DatagramSocket���󣬰󶨶˿ںţ�Ҫ��ͷ��͵Ķ˿ں�һ��
	 * 		2�������ֽ����飬���ܷ���������
	 * 		3���������ݰ�����DatagramSocket
	 * 		4������DatagramSocket���󷽷�
	 * 			receive(DatagramPacket dp)�������ݣ����ݷ������ݰ���
	 * 		5�������
	 * 				����ip��ַ
	 * 				���յ����ֽڸ���
	 * 				���ͷ��Ķ˿ں�
	 * 		6���ر���Դ
	 * 
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		//����DatagramSocket���� �󶨶˿ں�
		DatagramSocket ds = new DatagramSocket(6000);
		//�����ֽ�����
		byte [] data = new byte[1024];
		//�������ݰ����󣬴����ֽ�����
		DatagramPacket dp = new DatagramPacket(data, data.length);
		
		ds.receive(dp);
		
		String ip = dp.getAddress().getHostAddress();
		int length = dp.getLength();
		int port = dp.getPort();
		
		System.out.println(ip + ":"+new String(data, 0 , length) + ":" +port);
		//�ر���Դ
		ds.close();
	}

}
