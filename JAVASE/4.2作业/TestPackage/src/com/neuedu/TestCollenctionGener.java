package com.neuedu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author 74140
 *���͵��÷�
 *���Զ���TestCollenctionԴ�ļ�
 */
public class TestCollenctionGener {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			TestCollenctionGener tcg = new TestCollenctionGener();
			//tcg.testSet();
			//tcg.testList();
			tcg.testSetAggre();
		}
	//set�ӿ�
		public void testSet() {
					
			Set<Integer> set = new HashSet<Integer>();
			set.add(123);
			set.add(123);
			/*set.add("name");
			set.add(new Person(11));*///����������-->Ҳ����Ineger
			System.out.println(set.size());
			System.out.println(set);
			
			//��ȡiterator�Ľӿڶ���
			 Iterator iterator = set.iterator();
			 while(iterator.hasNext()) {
				 Object o = iterator.next();
				 System.out.println(o);
			 }
		}
		
		//list�ӿ�
		public void testList() {
			List<String> list = new ArrayList<String>();
		/*	list.add(123);
			list.add(123);*///�������ַ���-->Ҳ����String
			list.add("name");
			//list.add(new Person(11));
			System.out.println(list.size());
			System.out.println(list);
			
			
		/*	
			//��ȡiterator�Ľӿڶ���
			 Iterator<String> iterator = list.iterator<String>();
			 while(iterator.hasNext()) {
				 String o = iterator.next();
				 System.out.println(o);
			 }
			*/
			//���±꣨index������ͨ��get��ȡ
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
