package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Student[] students = new Student[10];
		for(int i=0;i<10;i++)
			students[i]=new Student("ѧ��"+(i+1),i*10);
		Student Max=getHigestMarkStudent(students,10);
		Student Min=getLowestMarkStudent(students,10);
		System.out.println("��߷ֵ�ѧ��Ϊ��"+Max.name+" ������"+Max.mark);
		System.out.println("��߷ֵ�ѧ��Ϊ��"+Min.name+" ������"+Min.mark);
		System.out.println("��������Ҫ��ѯ��ѧ������");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		scanner.close();
		Student result=findStudent(name,students,10);
		if(result==null) {
			System.out.println("�����ڸ�ѧ��");
		}else {
			System.out.println(result.name+"�ķ���Ϊ��"+result.mark);
		}
		
	}
	
	public static Student getHigestMarkStudent(Student[] students,int num) {
		if(students!=null) {
			Student Max=students[0];
			for(int i=0;i<num;i++) {
				if(Max.mark<students[i].mark)
					Max=students[i];
			}
			return Max;
		}
		return null;
	}
	
	public static Student getLowestMarkStudent(Student[] students,int num) {
		if(students!=null) {
			Student min=students[0];
			for(int i=0;i<num;i++) {
				if(min.mark>students[i].mark)
					min=students[i];
			}
			return min;
		}
		return null;
	}
	
	public static Student findStudent(String name,Student[] students,int num) {
		if(students!=null) {
			for(int i=0;i<num;i++) {
				if(name.equals(students[i].name))
					return students[i];
			}
			return null;
		}
		return null;
	}
}
