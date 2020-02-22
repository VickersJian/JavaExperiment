package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clock {
	Time time=new Time();
	JFrame ui = null;
	JLabel labelDisplayTime=null;
	JLabel labelNotice=null;
	Thread refreshDisplayTime=new Thread(new Runnable() {
		@Override
		public void run() {
			while(true) {
				labelDisplayTime.setText(time.getTime());
				
			}
		}
	});
	Thread notice=new Thread(new Runnable() {
		@Override
		public void run() {
			int hour=0;
			while(true) {
				try {
					hour = time.getSecond();
					if(hour>=8 && hour<=9) {
						labelNotice.setText("���Ͽ���");
					}else if((hour>=23 && hour<=24)||(hour>=0&&hour<=8)) {
						labelNotice.setText("����Ϣ��");
					}else {
						labelNotice.setText("");
					}
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});
	public Clock() {
		ui = new JFrame("ʱ��");
		ui.setSize(450, 300);	
		ui.setLayout(null);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ã����¹رհ�ť��������
		labelDisplayTime=new JLabel();
		labelDisplayTime.setSize(400,100);
		labelDisplayTime.setLocation(140,80);
		refreshDisplayTime.start();
		ui.add(labelDisplayTime);
		labelNotice = new JLabel();
		labelNotice.setSize(100,200);
		labelNotice.setLocation(140,80);
		notice.start();
		ui.add(labelNotice);
		ui.setVisible(true);
	}

	private class Time {
		
		public Time() {}

		public String getTime() {
			Calendar now = Calendar.getInstance();
			SimpleDateFormat SDF = new SimpleDateFormat("yyyy'��'MM'��'dd'��'HH:mm:ss");// ��ʽ��ʱ����ʾ��ʽ
			String time = SDF.format(now.getTime()); // �õ���ǰ���ں�ʱ��
			return time;
		}
		public int getHour() {
			Calendar now = Calendar.getInstance();
			return now.get(Calendar.HOUR_OF_DAY);
		}
		public int getSecond() {
			Calendar now = Calendar.getInstance();
			return now.get(Calendar.SECOND);
		}
	}
	
	public static void main(String[] args) {
		Clock clock=new Clock();
	}
}
