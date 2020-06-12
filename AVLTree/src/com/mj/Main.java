package com.mj;

import com.mj.printer.BinaryTrees;
import com.mj.tree.AVLTree;

public class Main {

	// Integer类型的数据
	static void test01() {
		Integer data[] = new Integer[] { 
				47, 81, 6, 33, 22, 35, 4, 26, 40, 97, 58, 82, 20, 24, 14, 75, 2 
		};
		AVLTree<Integer> bst = new AVLTree<Integer>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.println(bst);
	}

	public static void main(String[] args) {
		test01();
	}

}
