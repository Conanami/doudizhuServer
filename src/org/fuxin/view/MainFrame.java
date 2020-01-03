package org.fuxin.view;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainFrame {
	public MainFrame()
	{
		try {
			//1,创建服务器端socket
			ServerSocket serverSocket=new ServerSocket(8888);
			
			while(true)
			{
				//2,接收客户端的socket
				Socket socket = serverSocket.accept();
				// 3,开启线程，处理客户端的socket
				AcceptThread acceptThread = new AcceptThread(socket);
				acceptThread.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//创建一个接收线程，处理客户端的信息
	class AcceptThread extends Thread
	{
		Socket socket;
		public AcceptThread(Socket socket)
		{
			this.socket=socket;
		}
		
		public void run()
		{
			try {
				DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
				while(true)
				{
					String msg=dataInputStream.readUTF();
					System.out.println(msg+"上线了");
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
