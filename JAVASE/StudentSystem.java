import java.util.Scanner;
public class StudentSystem{
	public static void main(String[] args){
		nav();
		//Scanner scen = new Scanner(System.in);//scen.nextInt（）----scen.nextLine()
		Admin[] admins = new Admin[5];
		inDate(admins);//数据初始化
		login(admins);
		
		nav_two();
		Student[] stus = new Student[5];
		login_two();
		//instuDate(stus);
	}
	public static void nav(){
		System.out.println("------------------" + "欢迎登陆学生管理系统" + "-------------------");
		System.out.println("1.登陆" + "2.退出");
		System.out.println("-----------------------------------");
		
	}
	public static void login(Admin[] admins){
		Scanner scen = new Scanner(System.in);
		System.out.print("请选择：");
		int opr = scen.nextInt();
		if(opr == 1){
			System.out.println("欢迎登陆：");
			land(admins);
		}else if(opr == 2){
			System.exit(0);
			
		}else{
			System.out.println("输入错误!!!!请重新输入");
			login(admins);//递归调用
		}
		
	}
	public static void inDate(Admin[] admins){
		Admin admin = new Admin("admin","admin");
		admins[0] = admin;
	}
	public static void land(Admin[] admins){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("请输入用户名：");
		String username = scan.nextLine();
		
		System.out.print("请输入密码：");
		String password = scan.nextLine();	
		
		for(int i = 0; i < admins.length; i++){
			if(admins[i] == null){
				//land(admins);
				continue;
				
			}
			if(admins[i].username.equals(username) && admins[i].password.equals(password)){
				System.out.println("登陆成功！！！！");
				System.out.println("欢迎您：" + username);
				break;
			}else{
				System.out.print("输入的用户名或密码错误！！！！！");
				land(admins);
			}
			
		}
	}
	
	public static void nav_two(){
		System.out.println("-------------------" + "请选择要操作的信息对应数字" + "-------------------");
		System.out.println("1.查看学生成绩" + "2.添加学生成绩" + "3.删除学生信息" + "4.修改学生信息" + "5.退出");
		System.out.println("-----------------------------------");
	}
	
	public static void login_two(){
		System.out.print("请输入：");
		Scanner scan = new Scanner(System.in);
		int opr = scan.nextInt();
		if(opr == 1){
			//查看信息
			
		}else if(opr == 2){
			//添加信息
			information();
		}else if(opr == 3){
			//删除信息
			
		}else if(opr == 4){
			//修改信息
			
		}else if(opr == 5){
			System.exit(0);
			
		}else{
			System.out.println("输入错误!!!!请重新输入");
			login_two();//递归调用
		}
	}
	public static void information_sp(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("请输入学生的ID:");
		int id = scan.nextInt();
		if(id > 5){
			System.out.println("此ID" + id +"已经存在！！！！！重新输入：");
			information_sp();
		}
	}
	public static void information(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("请输入学生的姓名：");
		String name = scan.nextLine();
		
		System.out.print("请输入学生的性别：");
		String sex = scan.nextLine();
		
		System.out.print("请输入学生的年龄:");
		int age = scan.nextInt();
		
		System.out.print("请输入学生的学历：");
		String school = scan.nextLine();
		
		System.out.print("请输入学生的地址：");
		String address = scan.nextLine();
		
		System.out.print("请输入学生的手机号码：");
		String phone = scan.nextLine();
		
		System.out.print("请输入学生的邮箱：");
		String email = scan.nextLine();
	}
	/*public static void instuDate(Student[] stus){
		information_sp();
		information();
		
		Student s = new Student();
		s.id =0;
		s.name ="张三";
		s.sex = "男";
		s.age = 12;
		s.school = "初中";
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