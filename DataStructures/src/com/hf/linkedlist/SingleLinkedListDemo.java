package com.hf.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		//进行测试
		//创建节点
		HeroNode node1 = new HeroNode(1, "ss", "及时雨");
		HeroNode node2 = new HeroNode(2, "卢俊义", "舞麒麟");
		HeroNode node3 = new HeroNode(3, "吴用", "智多星");
		HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
	

		SingleLinkedList list = new SingleLinkedList();
		//加入
//		list.add(node1);
//		list.add(node2);
//		list.add(node3);
//		list.add(node4);
		
		//加入按照编号顺序
		list.addByOrder(node1);
		list.addByOrder(node4);
		list.addByOrder(node2);
		list.addByOrder(node3);
		
		/*//测试一下单链表的反转
		System.out.println("反转前的单链表：：");
		list.list();
		System.out.println("反转后的单链表的===");
		reverseList(list.getHead());
		list.list();*/
		System.out.println("打印之前的的单链表：：：");
		list.list();
		System.out.println("打印之后的单链表");
		reversePrint(list.getHead());
		
		/*//修改前的链表
		list.list();
		
		//测试修改节点的代码
		HeroNode newHeroNode = new HeroNode(2, "小订单", "xdd");
		list.update(newHeroNode);
		//修改之后显示列表
		list.list();
		
		//删除节点后的
		list.delete(1);
		System.out.println("删除之后的节点");
		list.list();
		
		//求单链表中有效节点的个数
		System.out.println("有效节点数："+getLength(list.getHead()));
		
		//测试一下，，查找单链表中倒数第k个节点
		HeroNode res = findLastIndexNode(list.getHead(), 1);
		System.out.println("res:"+res);*/
		
	}
	
	//合并两个有序的单链表，合并之后依然是有序的
	
	
	//方式二
	//可以利用这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的结果
	public static void reversePrint(HeroNode head) {
		if (head.next == null) {
			return ;//空链表，不打印
		}
		//创建一个栈，将各个节点压入栈
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		//将链表的所有节点压入栈
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;//cur后移，这样就可以压入下一个节点
		}
		//将栈中的节点进行打印，pop出战
		while (stack.size() > 0) {
			System.out.println(stack.pop());//stack的特点是先进后出
		}
	}
	
	
	//将单链表反转
	public static void reverseList(HeroNode head) {
		//如果当前链表为空，或者只有一个节点，无需反转，直接返回
		if (head.next == null || head.next.next == null) {
			return ;
		}
		//定义一个辅助的指针（变量），帮助我们遍历原来的链表
		HeroNode cur = head.next;
		HeroNode next = null;
		HeroNode reverseHead = new HeroNode(0, "", "");
		//遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
		//动脑筋
		while (cur != null) {
			next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
			cur.next = reverseHead.next;//将cur的下一个节点想新的链表的最前端
			reverseHead.next = cur;//将cur的下一个节点指向新的链表的最前端
			cur = next;//让cur后移
		}
		//将head.next指向reverseHead.next，实现单链表的反转
		head.next = reverseHead.next;
	}
	
	//查找单链表中倒数第k个节点
	/**
	 * 思路：编写一个方法，接受head节点，同时接收一个index，index表示是倒数第index个节点
	 * 先把链表从头到尾遍历，得到链表的总的长度getLength,得到size后，我们从链表的第一个开始
	 * 遍历(size-length)个，就可以得到，如果找到，则返回该节点，否则返回null
	 */
	public static HeroNode findLastIndexNode(HeroNode head,int index) {
		//判断如果链表为空，返回为Null
		if (head.next == null) {
			return null;
		}
		//第一个遍历得到链表的长度（节点个数）
		int size = getLength(head);
		//第二次遍历size-index 位置，就是我们倒数的第K个节点
		//先做一个index的校验
		if (index <= 0 || index > size) {
			return null;
		}
		//定义给辅助变量，for 循环定位到倒数的index
		HeroNode cur = head.next;//
		for (int i = 0; i < size - index; i++) {
			cur = cur.next;
		}
		return cur;
	}
	
	
	
	//方法：获取到单链表的节点的个数（如果是带头节点的链表，需要不统计头节点）
	/**
	 * @param head链表的头节点
	 * @return 返回的就是有效节点的个数
	 */
	public static int getLength(HeroNode head) {
		if (head.next == null) {//空链表
			return 0;
		}
		int length = 0;
		//定义一个辅助变量，这里我们没有统计头节点
		HeroNode cur = head.next;
		while (cur != null) {
			length++;
			cur=cur.next;
		}
		return length ;
	}
}

