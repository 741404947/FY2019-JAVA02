public class WordSpace{
	public static void main(String[] args){
		int[] arry = {1,3,2,7,5};
		int arry_second[] = {1,2,3,4};
		/*float result = text1(arry);
		System.out.println("数组平均值" + result);*/
		//text2(arry);
		//text3(arry);
		//text4(arry);
		text5(arry_second);
		int sum = text5_1(arry_second);
		int arr[] = text5_2(sum);
	}
	public static float text1(int[] arry){
		int sum = 0;
		for(int i = 0;i < arry.length; i++){
			sum += arry[i];
		}
		float aver = (float)(sum/arry.length);
		//System.out.println("数组平均值" + aver);
		return aver;
	}
	public static void text2(int[] arry){
		int n = 2;
		for(int i = 0;i < arry.length; i++){
			if(n == arry[i]){
				System.out.println(i);
			}else{
				System.out.println(-1);
			}
		}
	}
	public static void text3(int[] arry){
		int x = 0;
		for(int i = 0; i < arry.length; i++){
			for(int j = i + 1; j < arry.length; j++){
				//System.out.println(arry[j]);
				if(arry[i] > arry[j]){
					x = arry[i];
					arry[i] = arry[j];
					arry[j] = x;
				}
			}
		}
		for(int i = 0; i < arry.length; i++){
			System.out.println(arry[i]);
		}
		
	}
	public static void text4(int[] arry){
		int max = arry[0];
		int min = arry[0];
		for(int i = 0; i < arry.length; i++){
			if(arry[i] > max){
				max = arry[i];
			}else if(arry[i] < min){
				min = arry[i];
			}
		}
		System.out.println(max);
		System.out.println(min);
	}
	public static void text5(int[] arry){
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
	public static int text5_1(int[] arry){
		
		int max = arry[3]*1000 + arry[2]*100 + arry[1]*10 + arry[0];
		int min = arry[0]*1000 + arry[1]*100 + arry[2]*10 + arry[3];
		int sum = max - min;
		return sum;
	}
	public static int[] text5_2(int a){
		String str = null;
		str = Integer.toString(a);
        int[] arr = new int[str.length()];
        for(int i=0; i<arr.length; i++){
            char c = str.charAt(i);
            String s = String.valueOf(c);
            int num = Integer.parseInt(s);
            arr[i] = num;
        }
    return arr;
	}

}