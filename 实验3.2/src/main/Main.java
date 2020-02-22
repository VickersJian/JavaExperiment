package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] a = new int[10];
		int i = 0;
		System.out.println("请输入数字");
		try {
			while (i < 10) {
				int temp = input.nextInt();
				if (temp <= 0 || temp >= 100) {
					throw new ErrorInputException("输入的数字必须大于0小于100");
				}
				a[i] = temp;
				i++;
			}
		} catch (ErrorInputException e) {
			System.out.println(e.getMessage());
		}
		input.close();
	}
}
