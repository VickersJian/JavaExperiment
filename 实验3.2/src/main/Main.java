package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] a = new int[10];
		int i = 0;
		System.out.println("����������");
		try {
			while (i < 10) {
				int temp = input.nextInt();
				if (temp <= 0 || temp >= 100) {
					throw new ErrorInputException("��������ֱ������0С��100");
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
