package org.fuxin.view;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainFrame {
	public MainFrame()
	{
		try {
			//1,������������socket
			ServerSocket serverSocket=new ServerSocket(8888);
			
			while(true)
			{
				//2,���տͻ��˵�socket
				Socket socket = serverSocket.accept();
				// 3,�����̣߳�����ͻ��˵�socket
				AcceptThread acceptThread = new AcceptThread(socket);
				acceptThread.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����һ�������̣߳�����ͻ��˵���Ϣ
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
					System.out.println(msg+"������");
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
