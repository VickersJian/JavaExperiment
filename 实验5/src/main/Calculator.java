package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField = new JTextField();
	private StringBuilder displayString = new StringBuilder();
	
	public static void main(String[] args) {
		Calculator frame = new Calculator();
		frame.setVisible(true);
		frame.requestFocus();
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JButton button_1 = new JButton("1");
		button_1.setBounds(24, 86, 51, 32);
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayString.append("1");
				textField.setText(displayString.toString());
			}
		});
		contentPane.add(button_1);

		JButton button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayString.append("2");
				textField.setText(displayString.toString());
			}
		});
		button_2.setBounds(87, 86, 51, 32);
		contentPane.add(button_2);

		JButton button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayString.append("3");
				textField.setText(displayString.toString());
			}
		});
		button_3.setBounds(148, 86, 51, 32);
		contentPane.add(button_3);

		JButton button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayString.append("4");
				textField.setText(displayString.toString());
			}
		});
		button_4.setBounds(24, 130, 51, 32);
		contentPane.add(button_4);

		JButton button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayString.append("5");
				textField.setText(displayString.toString());
			}
		});
		button_5.setBounds(87, 130, 51, 32);
		contentPane.add(button_5);

		JButton button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayString.append("6");
				textField.setText(displayString.toString());
			}
		});
		button_6.setBounds(147, 130, 51, 32);
		contentPane.add(button_6);

		JButton button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayString.append("7");
				textField.setText(displayString.toString());
			}
		});
		button_7.setBounds(24, 176, 51, 32);
		contentPane.add(button_7);

		JButton button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayString.append("8");
				textField.setText(displayString.toString());
			}
		});
		button_8.setBounds(87, 176, 51, 32);
		contentPane.add(button_8);

		JButton button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayString.append("9");
				textField.setText(displayString.toString());
			}
		});
		button_9.setBounds(148, 176, 51, 32);
		contentPane.add(button_9);
		
		JButton button_0 = new JButton("0");
		button_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayString.append("0");
				textField.setText(displayString.toString());
			}
		});
		button_0.setBounds(24, 221, 114, 32);
		contentPane.add(button_0);

		JButton button_div = new JButton("/");
		button_div.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(check()) {
					displayString.append("/");
					textField.setText(displayString.toString());
				}
			}
		});
		button_div.setBounds(209, 86, 51, 32);
		contentPane.add(button_div);

		JButton button_mul = new JButton("*");
		button_mul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(check()) {
					displayString.append("*");
					textField.setText(displayString.toString());
				}
			}
		});
		button_mul.setBounds(208, 130, 51, 32);
		contentPane.add(button_mul);

		JButton button_sub = new JButton("-");
		button_sub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(check()) {
					displayString.append("-");
					textField.setText(displayString.toString());
				}
			}
		});
		button_sub.setBounds(209, 176, 51, 32);
		contentPane.add(button_sub);

		JButton button_point = new JButton(".");
		button_point.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(displayString.length()!=0) {
					int i=displayString.length()-1;
					char lastCharactor=displayString.charAt(i);
					while(i>=0) {
						lastCharactor=displayString.charAt(i);
						if(lastCharactor=='+'||lastCharactor=='-'||lastCharactor=='*'||lastCharactor=='/'||lastCharactor=='.')
							break;
						i--;
					}
					if(lastCharactor=='.') {
						JOptionPane.showMessageDialog(null, "一个数只能由一个小数点");
						return;
					}
					displayString.append(".");
					textField.setText(displayString.toString());
				}
			}
		});
		button_point.setBounds(147, 221, 51, 32);
		contentPane.add(button_point);

		JButton button_sum = new JButton("+");
		button_sum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(check()) {
					displayString.append("+");
					textField.setText(displayString.toString());
				}
			}
		});
		button_sum.setBounds(208, 221, 51, 32);
		contentPane.add(button_sum);

		JButton button_leftParenthesis = new JButton("(");
		button_leftParenthesis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayString.append("(");
				textField.setText(displayString.toString());
			}
		});
		button_leftParenthesis.setBounds(271, 86, 51, 32);
		contentPane.add(button_leftParenthesis);
		
		JButton button_rightParenthesis = new JButton(")");
		button_rightParenthesis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayString.append(")");
				textField.setText(displayString.toString());
			}
		});
		button_rightParenthesis.setBounds(271, 130, 51, 32);
		contentPane.add(button_rightParenthesis);

		JButton button_C = new JButton("C");
		button_C.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayString.delete(0,displayString.length());
				textField.setText(displayString.toString());
			}
		});
		button_C.setBounds(270, 176, 51, 32);
		contentPane.add(button_C);

		JButton button_equal = new JButton("=");
		button_equal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double result=solve(displayString.toString().toCharArray());
				displayString.delete(0,displayString.length());
				displayString.append(String.valueOf(result));
				textField.setText(displayString.toString());
			}
		});
		button_equal.setBounds(271, 221, 51, 32);
		contentPane.add(button_equal);

		textField = new JTextField();
		textField.setBounds(24, 10, 298, 66);
		
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setFont(new Font("楷体", Font.BOLD, 20));

		this.addKeyListener(new KeyAdapter() {//键盘绑定按钮
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyChar()) {
				case '1': {
					button_1.doClick();
					break;
				}
				case '2': {
					button_2.doClick();
					break;
				}
				case '3': {
					button_3.doClick();
					break;
				}
				case '4': {
					button_4.doClick();
					break;
				}
				case '5': {
					button_5.doClick();
					break;
				}
				case '6': {
					button_6.doClick();
					break;
				}
				case '7': {
					button_7.doClick();
					break;
				}
				case '8': {
					button_8.doClick();
					break;
				}
				case '9': {
					button_9.doClick();
					break;
				}
				case '0': {
					button_0.doClick();
					break;
				}
				case '+':{
					button_sum.doClick();
					break;
				}
				case '-':{
					button_sub.doClick();
					break;
				}
				case '*':{
					button_mul.doClick();
					break;
				}
				case '/':{
					button_div.doClick();
					break;
				}
				case '(':{
					button_leftParenthesis.doClick();
					break;
				}
				case ')':{
					button_rightParenthesis.doClick();
					break;
				}
				}

			}
		});
	}

	private boolean check() {
		if(displayString.length()==0)
			return false;
		char lastChar=displayString.charAt(displayString.length()-1);
		if(lastChar=='-'||lastChar=='+'||lastChar=='*'||lastChar=='/')
			return false;
		return true;
	}
	
	private static Double solve(char[] s) {
		Stack<Character> stack = new Stack<Character>();
		Queue<String> queue = new LinkedList<String>();
		for(int i = 0; i < s.length;){
			if(s[i] == ' ') {
				i++;
				continue;
			}
			else if(s[i] >= '0' && s[i] <= '9'){
				double sum = 0;
				StringBuilder a=new StringBuilder();
				while(i < s.length && (s[i] >= '0' && s[i] <= '9'||s[i]=='.')){
					a.append(s[i]);
					i++;
				}
				queue.add(a.toString());
			}else if(s[i] == ')'){
				while(!stack.isEmpty() && stack.peek() != '('){
					queue.add(stack.pop() + "");
				}
				stack.pop();
				i++;
			}else{
				while(!stack.isEmpty() && compare(stack.peek(), s[i]) < 0){
					queue.add(stack.pop() + "");
				}
				stack.add(s[i]);
				i++;
			}
		}
		while(!stack.isEmpty()){
			queue.add(stack.pop() + "");
		}
		//必须要使用.equals方法才正确使用 == 不正确
		Stack<Double> res = new Stack<Double>();
		while(!queue.isEmpty()){
			String t = queue.poll();
			if(t.equals("+")  || t.equals("-") || t.equals("*") || t.equals("/")){
				double a = res.pop();
				double b = res.pop();
				double result = cal(b, a, t);
				res.push(result);
			}else{
				res.add(Double.parseDouble(t));
			}
		}
		return res.pop();
	}
 
	private static double cal(double a, double b, String t) {
		//计算
		if(t.equals("+")){
			return a + b;
		}else if(t.equals("-")){
			return a - b;
		}else if(t.equals("*")){
			return a * b;
		}else{
			return a / b;
		}
	}
 
	private static int compare(char peek, char c) {
		if(peek == '(' || c == '(') return 1;
		if(c == '+' || c == '-') return -1;
		if(c == '*' && (peek == '*' || peek == '/'))return -1;
		if(c == '/' && (peek == '*' || peek == '/'))return -1;
		return 1;
	}

}
