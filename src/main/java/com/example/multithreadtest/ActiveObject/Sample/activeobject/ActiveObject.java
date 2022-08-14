package com.example.multithreadtest.ActiveObject.Sample.activeobject;

public interface ActiveObject {
    Result<String> makeString(int count, char fillchar);

    void displayString(String string);
}
