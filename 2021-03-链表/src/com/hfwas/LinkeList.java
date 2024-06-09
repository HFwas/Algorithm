package com.hfwas;

/**
 * @ClassName LinkeList
 * @Description 链表的自实现
 * @Author hfwas
 * @Date: 4:13 下午
 * @Version: 1.0
 **/
public class LinkeList<E> extends AbstractList<E>{
    private Node<E> first;
    private Node<E> last;
    private static class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;
        public Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }
}
