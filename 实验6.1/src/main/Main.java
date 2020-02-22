package main;

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String fileOriginal=scanner.nextLine();
		String fileDestination=scanner.nextLine();
		copyFile(new File(fileOriginal),new File(fileDestination));
		scanner.close();
	}
	private static void copyFile(File file1, File file2) {
		BufferedInputStream bufferIn=null;//���建����
		BufferedOutputStream bufferOut=null;

		try {
			bufferIn = new BufferedInputStream(new FileInputStream(file1));
			bufferOut = new BufferedOutputStream(new FileOutputStream(file2));
			byte[] buf=new byte[1024*512];
			int len=0;
			long start = System.currentTimeMillis();
			System.out.println("���ڸ���...");
			while((len=bufferIn.read(buf))!=-1) {
				bufferOut.write(buf,0,len);
			}
			long end = System.currentTimeMillis();
			System.out.println("�������");
			System.out.println("����ʱ��Ϊ:"+(end - start)+" ����");
			bufferOut.close();
			bufferIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//D:\Download\test.mp4
		//C:\Users\Vickers Jian\Desktop\test.mp4
		//����ӣ_��Դ����_4K
	}
}

