package com.example.multithreadtest.GuardedSuspension.Sample;

import java.util.Queue;
import java.util.LinkedList;

/**
 * GuardedObject 被守护的对象
 * queue是共享资源 所以getRequest putRequest都声明为synchronized方法
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();

    // GuardedMethod 若守护条件成立 可以立即执行 当守护条件不成立时 就要进行等待
    // 1.
    // getRequest()的目标是queue.remove()
    // 执行queue.remove()必须要满足的条件为queue.peek() != null
    // 这种必须要满足的条件就称为Guarded Suspension模式的守护条件 guard condition
    public synchronized Request getRequest() {
        // 2.
        // while条件表达式是守护条件的非运算
        // 也就是说守护条件不成立时 绝对不会继续执行while之后的语句queue.remove()
        while (queue.peek() == null) {
            try {
                // 3.1 守护条件不成立 线程等待被notify/notifyAl
                // 如果一个请求都没有 就一直等待 直到其他某个线程执行putRequest
                // 线程等待的是实例状态发生变化 守护条件成立的时刻
                // 正在wait的线程如果不被notify/notifyAll 便会一直待在等待队列中
                // 正在wait的线程每次被notify/notifyAl时都会检查守护条件
                wait(); // 下一步执行while (queue.peek() == null)
            } catch (InterruptedException e) {
            }
        }
        // 3.2 守护条件成立
        return queue.remove();
    }

    // StateChangingMethod 改变守护条件
    public synchronized void putRequest(Request request) {
        queue.offer(request);
        // 守护条件queue.peek() != null成立 通知wait线程
        notifyAll();
    }
}
