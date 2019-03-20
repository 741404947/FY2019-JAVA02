public class Text5{
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		//int[] b = expand(a);
		
		changeArray(a);
		printArray(a);
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}
	}
	public static int[] expand(int[] a){
		int[] newArray = new int[a.length * 2];
		System.arraycopy(a, 0, newArray, 0, a.length);
		a = newArray;
		return a;
	}
	public static void changeArray(int[] a){
		a[0] = 10;
	}
	public static void printArray(int[] a){
		for(int i = 0; i<a.length; i++){
			System.out.print(a[i] + "\t");
		}
		System.out.println();
	}
}