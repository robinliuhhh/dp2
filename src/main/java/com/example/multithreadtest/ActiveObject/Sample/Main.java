package com.example.multithreadtest.ActiveObject.Sample;

import com.example.multithreadtest.ActiveObject.Sample.activeobject.ActiveObject;
import com.example.multithreadtest.ActiveObject.Sample.activeobject.ActiveObjectFactory;

/**
 * MakerClientThread -> Proxy -> SchedulerThread -> MakeStringRequest -> Servant
 * SchedulerThread启动新线程实际处理请求 实现了异步操作
 *
 * “方法的调度”部分运行于Client角色的线程中 “方法的执行”部分运行于Scheduler角色的线程中
 */
public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread("Alice", activeObject).start();
        new MakerClientThread("Bobby", activeObject).start();
        new DisplayClientThread("Chris", activeObject).start();
    }
}
