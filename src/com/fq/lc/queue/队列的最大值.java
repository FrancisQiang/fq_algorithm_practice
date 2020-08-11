package com.fq.lc.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * @author muXue
 * @date 2020/8/11 15:14
 */
public class 队列的最大值 {

    class MaxQueue {

        Queue<Integer> dataQueue;
        Deque<Integer> maxDeque;

        public MaxQueue() {
            dataQueue = new LinkedList<>();
            maxDeque = new LinkedList<>();
        }

        public int max_value() {
            if (maxDeque.isEmpty()) {
                return -1;
            }
            return maxDeque.peekFirst();
        }

        // 同时维护两个队列 数据队列直接入队
        // 最大队列维护一个单调下降队列 当插入的时候比最后一个大
        // 则将最后一个移除再插入
        public void push_back(int value) {
           dataQueue.offer(value);
           while (!maxDeque.isEmpty()) {
               if (maxDeque.peekLast() < value) {
                   maxDeque.pollLast();
               }
           }
           maxDeque.offerLast(value);
        }

        public int pop_front() {
            // 如果 maxDeque的最后一个和数据队列中的队首一样则一起出队
            // 否则只要出队dataQueue
            if(dataQueue.peek()!=null && maxDeque.peekFirst()!=null){
                if((int)dataQueue.peek()==(int)maxDeque.peekFirst()){
                    maxDeque.pollFirst();
                }
                return (int)dataQueue.poll();
            }else{
                return -1;
            }
        }

    }


}
