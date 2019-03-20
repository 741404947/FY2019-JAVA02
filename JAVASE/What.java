public class What{
	public static void main(String[] args){
		int num = 9874;
		black(num);
	}
	public static void text(int[] arry){
		int x = 0;
		for(int i = 0; i < arry.length; i++){
			for(int j = i + 1; j < arry.length; j++){
				if(arry[i] > arry[j]){
					x = arry[i];
					arry[i] = arry[j];
					arry[j] = x;
				}
			}
		}
		/*for(int i = 0; i < arry.length; i++){
			System.out.println(arry[i]);
			
		}*/
		
		
		//System.out.println("max=" + max + "min=" + min);
	}
	public static void black(int num){
		int[] arr = new int[4];
		int max = 0;
		int min = 0;
		int t = 0;
		do{
			for(int i = 0; i < arr.length; i++){
				arr[i] = num%10;
				num = num/10;
			}
			text(arr);
			max = arr[3]*1000 + arr[2]*100 + arr[1]*10 + arr[0];
			min = arr[0]*1000 + arr[1]*100 + arr[2]*10 + arr[3];
			num = max - min;
			System.out.println(max + "-" + min + " = " + num);
			t++;
		}while(num != 6174);
		System.out.println("一共进行了" + t + "步");
	}
}