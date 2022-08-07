package com.example.multithreadtest.Future.Exercises.E9_4.A9_4b;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ExecutionException;

/**
 * 和jucSample相比只是没有捕获ExecutionException
 */
public class FutureData extends FutureTask<RealData> implements Data {
    public FutureData(Callable<RealData> callable) {
        super(callable);
    }

    public String getContent() throws ExecutionException {
        String string = null;
        try {
            string = get().getContent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } /*catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        return string;
    }
}
