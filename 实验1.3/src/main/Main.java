package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入长方体的长\n");
		float lenth = scanner.nextFloat();
		System.out.println("请输入长方体的宽\n");
		float width = scanner.nextFloat();
		System.out.println("请输入长方体的高\n");
		float high = scanner.nextFloat();
		Cuboid cuboid=new Cuboid(lenth,width,high);
		System.out.println("该长方体的体积为："+cuboid.calculateVolume());
		scanner.close();
	}
}
