package cn.hyhl.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

	/**
	 * 1.��ȡ��������ip�Ͷ˿ں�
	 * 2.�����ݷ��͵�������
	 * 3.�ӷ�������ȡ����
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		//����Socket�������ӷ�����
		Socket socket = new Socket("127.0.0.1",8888);
		
		//ͨ���ͻ��˵��׽��ֶ���Socket��������ȡ�ֽ��������������д�������
		OutputStream out = socket.getOutputStream();
		out.write("������ok��".getBytes());
		
		//���ط��������ص����ݣ�ʹ��Socket�׽��ֶ����е��ֽ�������
		InputStream in = socket.getInputStream();
		byte [] data= new byte[1024];
		int len = in.read(data);
		
		System.out.println(new String(data,0,len));
		socket.close();
	}

}
