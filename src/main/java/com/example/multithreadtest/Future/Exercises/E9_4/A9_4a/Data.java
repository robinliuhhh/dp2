package com.example.multithreadtest.Future.Exercises.E9_4.A9_4a;

import java.util.concurrent.ExecutionException;

public interface Data {
    String getContent() throws ExecutionException;
}
