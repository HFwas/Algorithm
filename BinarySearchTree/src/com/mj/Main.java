package com.mj;

import java.util.Comparator;

public class Main {

	private static class PersonComparator implements Comparator<Person>{
		public int compare(Person e1, Person e2) {
			return e1.getAge() - e2.getAge();
		}
	}
	
	private static class PersonComparator2 implements Comparator<Person>{
		public int compare(Person e1, Person e2) {
			return e1.getAge() - e2.getAge();
		}
	}

	public static void main(String[] args) {
		/*Integer[] data= new Integer[]{
				7,4,9,2,5,8,11,3
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		System.out.println(bst);*/
		
		//JAVA中的匿名类，相当于IOS中的Block
		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return 0;
			}
			
		});
		bst2.add(new Person(12));
		bst2.add(new Person(22));
		
		BinarySearchTree<Person> bst3 = new BinarySearchTree<>();
		bst2.add(new Person(12));
		bst2.add(new Person(22));
		
	}

}
