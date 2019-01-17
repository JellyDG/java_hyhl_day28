package cn.hyhl.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

	/**
	 * 1.获取服务器的ip和端口号
	 * 2.将数据发送到服务器
	 * 3.从服务器读取数据
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		//创建Socket对象，连接服务器
		Socket socket = new Socket("127.0.0.1",8888);
		
		//通过客户端的套接字对象Socket方法，获取字节输出流，将数据写向服务器
		OutputStream out = socket.getOutputStream();
		out.write("服务器ok吗？".getBytes());
		
		//都回服务器发回的数据，使用Socket套接字对象中的字节输入流
		InputStream in = socket.getInputStream();
		byte [] data= new byte[1024];
		int len = in.read(data);
		
		System.out.println(new String(data,0,len));
		socket.close();
	}

}
