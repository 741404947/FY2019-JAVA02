public class Text4{
	public static void main(String[] args){
		//computer();
		//text();
		//num();
		//transport();
		/*int[] arry = {23,45,78,45,85};*/
		/*int[] arry;
		arry = new int[5];
		arry[0] = 12;
		arry[1] = 91;
		arry[2] = 74;
		arry[3] = 124;
		arry[4] = 122;*/
		/*int[] arry;
		arry = new int[]{23,45,78,45,85};
		for(int i = 0;i < arry.length;i++){
			System.out.println(arry[i]);
		}*/
		int a[] = {1,2,3,4,5};
		expand(a);
	}
	public static void computer(){
		int i = 0;
		int j = i++ + ++i;// j = 0 + 2 = 2       i = 1   ---   i = 2
		int x = --i + i--;// x = 1 + 1 = 2       i = 1   ---   i = 0
		System.out.println("i=" + i + "j=" + j + "x=" + x);
	}
	public static void text(){
		for(int a = 1;a <= 100;a++){
			System.out.println(a); 
			if(a == 50){
				break;
			}
			
		}
	}
	public static int num(){
		int i,a,b;
		i = 5;
		a = 9;
		b = 15;
		System.out.println(i + a + b);
		return 5;
	}
	public static void transport(){
		int i=1,j=9;
		float f1=0.1f; 
		float f2=123;
		long l1=12345678,l2=8888888888l;
		double d1=2e20,d2=124;
		byte b1=1,b2=2,b3=120;
		j=j+10;
		i=i/10;
		i=(int)(i*0.1);
		char c1='a',c2=125; 
		byte b=(byte)(b1-b2);
		char c=(char)(c1+c2-1);
		float f3=f1+f2;
		float f4=(float)(f1+f2*0.1);
		double d=d1*i+j;
		float f=(float)(d1*5+d2);
	}
	public static void expand(int[] a){
		int[] newArray = new int[a.length * 2];
		System.arraycopy(a, 0, newArray, 0, a.length);
		a = newArray;
		System.out.println(a);
	}
}