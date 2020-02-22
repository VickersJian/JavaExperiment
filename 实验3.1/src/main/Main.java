package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] a = new int[10];
		int i = 0;
		while (i<100) {
			a[i] = input.nextInt();
			i++;
		}
		input.close();
	}
}
