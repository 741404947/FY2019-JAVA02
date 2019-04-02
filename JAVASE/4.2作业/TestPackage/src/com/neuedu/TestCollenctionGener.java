package com.neuedu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author 74140
 *泛型的用法
 *可以对照TestCollenction源文件
 */
public class TestCollenctionGener {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			TestCollenctionGener tcg = new TestCollenctionGener();
			//tcg.testSet();
			//tcg.testList();
			tcg.testSetAggre();
		}
	//set接口
		public void testSet() {
					
			Set<Integer> set = new HashSet<Integer>();
			set.add(123);
			set.add(123);
			/*set.add("name");
			set.add(new Person(11));*///泛型是数字-->也就是Ineger
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
			List<String> list = new ArrayList<String>();
		/*	list.add(123);
			list.add(123);*///泛型是字符串-->也就是String
			list.add("name");
			//list.add(new Person(11));
			System.out.println(list.size());
			System.out.println(list);
			
			
		/*	
			//获取iterator的接口对象
			 Iterator<String> iterator = list.iterator<String>();
			 while(iterator.hasNext()) {
				 String o = iterator.next();
				 System.out.println(o);
			 }
			*/
			//有下标（index）可以通过get获取
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		
		
		public void testSetAggre() {
			Set<Person> set = new HashSet<Person>();
			set.add(new Person(1, "huqisheng"));
			set.add(new Person(1, "huqisheng"));
			
			System.out.println(set.size());
			
		}
	}
