package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ѧ������\n");
		String name = scanner.nextLine();
		System.out.println("������ѧ���ɼ�\n");
		int point = scanner.nextInt();
		if(point>=60) {
			System.out.println(name+"�ĳɼ�Ϊ����");
		}else {
			System.out.println(name+"�ĳɼ�Ϊ������");
		}
		scanner.close();
	}
}
