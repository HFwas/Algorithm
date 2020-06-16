package com.mj;

import com.mj.Times.Task;
import com.mj.file.FileInfo;
import com.mj.file.Files;
import com.mj.set.ListSet;
import com.mj.set.Set;
import com.mj.set.Set.Visitor;

import com.mj.set.TreeSet;

public class Main {

	public static void main(String[] args) {
		
		test02();
	}
	
	
	static void test02(){
		FileInfo fileInfo = Files.read("D:\\Java\\jdk1.8.0_221\\src\\java\\util\\concurrent", 
				new String[]{"java"});
		System.out.println("文件数量:" + fileInfo.getFiles());
		System.out.println("代码行数：" + fileInfo.getLines());
		String[] words = fileInfo.words();
		System.out.println("单词数量：" + words.length);
		
		Times.test("ListSet", new Task() {
			@Override
			public void execute() {
				testSet(new ListSet<>(), words);
			}
		});
		
		Times.test("TreeSet", new Task() {
			@Override
			public void execute() {
				testSet(new TreeSet<>(), words);
			}
		});
	}
	
	static void testSet(Set<String> set, String[] strings){
		for (int i = 0; i < strings.length; i++) {
			set.add(strings[i]);
		}
		for (int i = 0; i < strings.length; i++) {
			set.contains(strings[i]);
		}
		for (int i = 0; i < strings.length; i++) {
			set.remove(strings[i]);
		}
	}
	
	static void test01(){
		ListSet<Integer> listSet = new ListSet<>();
		listSet.add(10);
		listSet.add(12);
		listSet.add(11);
		listSet.add(12);
		listSet.add(11);
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(10);
		treeSet.add(12);
		treeSet.add(11);
		treeSet.add(12);
		treeSet.add(11);
		
		treeSet.traversal(new Visitor<Integer>() {
			@Override
			public boolean visit(Integer element) {
				System.out.println(element);
				return false;
			}
		});
	}

}
