package cn.hyhl.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		ServerSocket server = new ServerSocket(8888);
		//���÷������׽��ֶ����еķ���accept()��ȡ�ͻ����׽��ֶ���
		Socket socket = server.accept();
		//ͨ���ͻ����׽��ֶ���socket��ȡ�ֽ�����������ȡ���ǿͻ��˷���������
		InputStream in = socket.getInputStream();
		byte [] data = new byte[1024];
		int len = in.read(data);
		System.out.println(new String(data,0,len));
		
		//��������ͻ��˷������ݣ��ֽ��������ͨ���ͻ����׽��ֶ����ȡ�ֽ������
		OutputStream out = socket.getOutputStream();
		out.write("������ok".getBytes());
		
		socket.close();
		server.close();
	}

}
