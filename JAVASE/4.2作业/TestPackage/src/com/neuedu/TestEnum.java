package com.neuedu;

/**
 * @author 74140
 *����һ��ö������
 */
public enum TestEnum {
	NO_PAY("δ�����"),
	PAYID("�Ѹ����"),
	FINISH("����ɣ���")
	;
	private String testEnum;
	TestEnum(String testEnum) {
		// TODO Auto-generated constructor stub
		this.testEnum = testEnum;
	}
	
	
	public String getTestEnum() {
		return testEnum;
	}


	public static void main(String[] args) {
		String a = TestEnum.NO_PAY.getTestEnum();
		System.out.println(a);
		System.out.println(TestEnum.PAYID.getTestEnum());
		System.out.println(TestEnum.FINISH.getTestEnum());
	}
}
