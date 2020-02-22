package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner scanner=new Scanner(System.in);
			System.out.println("请输入文件路径：");
			final String file=scanner.nextLine();
			BufferedReader reader=new BufferedReader(new FileReader(file));
			List<String> data = new ArrayList<String>();//List用于储存所有数据
			String t=reader.readLine();
			while(t!=null) {
				data.add(t);//正则表达式，以空格为分割点分割字符串
				t=reader.readLine();
			}
			reader.close();
			String ch=null;
			System.out.println("1.查看文件内容\n2.每位职工工资增加10%\nq.退出\n");
			while(!(ch = scanner.nextLine()).equals("q")) {
				switch(ch) {
				case"1":{
					for(String a:data) {
						System.out.println(a);
					}
					break;
					}
				case"2":{
					BufferedWriter output=new BufferedWriter(new FileWriter(file));
					for(String a:data) {
						String[] t1=a.split("[\\s]");
						t1[1]=String.valueOf(Double.parseDouble(t1[1])*(1+0.1));
						String temp=t1[0]+" "+t1[1]+" "+t1[2];
						data.set(data.indexOf(a), temp);
						output.write(temp+"\n");
					}
					output.close();
					break;
					}
				}
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
