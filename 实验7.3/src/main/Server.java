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
		ui = new JFrame("������");
		jtfPort = new JTextField();
		ui.setSize(300, 100);
		ui.setLayout(null);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jtfPort.setBounds(50, 20, 50, 25);
		ui.add(jtfPort);
		btnSstartServer = new JButton();
		btnSstartServer.setBounds(120, 20, 100, 25);
		btnSstartServer.setText("��������");
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
		labPort.setText("�˿�");
		ui.add(labPort);
		
		jtfPort.setText("2288");
		
		ui.setVisible(true);
	}

	private void start() {
		try {
			server = new ServerSocket(Integer.parseInt(jtfPort.getText())); // servereSocket��ʾ������
			System.out.println("�ȴ��ͻ�������..."+server);
			Socket client1 = server.accept();// �ͻ���1
			System.out.println("�ͻ������Ӷ˿ںţ�" + client1.getPort());
			Socket client2 = server.accept();// �ͻ���1
			System.out.println("�ͻ������Ӷ˿ںţ�" + client2.getPort());
			
			new Thread(new ExecuteClient(client1.getRemoteSocketAddress().toString(),client1, client2)).start();
			new Thread(new ExecuteClient(client2.getRemoteSocketAddress().toString(),client2, client1)).start();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}
	}

	private class ExecuteClient implements Runnable {
		private final String name;
		private final Socket client; // �ͻ�
		private final Socket client2;

		public ExecuteClient(String name,Socket client, Socket client2) {
			this.name=name;
			this.client = client;
			this.client2 = client2;
		}

		// ʵ��run����
		public void run() {
			try {
				InputStream clientInput = client.getInputStream(); // �ӿͻ��˶�ȡ����
				Scanner scanner = new Scanner(clientInput);
				while (true) {
					String line = scanner.nextLine();
					if (line.startsWith("end")) { // ��������
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
