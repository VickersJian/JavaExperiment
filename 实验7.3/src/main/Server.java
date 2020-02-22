package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import javax.swing.*;

public class Server {
	private JFrame ui = null;
	private JTextField jtfPort = null;
	private JButton btnSstartServer = null;
	private JLabel labPort = null;
	private ServerSocket server = null;

	public Server() {
		ui = new JFrame("服务器");
		jtfPort = new JTextField();
		ui.setSize(300, 100);
		ui.setLayout(null);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jtfPort.setBounds(50, 20, 50, 25);
		ui.add(jtfPort);
		btnSstartServer = new JButton();
		btnSstartServer.setBounds(120, 20, 100, 25);
		btnSstartServer.setText("启动服务");
		btnSstartServer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (server == null) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							start();
						}
					}).start();
				}
			}

		});
		ui.add(btnSstartServer);
		labPort = new JLabel();
		labPort.setBounds(10, 20, 100, 25);
		labPort.setText("端口");
		ui.add(labPort);
		
		jtfPort.setText("2288");
		
		ui.setVisible(true);
	}

	private void start() {
		try {
			server = new ServerSocket(Integer.parseInt(jtfPort.getText())); // servereSocket表示服务器
			System.out.println("等待客户端连接..."+server);
			Socket client1 = server.accept();// 客户端1
			System.out.println("客户端连接端口号：" + client1.getPort());
			Socket client2 = server.accept();// 客户端1
			System.out.println("客户端连接端口号：" + client2.getPort());
			
			new Thread(new ExecuteClient(client1.getRemoteSocketAddress().toString(),client1, client2)).start();
			new Thread(new ExecuteClient(client2.getRemoteSocketAddress().toString(),client2, client1)).start();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}
	}

	private class ExecuteClient implements Runnable {
		private final String name;
		private final Socket client; // 客户
		private final Socket client2;

		public ExecuteClient(String name,Socket client, Socket client2) {
			this.name=name;
			this.client = client;
			this.client2 = client2;
		}

		// 实现run方法
		public void run() {
			try {
				InputStream clientInput = client.getInputStream(); // 从客户端读取数据
				Scanner scanner = new Scanner(clientInput);
				while (true) {
					String line = scanner.nextLine();
					if (line.startsWith("end")) { // 结束聊天
						this.quit();
						break;
					}
					sendMessage(client2, name+": "+line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void quit() {
			sendMessage(client2, "end");
		}
		
		private void sendMessage(Socket client, String message) {
			try {
				OutputStream clientOutput = client.getOutputStream();
				OutputStreamWriter writer = new OutputStreamWriter(clientOutput);
				writer.write(message + "\n");
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
