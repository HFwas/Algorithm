package com.mj;

@SuppressWarnings("unchecked")
public class ArrayList<E> extends AbstractList<E>{
	private int size;		// 元素的数量	
	private E[] elements; 	// 所有的元素

	private static final int DEFAULT_CAPACITY = 10; // 初始容量
	
	public ArrayList(int capacity) { // 容量小于10一律扩充为10
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		elements = (E[])new Object[capacity];
	}
	public ArrayList(){
		this(DEFAULT_CAPACITY);
	}
	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index, E element){ 
		rangeCheckForAdd(index); // 检查下标越界
		ensureCapacity(size + 1); // 确保容量够大
		
		// 0 1 2 3 4 5 6 7 8 9	(index)
		// 1 2 3 4 5 6 x x x x	(原数组)
		// 在index=2处，插入9，元素全部后移
		// 1 2 9 3 4 5 6 x x x	(add后数组)
		// 先从后往前开始, 将每个元素往后移一位, 然后再赋值
		for (int i = size - 1; i > index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element; // 复制
		size++;
	}
	/**
	 * 获取index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public E get(int index){
		rangeCheck(index);
		return elements[index];
	}
	/**
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public E set(int index, E element){
		rangeCheck(index);
		E old = elements[index];
		elements[index] = element;
		return old;
	}
	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public E remove(int index){
		rangeCheck(index);
		// 0 1 2 3 4 5 	(index)
		// 1 2 3 4 5 6 	(原数组)
		// 删除index为2的元素，元素前移
		// 1 2 4 5 6	(remove后的数组)
		// 从前往后开始移, 用后面的元素覆盖前面的元素
		E old = elements[index];
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		elements[--size] = null; // 删除元素后, 将最后一位设置为null
		return old;
	}
	
	/**
	 * 根据元素值来删除
	 * @param element
	 */
	public void remove(E element){
		remove(indexOf(element));
	}
	
	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(E element){
		if(element == null){ // 对 null 进行处理
			for (int i = 0; i < size; i++) {
				if(elements[i] == null) return i;
			}
		}else{
			for (int i = 0; i < size; i++) {
				if(elements[i].equals(element)) return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	/**
	 * 清除所有元素
	 */
	public void clear(){
		// 使用泛型数组后要注意内存管理(将元素置null)
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}
	/**
	 * 扩容操作
	 */
	private void ensureCapacity(int capacity){
		int oldCapacity = elements.length;
		if(oldCapacity >= capacity) return;
		// 新容量为旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[])new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i]; // 拷贝原数组元素到新数组
		}
		elements = newElements;
		System.out.println("size="+oldCapacity+", 扩容到了"+newCapacity);
	}
	/****************封装好的功能函数***************************/
	@Override
	public String toString() {
		// 打印形式为: size=5, [99, 88, 77, 66, 55]
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			if(0 != i) string.append(", ");
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
	}
}