package com.neuedu;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestCollenction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestCollenction tc = new TestCollenction();
		//tc.testSet();
		//tc.testList();
		tc.testSort();
	}
//set接口
	public void testSet() {
				
		Set set = new HashSet();
		set.add(123);
		set.add(123);
		set.add("name");
		set.add(new Person(11));
		System.out.println(set.size());
		System.out.println(set);
		
		//获取iterator的接口对象
		 Iterator iterator = set.iterator();
		 while(iterator.hasNext()) {
			 Object o = iterator.next();
			 System.out.println(o);
		 }
	}
	
	//list接口
	public void testList() {
		List list = new ArrayList();
		list.add(123);
		list.add(123);
		list.add("name");
		list.add(new Person(11));
		System.out.println(list.size());
		System.out.println(list);
		
		
	/*	
		//获取iterator的接口对象
		 Iterator iterator = list.iterator();
		 while(iterator.hasNext()) {
			 Object o = iterator.next();
			 System.out.println(o);
		 }
		*/
		//有下标（index）可以通过get获取
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	//List的排序
	public void testSort() {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(1);
		list.add(7);
		list.add(3);
		list.add(8);
		list.add(6);
		list.add(9);
		list.add(0);
		
		System.out.println(list);
		
		//排序sort
		Collections.sort(list);
		
		//遍历集合
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			Integer o = it.next();
			System.out.print(o);
		}
	}
}
