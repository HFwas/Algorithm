package com.hf.linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// 创建节点
		HeroNode2 heroNode1 = new HeroNode2(1, "ss", "及时雨");
		HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "舞麒麟");
		HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
		HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");
		//创建类的对象
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		
		doubleLinkedList.addByOrder(heroNode1);
		doubleLinkedList.addByOrder(heroNode2);
		doubleLinkedList.addByOrder(heroNode4);
		doubleLinkedList.addByOrder(heroNode3);
		System.out.println("添加之后的双向链表：");
		doubleLinkedList.list();
		/*//修改节点信息
		HeroNode2 heroNode22 = new HeroNode2(1, "ssss", "技术");
		System.out.println("修改之后的双向链表");
		doubleLinkedList.update(heroNode22);
		doubleLinkedList.list();
		System.out.println("删除节点之后的双向链表：：");
		doubleLinkedList.delete(4);
		doubleLinkedList.delete(2);
		doubleLinkedList.list();*/
		
	}

}

// 创建一个双向链表的类
class DoubleLinkedList {

	// 先初始化一个头节点，头节点不动，不存放具体的数据
	private HeroNode2 head = new HeroNode2(0, "", "");

	// 返回头节点
	public HeroNode2 getHead() {
		return head;
	}
	
	
	//代码有问题
	//双向链表第二种添加方式，按照顺序添加
	public void addByOrder(HeroNode2 heroNode) {
		//因为头节点不动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
		HeroNode2 temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {//说明temp已经在链表的最后
				break;
			}
			if (temp.no > heroNode.no) {//位置找到，就在temp的后面插入
				break;
			}else if (temp.no == heroNode.no) {//说明希望添加到的heroNode的编号依然存在
				flag = true;//说明编号已经存在
				break;
			}
			temp = temp.next;//后移，遍历当前链表
		}
		//判断flag
		if (flag) {//不能添加，说明账号存在
			System.out.printf("准备插入的英雄的百年好%d 已经存在了，不能加入\n",heroNode.no);
		}else {
			//插入到链表中，temp的后面
			heroNode.next = temp.next;
			temp.next.pre =heroNode;
			heroNode.pre = temp;
			temp.next = heroNode;
		}
	}
	

	// 添加一个节点到双向链表最后
	public void add(HeroNode2 heroNode) {

		// 因为head节点不能动，因此我们需要一个辅助遍历temp
		HeroNode2 temp = head;
		// 遍历链表，找到最后
		while (true) {
			// 找到链表的最后
			if (temp.next == null) {
				break;
			}
			// 如果没有找到最后。将temp后移
			temp = temp.next;
		}
		// 当退出while循环时，temp就指向了链表的最后
		// 形成一个双向链表
		temp.next = heroNode;
		heroNode.pre = temp;
	}

	/**
	 * 修改一个节点的内容，可以看到双向链表的节点的而几点内容修改和单项链表一样 知识节点类型改成HeroNode2
	 * @param newHeroNode
	 */
	public void update(HeroNode2 newHeroNode) {
		// 判断为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 找到需要修改的节点，根据no编号
		// 定义一个辅助变量
		HeroNode2 temp = head;
		boolean flag = false;// 表示是否找到该节点
		while (true) {
			if (temp == null) {
				break;// 已经遍历完链表了
			}
			if (temp.no == newHeroNode.no) {
				// 找到
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// 根据flag判断是否找到要修改的
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickNmae = newHeroNode.nickNmae;
		} else {// 没有找到
			System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
		}
	}

	/**
	 * 从双向链表中删除一个节点，说明 对于双向链表，我们可以直接找到要删除的这个节点 找到后，自我删除即可
	 */
	public void delete(int no) {

		// 判断当前链表
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}

		HeroNode2 temp = head.next;// 标志指针
		boolean flag = false;// 标志是否找到待删除节点的
		while (true) {
			if (temp == null) {// 已经到链表的最后
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;// temp后移，遍历
		}

		// 判断flag
		if (flag) {// 找到
			// 可以删除
			// temp.next = temp.next.next;单链表删除
			temp.pre.next = temp.next;
			// 这里的代码有问题
			// 如果是最后一个节点，下面这句话就不需要加
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.printf("要删除的%d节点不存在\n", no);
		}
	}

	// 显示链表【遍历】
	public void list() {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点不能东莞，因此我们需要一个辅助白能量来遍历
		HeroNode2 temp = head.next;
		while (true) {
			// 判断是否到链表最后
			if (temp == null) {
				break;
			}
			// 输出节点的信息
			System.out.println(temp);
			// 将temp后移，一定小心
			temp = temp.next;
		}
	}
}

// 定义HeroNode,每一个HeroNode对象就是一个节点
class HeroNode2 {

	public int no;
	public String name;
	public String nickNmae;
	public HeroNode2 next;// 指向下一个节点
	public HeroNode2 pre;

	// 构造器
	public HeroNode2(int no, String hName, String hNickName) {
		this.no = no;
		this.name = hName;
		this.nickNmae = hNickName;
	}

	// 重写
	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickNmae=" + nickNmae + "]";
	}

}
