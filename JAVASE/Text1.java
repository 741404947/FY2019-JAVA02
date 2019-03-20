public class Text1{
	public static void main(String[] args){
		int i;
		cin >> i;
		if(i >= 90){
			System.out.println("成绩为：" + i + "评分为A");
		}else if(i < 90 && i >= 60){
			System.out.println("成绩为：" + i + "评分为B");
		}else{
			System.out.println("成绩为：" + i + "评分为C");
		}
	}
}