package com.example.multithreadtest.ActiveObject.jucSample.activeobject;

import java.util.concurrent.Future;

public interface ActiveObject {
    Future<String> makeString(int count, char fillchar);

    void displayString(String string);

    void shutdown();
}
