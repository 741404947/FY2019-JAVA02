//����ע��
/* 
����ע��
*/
/**
�ı���ע��
*/
public class Number{
	public static void main(String []args){
		for(int i = 100;i <= 999;i++){
			int a = i/100;
			int b = i/10%10;
			int c = i%10;
			int num = a*a*a + b*b*b + c*c*c;
			if(num == i){
				System.out.println(num);
			}
		}
	}
}