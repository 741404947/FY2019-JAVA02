package com.neuedu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 74140
 *Map �ӿڼ���
 */
public class TestMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMap tm = new TestMap();
		tm.testMap();
	}
	
	public void testMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("age", 12);
		map.put("id", 5);
		//System.out.println(map.size());//���ϳ���
		Integer age = map.get("age");//��ȡ��ֵ
		//System.out.println(age);
		
		
		//��������
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		Iterator<Map.Entry<String, Integer>> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("key:" + key + "     " + "value:" + value);
		}
		
	}
}
