package com.mj;

import java.util.Comparator;

import com.mj.BinarySearchTree.Visitor;
import com.mj.file.Files;
import com.mj.printer.BinaryTrees;

public class Main {

	private static class PersonComparator implements Comparator<Person> {
		public int compare(Person e1, Person e2) {
			return e1.getAge() - e2.getAge();
		}
	}

	private static class PersonComparator2 implements Comparator<Person> {
		public int compare(Person e1, Person e2) {
			return e2.getAge() - e1.getAge();
		}
	}

	// Integer类型的数据
	static void test01() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1 };

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.println(bst);
	}

	// Person类的数据
	static void test02() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1 };
		BinarySearchTree<Object> bst1 = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst1.add(new Person(data[i]));
		}
		BinaryTrees.println(bst1);

		// 匿名类
		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		for (int i = 0; i < data.length; i++) {
			bst2.add(new Person(data[i]));
		}
		BinaryTrees.println(bst2);
	}

	// 保存打印结果
	static void test03() {
		BinarySearchTree<Object> bst = new BinarySearchTree<>();
		for (int i = 0; i < 40; i++) {
			bst.add((int) (Math.random() * 100));
		}
		// BinaryTrees.println(bst);
		String str = BinaryTrees.printString(bst);
		str += "\n";
		Files.writeToFile("D:/file/1.txt", str);
	}

	// add() 时值相等的处理
	public static void test04() {
		BinarySearchTree<Person> bst = new BinarySearchTree<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		bst.add(new Person(15, "jack"));
		bst.add(new Person(16, "rose"));
		bst.add(new Person(10, "jerry"));
		bst.add(new Person(10, "kali")); // add()时值相等最好覆盖，否则则不会替换
		BinaryTrees.println(bst);
	}
	
	static void test06() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1 };

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.println(bst);
		
		//bst.levelOrderTraversal();
		
		bst.levelOrder(new Visitor<Integer>() {
			@Override
			public void visit(Integer element) {
				System.out.print("_" + element + "_");
			}
		});
	}
	
	public static void main(String[] args) {
		test06();
	}

}
