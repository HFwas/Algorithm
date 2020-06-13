package com.mj;

import com.mj.printer.BinaryTrees;
import com.mj.tree.AVLTree;
import com.mj.tree.BST;

public class Main {

	// Integer类型的数据
	static void test01() {
		/*Integer data[] = new Integer[] { 
				2,76, 78, 14, 43, 90, 40, 28, 8, 10, 66, 91, 77, 72, 74, 47, 48, 94 
		};*/
		Integer data[] = new Integer[] { 
				75, 94, 21, 7, 93, 31, 83, 65, 43, 50, 57, 56
		};
		AVLTree<Integer> avl = new AVLTree<Integer>();
		for (int i = 0; i < data.length; i++) {
			avl.add(data[i]);
		}
		BinaryTrees.println(avl);
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			avl.remove(data[i]);
			System.out.println(data[i]);
			BinaryTrees.println(avl);
		}
		//BinaryTrees.println(avl);
	}

	public static void main(String[] args) {
		test01();
	}

}