//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList{
	//先初始化一个头节点，头节点不动，不存放具体的数据
	private HeroNode head = new HeroNode(0, "", "");
	
	
	//返回头节点
	public HeroNode getHead() {
		return head;
	}

	//添加节点到单项链表
	//思路，当不考虑编号顺序时
	//1.找到当前链表的最后节点
	//2.将最后这个节点的next指向新的节点
	public void add(HeroNode heroNode) {
		
		//因为head节点不能动，因此我们需要一个辅助遍历temp
		HeroNode temp = head;
		//遍历链表，找到最后
		while (true) {
			//找到链表的最后
			if (temp.next == null) {
				break;
			}
			//如果没有找到最后。将temp后移
			temp = temp.next;
		}
		//当退出while循环时，temp就指向了链表的最后
		//将最后这个节点的next指向新的节点
		temp.next = heroNode;
	}
	
	//第二种方式在添加英雄时，根据排名将银熊插入到指定位置
	//如多有这个排名，则添加失败，并给出显示
	public void addByOrder(HeroNode heroNode) {
		//因为头节点不动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
		//因为单链表，因为我们找的temp时位于添加位置的第一个节点，否则插入不了
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {//说明temp已经在链表的最后
				break;
			}
			if (temp.next.no > heroNode.no) {//位置找到，就在temp的后面插入
				break;
			}else if (temp.next.no == heroNode.no) {//说明希望添加到的heroNode的编号依然存在
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
			temp.next =heroNode;
		}
	}
	
	//修改节点的信息，根据no的编号来修改，即no编号不能改
	//说明
	//1.根据newHeroNode的 no来修改即可
	public void update(HeroNode newHeroNode) {
		//判断为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		//找到需要修改的节点，根据no编号
		//定义一个辅助变量
		HeroNode temp = head;
		boolean flag= false;//表示是否找到该节点
		while (true) {
			if (temp == null) {
				break;//已经遍历完链表了
			}
			if (temp.no == newHeroNode.no) {
				//找到
				flag = true;
				break;
			}
			temp = temp.next;
		}
		//根据flag判断是否找到要修改的
		if (flag) {
			temp.name =newHeroNode.name;
			temp.nickNmae = newHeroNode.nickNmae;
		}else {//没有找到
			System.out.printf("没有找到编号%d的节点，不能修改\n",newHeroNode.no);
		}
	}
	
	//删除节点
	//思路
	//1.head不能动，因此我们需要一个temp辅助九二点找到待删除节点的第一个节点
	//2.说明我们在比较时，是temp.next.no和 需要删除的节点的no比较
	public void delete(int no) {
		HeroNode  temp = head;
		boolean flag = false;//标志是否找到待删除节点的
		while (true) {
			if (temp.next == null) {//已经到链表的最后
				break;
			}
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;//temp后移，遍历
		}
		
		//判断flag
		if (flag) {//找到
			//可以删除
			temp.next = temp.next.next;
		}else {
			System.out.printf("要删除的%d节点不存在\n",no);
		}
	}
	
	//显示链表【遍历】
	public void list() {
		//判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		//因为头节点不能东莞，因此我们需要一个辅助白能量来遍历
		HeroNode temp = head.next;
		while (true) {
			//判断是否到链表最后
			if (temp == null) {
				break;
			}
			//输出节点的信息
			System.out.println(temp);
			//将temp后移，一定小心
			temp = temp.next;
		}
	}
}

//定义HeroNode,每一个HeroNode对象就是一个节点
class HeroNode{
	
	public int no;
	public String name;
	public String nickNmae;
	public HeroNode next;//指向下一个节点
	//构造器
	public HeroNode(int no,String hName,String hNickName) {
		this.no=no;
		this.name=hName;
		this.nickNmae=hNickName;
	}
	
	//重写
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickNmae=" + nickNmae  + "]";
	}
	
	
}
