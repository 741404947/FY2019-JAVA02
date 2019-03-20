public class Text3{
	public static void main(String[] args){
		for(int n = 1;n <= 1000;n++){
			boolean result = isProduct(n);
			if(result){
				System.out.println(n + "ÊÇÍêÊý");
			}
		}
	}
	public static boolean isProduct(int n){
		int sum = 0;
		for(int i = 1;i < n;i++){
			if(n % i == 0){
				sum += i;
			}
		}
		if(sum == n){
			return true;
		}else{
			return false;
		}
	}
}