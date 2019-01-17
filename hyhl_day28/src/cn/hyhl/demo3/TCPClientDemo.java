package cn.hyhl.demo3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClientDemo {

	/**
	 * �ͻ����ϴ�ͼƬ��������
	 * 		ʵ�ֲ��裺
	 * 			1.Socket�׽������ӷ�����
	 * 			2.ͨ��Socket�����ȡ�ֽ��������дͼƬ
	 * 			3.ʹ���ֽڵ������󣬶�ȡͼƬ����Դ��FileInputStream
	 * 			4.��ȡͼƬ��ʹ���ֽ����������ͼƬд��������
	 * 			5.ͨ��Socket�׽��ֻ�ȡ�ֽ�����������ȡ���������������ϴ��ɹ�
	 * 			6.�ر���Դ
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

			Socket socket = new Socket("127.0.0.1", 8888);
			//��ȡ�ֽ��������ͼƬд��������
			OutputStream out = socket.getOutputStream();
			//�����ֽ�����������ȡ�����ϵ�����ԴͼƬ
			FileInputStream fis = new FileInputStream("C:\\Users\\dong\\Desktop\\1.jpg");
			//��ʼ��д�ֽ�����
			int len = 0;
			byte [] bytes = new byte[1024];
			//�ͻ���д��������
			while((len = fis.read(bytes)) != -1) {
				out.write(bytes,0,len);
			}
			
			//��������д��ֹ����
			socket.shutdownOutput();
			
			//��ȡ�ֽ���������󣬶�ȡ���������ϴ��ɹ�
			InputStream in = socket.getInputStream();
			len = in.read(bytes);
			
			System.out.println(new String(bytes,0,len));
			
			fis.close();
			socket.close();
	}

}
