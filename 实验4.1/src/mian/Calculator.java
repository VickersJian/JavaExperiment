package mian;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Calculator {
	private JFrame widget = new JFrame();
	JLabel JL_title=new JLabel("简易计算器");
	JButton add = new JButton("相加");
	JButton sub = new JButton("相减");
	JButton clear = new JButton("全部清零");
	JTextField JTFnum1=new JTextField(20);
	JTextField JTFnum2=new JTextField(20);
	JTextField JTFresult=new JTextField(20);
	JLabel JLnum1=new JLabel("运算数一");
	JLabel JLnum2=new JLabel("运算数二");
	JLabel JLresult=new JLabel("运算结果");
	
	public static void main(String[] args) {
		Calculator calculator=new Calculator(350,310);
	}
	
	public Calculator(int x, int y) {
		widget.setTitle("简易计算器");
		widget.setSize(x,y);
		widget.setLayout(null);
		widget.setVisible(true);
		initView();
		addView();
	}
	
	private void initView() {
		JL_title.setSize(90,20);
		JL_title.setLocation(130,20);
		
		JLnum1.setSize(90,20);
		JLnum1.setLocation(60,50);
		JLnum2.setSize(90,20);
		JLnum2.setLocation(60,100);
		JLresult.setSize(90,20);
		JLresult.setLocation(60,150);
		
		JTFnum1.setSize(130,20);
		JTFnum1.setLocation(140,50);
		JTFnum2.setSize(130,20);
		JTFnum2.setLocation(140,100);
		JTFresult.setSize(130,20);
		JTFresult.setLocation(140,150);
		
		add.setSize(90,20);
		add.setLocation(50,190); 
		sub.setSize(90,20);
		sub.setLocation(175,190); 
		clear.setSize(90,20);
		clear.setLocation(110,220);
	}
	
	private void addView() {
		widget.add(JL_title);
		widget.add(JTFnum1);
		widget.add(JTFnum2);
		widget.add(JTFresult);
		widget.add(JLnum1);
		widget.add(JLnum2);
		widget.add(JLresult);
		widget.add(add);
		widget.add(sub);
		widget.add(clear);
	}
}
