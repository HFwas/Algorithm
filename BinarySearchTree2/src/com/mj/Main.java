package com.mj;

import java.util.Comparator;

import com.mj.file.Files;
import com.mj.printer.BinaryTrees;
import com.mj.tree.BST;
import com.mj.tree.BinaryTree.Visitor;

public class Main {

	// Integer类型的数据
	static void test01() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1 };

		BST<Integer> bst = new BST<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.println(bst);
		bst.remove(12);
		BinaryTrees.println(bst);
	}

	public static void main(String[] args) {
		test01();
	}

}
