package com.neuedu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimeDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//����һ��ʱ�����
		Date date = new Date(System.currentTimeMillis());//���췽���п����޲Σ�Ҳ����ʱʱ���
		System.out.println(date);
		
		
		//�Ի�ȡ��ʱ����и�ʽ��
		SimpleDateFormat format = new SimpleDateFormat();
		String _date = format.format(date);
		
		//����ʱ��
		System.out.println(_date);
		
		//System.out.println(System.currentTimeMillis());//ʱ���
		
	}


}
