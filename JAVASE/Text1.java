public class Text1{
	public static void main(String[] args){
		int i;
		cin >> i;
		if(i >= 90){
			System.out.println("�ɼ�Ϊ��" + i + "����ΪA");
		}else if(i < 90 && i >= 60){
			System.out.println("�ɼ�Ϊ��" + i + "����ΪB");
		}else{
			System.out.println("�ɼ�Ϊ��" + i + "����ΪC");
		}
	}
}