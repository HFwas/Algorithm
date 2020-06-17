package com.mj.set;

import java.util.TreeMap;

import com.mj.map.Map;

public class TreeSet<E> implements Set<E> {
	Map<E, Object> map = new com.mj.map.TreeMap<>();
	
	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public void claer() {
		map.clear();
	}

	@Override
	public boolean contains(E element) {
		return map.containsKey(element);
	}

	@Override
	public void add(E element) {
		map.put(element, null);
	}

	@Override
	public void remove(E element) {
		map.remove(element);
	}

	@Override
	public void traversal(com.mj.set.Set.Visitor<E> visitor) {
		map.traversal(new Map.Visitor<E, Object>() {
			@Override
			public boolean visit(E key, Object value) {
				return visitor.visit(key);
			}
			
		});
	}

}
