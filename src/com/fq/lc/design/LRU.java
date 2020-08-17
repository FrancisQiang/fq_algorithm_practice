package com.fq.lc.design;

import java.util.HashMap;

/**
 * @author lgq
 * @date 2020/8/16
 */
public class LRU {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();

    private int count;
    private int capacity;

    private DLinkedNode head, tail;

    public LRU(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        head.pre = null;
        tail = new DLinkedNode();
        tail.next = null;
        // 头尾相连
        head.next = tail;
        tail.pre = head;
    }

    private void add(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    private void removeToHead(DLinkedNode node) {
        removeNode(node);
        add(node);
    }

    private DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            add(newNode);
            count++;
            if (count > capacity) {
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
        } else {
            node.value = value;
            this.removeToHead(node);
        }
    }


}
