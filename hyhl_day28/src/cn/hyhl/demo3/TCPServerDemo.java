package cn.hyhl.demo3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServerDemo {

	/**
	 * TCPͼƬ�ϴ�������
	 * 	1.ServerSocket�׽��ֶ��󣬼����˿�8888
	 * 	2.����accept()��ȡ�ͻ��˵����Ӷ���
	 *  3.�ͻ������Ӷ����ȡ�ֽ�����������ȡ�ͻ��˷���ͼƬ
	 *  4.����File���󣬰��ϴ��ļ��У��ж��ļ����Ƿ���ڣ������ڣ��򴴽���
	 *  5.�����ֽ������������Ŀ��File���������ļ���
	 *  6.�ֽ�����ȡͼƬ���ֽ�����ͼƬд�뵽Ŀ���ļ�����
	 *  7.���ϴ��ɹ���д��ͻ���
	 *  8.�ر���Դ
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		ServerSocket server = new ServerSocket(8888);
		Socket socket = server.accept();
		//ͨ���ͻ������Ӷ��󣬻�ȡ�ֽ�����������ȡ�ͻ���ͼƬ
		InputStream in = socket.getInputStream();
			
		//ͼƬ���ֵ��� ����+����ֵ+6λ�����
		String photo = "hyhl" + System.currentTimeMillis() + new Random().nextInt(999999);
		//��Ŀ���ļ��з�װ��File����
		File upload = new File("d:\\upload");
		
		if(!upload.exists()) {
			upload.mkdirs();
		}

		FileOutputStream fos = new FileOutputStream(upload+File.separator + photo);
		byte [] bytes = new byte[1024];
		int len = 0;
		//��������ȡ�ͻ��˵�ͼƬ
		while((len = in.read(bytes)) != -1) {
			fos.write(bytes,0,len);
		}
		//���������ؿͻ�����Ϣ
		socket.getOutputStream().write("�ϴ��ɹ�".getBytes());
		
		fos.close();
		socket.close();
		server.close();
	}

}
