import java.util.Scanner;
public class StudentSystem{
	public static void main(String[] args){
		nav();
		//Scanner scen = new Scanner(System.in);//scen.nextInt����----scen.nextLine()
		Admin[] admins = new Admin[5];
		inDate(admins);//���ݳ�ʼ��
		login(admins);
		
		nav_two();
		Student[] stus = new Student[5];
		login_two();
		//instuDate(stus);
	}
	public static void nav(){
		System.out.println("------------------" + "��ӭ��½ѧ������ϵͳ" + "-------------------");
		System.out.println("1.��½" + "2.�˳�");
		System.out.println("-----------------------------------");
		
	}
	public static void login(Admin[] admins){
		Scanner scen = new Scanner(System.in);
		System.out.print("��ѡ��");
		int opr = scen.nextInt();
		if(opr == 1){
			System.out.println("��ӭ��½��");
			land(admins);
		}else if(opr == 2){
			System.exit(0);
			
		}else{
			System.out.println("�������!!!!����������");
			login(admins);//�ݹ����
		}
		
	}
	public static void inDate(Admin[] admins){
		Admin admin = new Admin("admin","admin");
		admins[0] = admin;
	}
	public static void land(Admin[] admins){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�������û�����");
		String username = scan.nextLine();
		
		System.out.print("���������룺");
		String password = scan.nextLine();	
		
		for(int i = 0; i < admins.length; i++){
			if(admins[i] == null){
				//land(admins);
				continue;
				
			}
			if(admins[i].username.equals(username) && admins[i].password.equals(password)){
				System.out.println("��½�ɹ���������");
				System.out.println("��ӭ����" + username);
				break;
			}else{
				System.out.print("������û�����������󣡣�������");
				land(admins);
			}
			
		}
	}
	
	public static void nav_two(){
		System.out.println("-------------------" + "��ѡ��Ҫ��������Ϣ��Ӧ����" + "-------------------");
		System.out.println("1.�鿴ѧ���ɼ�" + "2.���ѧ���ɼ�" + "3.ɾ��ѧ����Ϣ" + "4.�޸�ѧ����Ϣ" + "5.�˳�");
		System.out.println("-----------------------------------");
	}
	
	public static void login_two(){
		System.out.print("�����룺");
		Scanner scan = new Scanner(System.in);
		int opr = scan.nextInt();
		if(opr == 1){
			//�鿴��Ϣ
			
		}else if(opr == 2){
			//�����Ϣ
			information();
		}else if(opr == 3){
			//ɾ����Ϣ
			
		}else if(opr == 4){
			//�޸���Ϣ
			
		}else if(opr == 5){
			System.exit(0);
			
		}else{
			System.out.println("�������!!!!����������");
			login_two();//�ݹ����
		}
	}
	public static void information_sp(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("������ѧ����ID:");
		int id = scan.nextInt();
		if(id > 5){
			System.out.println("��ID" + id +"�Ѿ����ڣ����������������룺");
			information_sp();
		}
	}
	public static void information(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("������ѧ����������");
		String name = scan.nextLine();
		
		System.out.print("������ѧ�����Ա�");
		String sex = scan.nextLine();
		
		System.out.print("������ѧ��������:");
		int age = scan.nextInt();
		
		System.out.print("������ѧ����ѧ����");
		String school = scan.nextLine();
		
		System.out.print("������ѧ���ĵ�ַ��");
		String address = scan.nextLine();
		
		System.out.print("������ѧ�����ֻ����룺");
		String phone = scan.nextLine();
		
		System.out.print("������ѧ�������䣺");
		String email = scan.nextLine();
	}
	/*public static void instuDate(Student[] stus){
		information_sp();
		information();
		
		Student s = new Student();
		s.id =0;
		s.name ="����";
		s.sex = "��";
		s.age = 12;
		s.school = "����";
		s.address = "sdfsafsa";
		s.phone = "55151515";
		s.email = "ad51556a";
		
		s.id = id;
		s.name = name;
		s.sex = sex;
		s.age = age;
		s.school = school;
		s.address = address;
		s.phone = phone;
		s.email = email;
		
		stus[0] = s;
	}*/
}


class Admin{
	public String username;
	public String password;
	
	public Admin(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public String getUsername(){
		return username;
	} 
	public void setUsername(String username){
		this.username = username;
	}
	
	
	public String getPassword(){
		return password;
	} 
	public void setPassword(String password){
		this.password = password;
	}
	
}


class Student{
	public int id;
	public String name;
	public String sex;
	public int age;
	public String school;
	public String address;
	public String phone;
	public String email;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	
	public String getSchool(){
		return school;
	}
	public void setSchool(String school){
		this.school = school;
	}
	
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
}