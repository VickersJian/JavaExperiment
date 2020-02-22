package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入学生姓名\n");
		String name = scanner.nextLine();
		System.out.println("请输入学生成绩\n");
		int point = scanner.nextInt();
		if(point>=60) {
			System.out.println(name+"的成绩为及格");
		}else {
			System.out.println(name+"的成绩为不及格");
		}
		scanner.close();
	}
}
