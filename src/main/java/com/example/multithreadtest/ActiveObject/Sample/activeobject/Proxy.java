package com.example.multithreadtest.ActiveObject.Sample.activeobject;

/**
 * Proxy角色
 * 将请求转换为 MethodRequest 角色
 *
 * 将activeObject.makeString()转换为MakeStringRequest对象
 * 此时可以将请求放入SchedulerThread的任务队列ActivationQueue中
 * activeObject.displayString()同理
 */
class Proxy implements ActiveObject {
    private final SchedulerThread scheduler;
    private final Servant servant;

    public Proxy(SchedulerThread scheduler, Servant servant) {
        this.scheduler = scheduler;
        this.servant = servant;
    }

    public Result<String> makeString(int count, char fillchar) {
        FutureResult<String> future = new FutureResult<>();
        scheduler.invoke(new MakeStringRequest(servant, future, count, fillchar));
        return future;
    }

    public void displayString(String string) {
        scheduler.invoke(new DisplayStringRequest(servant, string));
    }
}
