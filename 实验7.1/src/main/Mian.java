package main;

public class Mian {
	public static void main(String[] args) {
		Thread printName=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<20;i++)
					System.out.println("Ð»Î«¼ü");
			}
			
		});
		Thread printNumber=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<20;i++)
					System.out.println("1800300637");
			}
			
		});
		printNumber.start();
		printName.start();
	}
}
