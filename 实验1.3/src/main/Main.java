package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����볤����ĳ�\n");
		float lenth = scanner.nextFloat();
		System.out.println("�����볤����Ŀ�\n");
		float width = scanner.nextFloat();
		System.out.println("�����볤����ĸ�\n");
		float high = scanner.nextFloat();
		Cuboid cuboid=new Cuboid(lenth,width,high);
		System.out.println("�ó���������Ϊ��"+cuboid.calculateVolume());
		scanner.close();
	}
}
