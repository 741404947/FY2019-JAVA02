public class MathNumber{
	public static void main(String[] args) {
		int arry[][] = new int[3][];
		arry[0] = new int[2];
		arry[1] = new int[3];
		arry[2] = new int[4];

		arry[0][0] = 1;
		arry[0][1] = 2;
		arry[1][0] = 3;
		arry[1][1] = 4;
		arry[1][2] = 5;
		arry[2][0] = 6;
		arry[2][1] = 7;
		arry[2][2] = 8;
		arry[2][3] = 9;
		for(int i = 0; i < arry.length; i++){
			for(int j = 0; j < arry[i].length; j++){
				System.out.println("arry[" + i + "][" + j + "] = " + arry[i][j]);
			}
		}
	}
		
}