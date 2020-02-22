package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Student[] students = new Student[10];
		for(int i=0;i<10;i++)
			students[i]=new Student("学生"+(i+1),i*10);
		Student Max=getHigestMarkStudent(students,10);
		Student Min=getLowestMarkStudent(students,10);
		System.out.println("最高分的学生为："+Max.name+" 分数："+Max.mark);
		System.out.println("最高分的学生为："+Min.name+" 分数："+Min.mark);
		System.out.println("请输入需要查询的学生名字");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		scanner.close();
		Student result=findStudent(name,students,10);
		if(result==null) {
			System.out.println("不存在该学生");
		}else {
			System.out.println(result.name+"的分数为："+result.mark);
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
