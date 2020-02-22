package main;

import java.util.Scanner;

public class Main {
	static MailList mailList = new MailList(10);

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			mailList.initMenber(
					new Menber("友人" + (i + 1), (i % 2 == 0 ? "男" : "女"), ("100" + i), ("华强路" + (i + 1) + "号")), i);
		}
		System.out.println("请输入操作序号：\n1.查询\n2.添加\n3.修改\n4.删除\n5.退出\n");
		Scanner scanner = new Scanner(System.in);
		String flag = scanner.next();
		while (true) {
			switch (flag) {
			case "1": {
				search();
				break;
			}
			case "2": {
				add();
				break;
			}
			case "3": {
				change();
				break;
			}
			case "4": {
				delete();
				break;
			}
			}
			flag=scanner.next();
			if (flag.equals("5"))
				break;
		}
		scanner.close();

	}

	public static void add() {
		// 添加
		Menber menber = new Menber();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入成员姓名");
		menber.name = scanner.next();
		System.out.println("请输入成员性别");
		menber.sex = scanner.next();
		System.out.println("请输入成员电话号码");
		menber.phoneNum = scanner.next();
		System.out.println("请输入成员通信地址");
		menber.address = scanner.next();
		mailList.addMenber(menber);
		mailList.showMenbers(mailList.menbers);
		
	}

	public static void change() {
		// 修改
		Menber menber = new Menber();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入需要修改的成员位置");
		int pos = scanner.nextInt();
		System.out.println("请输入成员姓名");
		menber.name = scanner.next();
		System.out.println("请输入成员性别");
		menber.sex = scanner.next();
		System.out.println("请输入成员电话号码");
		menber.phoneNum = scanner.next();
		System.out.println("请输入成员通信地址");
		menber.address = scanner.next();
		mailList.changeMenber(menber, pos);
		mailList.showMenbers(mailList.menbers);
		
	}

	public static void delete() {
		// 删除
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入需要删除的成员位置");
		int pos = scanner.nextInt();
		mailList.deleteMenber(pos - 1);
		mailList.showMenbers(mailList.menbers);
		
	}

	public static void search() {
		// 查找
		Menber name = new Menber();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入需要查找的成员姓名");
		name.name = scanner.next();
		Menber[] result = mailList.findMenber(name);
		mailList.showMenbers(result);
		
	}
}
