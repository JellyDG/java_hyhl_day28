package cn.hyhl.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSend {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		//��������
		Scanner sc = new Scanner(System.in);
		InetAddress ip =  InetAddress.getByName("127.0.0.1");
		DatagramSocket ds = new DatagramSocket();
		
		while (true) {
			String message = sc.nextLine();
			//Ҫ���͵����ݣ�����һ���ֽ�����
			byte [] data = message.getBytes();
			DatagramPacket dp = new DatagramPacket(data, data.length, ip, 30000);
			ds.send(dp);
		}
		
		//һֱ����������� ���ܹر�����
		//ds.close();
		
			
	}

}
