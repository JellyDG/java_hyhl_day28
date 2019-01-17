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
	 * TCP图片上传服务器
	 * 	1.ServerSocket套接字对象，监听端口8888
	 * 	2.方法accept()获取客户端的连接对象
	 *  3.客户端连接对象获取字节输入流，读取客户端发送图片
	 *  4.创建File对象，绑定上传文件夹（判断文件夹是否存在，不存在，则创建）
	 *  5.创建字节输出流，数据目的File对象所在文件夹
	 *  6.字节流读取图片，字节流将图片写入到目的文件夹中
	 *  7.将上传成功会写入客户端
	 *  8.关闭资源
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		ServerSocket server = new ServerSocket(8888);
		Socket socket = server.accept();
		//通过客户端连接对象，获取字节输入流，读取客户端图片
		InputStream in = socket.getInputStream();
			
		//图片名字等于 域名+毫秒值+6位随机数
		String photo = "hyhl" + System.currentTimeMillis() + new Random().nextInt(999999);
		//将目的文件夹封装到File对象
		File upload = new File("d:\\upload");
		
		if(!upload.exists()) {
			upload.mkdirs();
		}

		FileOutputStream fos = new FileOutputStream(upload+File.separator + photo);
		byte [] bytes = new byte[1024];
		int len = 0;
		//服务器读取客户端的图片
		while((len = in.read(bytes)) != -1) {
			fos.write(bytes,0,len);
		}
		//服务器返回客户端信息
		socket.getOutputStream().write("上传成功".getBytes());
		
		fos.close();
		socket.close();
		server.close();
	}

}
