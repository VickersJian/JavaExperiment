package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import javax.swing.*;

public class Client {
	private StringBuilder allMessages = null;
	private JFrame ui = null;
	private JTextField jtfIPAddress = null;
	private JTextField jtfPort = null;
	private JTextArea jtaAllMessage = null;
	private JTextArea jtaEditMessage = null;
	private JButton btnSend = null;
	private JButton btnConnect = null;
	private JLabel labPort = null;
	private JLabel labIPAddress = null;
	private Socket socket = null;
	private final String name;

	public Client(String name) {
		this.name = name;
		allMessages = new StringBuilder();
		ui = new JFrame(name);
		ui.setSize(500, 450);

		ui.setLayout(null);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		labIPAddress = new JLabel();
		labIPAddress.setBounds(10, 20, 100, 25);
		labIPAddress.setText("服务器地址");
		ui.add(labIPAddress);

		jtfIPAddress = new JTextField();
		jtfIPAddress.setBounds(75, 20, 100, 25);
		ui.add(jtfIPAddress);

		labPort = new JLabel();
		labPort.setBounds(200, 20, 100, 25);
		labPort.setText("端口");
		ui.add(labPort);

		jtfPort = new JTextField();
		jtfPort.setBounds(230, 20, 50, 25);
		ui.add(jtfPort);

		btnConnect = new JButton();
		btnConnect.setBounds(340, 20, 70, 25);
		btnConnect.setText("连接");
		btnConnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							socket = new Socket(jtfIPAddress.getText().toString(),
									Integer.parseInt(jtfPort.getText().toString()));
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
							e1.printStackTrace();
						} finally {
							new Thread(new Runnable() {// 接受消息的线程

								@Override
								public void run() {

									try {
										BufferedReader in = new BufferedReader(
												new InputStreamReader(socket.getInputStream()));
										while (true) {
											String str = in.readLine();
											if (str != null) {
												allMessages.append(str + "\n");
												jtaAllMessage.setText(allMessages.toString());
											}
										}
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								}

							}).start();
						}
					}
				}).start();

			}
		});
		ui.add(btnConnect);

		jtaAllMessage = new JTextArea();
		jtaAllMessage.setBounds(10, 60, 470, 180);
		jtaAllMessage.setEditable(false);
		ui.add(jtaAllMessage);

		jtaEditMessage = new JTextArea();
		jtaEditMessage.setBounds(10, 260, 470, 100);
		ui.add(jtaEditMessage);

		btnSend = new JButton();
		btnSend.setBounds(400, 375, 70, 25);
		btnSend.setText("发送");
		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (socket != null && !socket.isClosed()) {
					PrintWriter out;
					try {
						out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
								true);
						out.println(jtaEditMessage.getText().toString()); // 向服务器端发送一串数据
						allMessages.append("自己：" + jtaEditMessage.getText().toString() + "\n");
						jtaAllMessage.setText(allMessages.toString());
						jtaEditMessage.setText("");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "请先连接到服务器");
				}
			}

		});
		ui.add(btnSend);
		jtfIPAddress.setText("127.0.0.1");
		jtfPort.setText("2288");
		ui.setVisible(true);

	}

}
