package main;

import java.util.Scanner;

public class Main {
	static MailList mailList = new MailList(10);

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			mailList.initMenber(
					new Menber("����" + (i + 1), (i % 2 == 0 ? "��" : "Ů"), ("100" + i), ("��ǿ·" + (i + 1) + "��")), i);
		}
		System.out.println("�����������ţ�\n1.��ѯ\n2.���\n3.�޸�\n4.ɾ��\n5.�˳�\n");
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
		// ���
		Menber menber = new Menber();
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������Ա����");
		menber.name = scanner.next();
		System.out.println("�������Ա�Ա�");
		menber.sex = scanner.next();
		System.out.println("�������Ա�绰����");
		menber.phoneNum = scanner.next();
		System.out.println("�������Աͨ�ŵ�ַ");
		menber.address = scanner.next();
		mailList.addMenber(menber);
		mailList.showMenbers(mailList.menbers);
		
	}

	public static void change() {
		// �޸�
		Menber menber = new Menber();
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������Ҫ�޸ĵĳ�Աλ��");
		int pos = scanner.nextInt();
		System.out.println("�������Ա����");
		menber.name = scanner.next();
		System.out.println("�������Ա�Ա�");
		menber.sex = scanner.next();
		System.out.println("�������Ա�绰����");
		menber.phoneNum = scanner.next();
		System.out.println("�������Աͨ�ŵ�ַ");
		menber.address = scanner.next();
		mailList.changeMenber(menber, pos);
		mailList.showMenbers(mailList.menbers);
		
	}

	public static void delete() {
		// ɾ��
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������Ҫɾ���ĳ�Աλ��");
		int pos = scanner.nextInt();
		mailList.deleteMenber(pos - 1);
		mailList.showMenbers(mailList.menbers);
		
	}

	public static void search() {
		// ����
		Menber name = new Menber();
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������Ҫ���ҵĳ�Ա����");
		name.name = scanner.next();
		Menber[] result = mailList.findMenber(name);
		mailList.showMenbers(result);
		
	}
}
