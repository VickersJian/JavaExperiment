package main;

public class MailList {
	public Menber[] menbers=null;
	int num;
	public MailList(int num) {
		this.num=num;
		menbers=new Menber[num];
	}
	//初始化通信录
	public Menber[] initMenber(Menber menber,int pos) {
		menbers[pos]=menber;
		return this.menbers;
	}
	//显示成员
	public void showMenber(Menber a) {
		if(a!=null)
			System.out.println(a.name+"\t"+a.sex+"\t"+a.phoneNum+"\t"+a.address);
	}
	//显示所有成员
	public void showMenbers(Menber[] menbers) {
		if(menbers!=null) {
			System.out.println("姓名\t性别\t电话\t通信地址");
			for(Menber a:menbers) {
				System.out.println(a.name+"\t"+a.sex+"\t"+a.phoneNum+"\t"+a.address);
			}
		}
	}
	//查找通信录
	public Menber[] findMenber(Menber menber) {
		Menber[] menbers=new Menber[num];
		int findNum=0;
		if(menber.name!=null) {
			for(Menber a:this.menbers) {
				if(a.name.equals(menber.name)) {
					menbers[findNum]=a;
					findNum++;
				}
			}
		}else if(menber.sex!=null) {
			for(Menber a:this.menbers) {
				if(a.sex.equals(menber.sex)) {
					menbers[findNum]=a;
					findNum++;
				}
			}
			
		}else if(menber.phoneNum!=null) {
			for(Menber a:this.menbers) {
				if(a.phoneNum.equals(menber.phoneNum)) {
					menbers[findNum]=a;
					findNum++;
				}
			}
			
		}else if(menber.address!=null) {
			for(Menber a:this.menbers) {
				if(a.address.equals(menber.address)) {
					menbers[findNum]=a;
					findNum++;
				}
			}
		}else {
			return null;
		}
		if(findNum==0)
			return null;
		else {
			Menber[] toReturn=new Menber[findNum];
			for(int i=0;i<findNum;i++)
				toReturn[i]=menbers[i];
			return toReturn;
		}
			
	}
	//添加成员
	public void addMenber(Menber menber) {
		Menber[] menbers=new Menber[num+1];
		for(int i=0;i<num;i++) {
			menbers[i]=this.menbers[i];
		}
		menbers[num]=menber;
		num++;
		this.menbers=menbers;
	}
	//修改成员
	public void changeMenber(Menber menber,int pos) {
		menbers[pos]=menber;
	}
	//删除成员
	public void deleteMenber(int pos) {
		if(num-1!=0) {
			Menber[] result=new Menber[num-1];
			for(int i=0,j=0;j<num;i++,j++) {
				if(i==pos) {
					j++;
				}
				result[i]=menbers[j];
			}
			menbers=result;
		}else {
			menbers=null;
		}
	}
}
