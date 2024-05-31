package org.example.c2.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 带哨兵的单链表
 * @author qlk
 */
public class SinglyLinkedListSentinel implements Iterable<Integer> {

    /**
     * 头节点 指向一个哨兵
     */
    private Node head = new Node(Integer.MIN_VALUE, null);

    @Override
    public Iterator<Integer> iterator() {
        // 匿名内部类
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                // 返回当前值,并指向下一个元素
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    // todo: 递归遍历

    /**
     * 节点
     * 添加static,
     * 当内部类相对独立,使用static
     * 当某个内部类使用了外部类的成员变量时(与实例相关),不使用static
     */
    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 头插法
     * 新增节点作为head
     */
    public void addFirst(int value) {
//        this.head.next = new Node(value, this.head.next);
        insert(0, value);
    }

    /**
     * 遍历链表,while
     */
    public void loop1(Consumer<Integer> consumer) {
        Node p = this.head.next;
        while (p != null) {
//            System.out.println(p.value);
            consumer.accept(p.value);
            p = p.next;
        }
    }

    /**
     * 遍历链表,for
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = this.head.next; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    /**
     * 找最后一个元素
     */
    private Node findLast() {
//        if (head == null) {
//            return null;
//        }
        Node p;
        for (p = head; p.next != null; p = p.next) {

        }
        return p;
    }

    /**
     * 尾插法
     */
    public void addLast(int value) {
        Node last = findLast();
//        if (last == null) {
//            addFirst(value);
//            return;
//        }
        last.next = new Node(value, null);
    }

    /**
     * 查找指定索引的节点
     */
    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    /**
     * 查找指定索引的节点的值
     */
    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }
        return node.value;
    }

    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法", index));
    }

    /**
     * 指定位置插入元素
     */
    public void insert(int index, int value) {
        // 头节点
//        if (index == 0) {
////            head = new Node(value, head);
//            addFirst(value);
//            return;
//        }
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    /**
     * 删除第一个节点
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * 按索引删除
     */
    public void remove(int index) {
//        if (index == 0) {
//            removeFirst();
//            return;
//        }
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == null) {
            throw illegalIndex(index);
        }
        prev.next = removed.next;

    }


}
