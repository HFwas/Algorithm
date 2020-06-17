package com.mj;

import com.mj.file.FileInfo;
import com.mj.file.Files;
import com.mj.map.Map;
import com.mj.map.Map.Visitor;
import com.mj.map.TreeMap;
import com.mj.set.Set;
import com.mj.set.TreeSet;

public class Main {
	public static void main(String[] args) {
		test03();
	}
	
	static void test03(){
		Set<String> set = new TreeSet<>();
		set.add("d");
		set.add("d");
		set.add("a");
		set.add("c");
		set.add("c");
		set.add("b");
		set.add("b");
		
		set.traversal(new Set.Visitor<String>() {
			@Override
			public boolean visit(String element) {
				System.out.println(element);
				return false;
			}
		});
	}
	
	static void test02(){
		FileInfo fileInfo = Files.read("D:\\Java\\jdk1.8.0_221\\src\\java\\util\\concurrent", 
				new String[]{"java"});
		System.out.println("文件数量:" + fileInfo.getFiles());
		System.out.println("代码行数：" + fileInfo.getLines());
		String[] words = fileInfo.words();
		System.out.println("单词数量：" + words.length);
		
		Map<String,Integer> map = new TreeMap<>();
		for (int i = 0; i < words.length; i++) {
			Integer count = map.get(words[i]);
			count = (count == null) ? 1 : (count + 1);
			map.put(words[i], count);
		}

		map.traversal(new Visitor<String, Integer>() {
			public boolean visit(String key, Integer value) {
				System.out.println(key + "_" + value);
				return false;
			}
		});
	}
	
	static void test01(){
		Map<String,Integer> map = new TreeMap<>();
		map.put("c", 2);
		map.put("a", 5);
		map.put("b", 6);
		map.put("a", 8);
		
		map.traversal(new Visitor<String, Integer>() {
			public boolean visit(String key, Integer value) {
				System.out.println(key + "_" + value);
				return false;
			}
		});
	}
}
