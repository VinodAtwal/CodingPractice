package com.test.designPattern.creationalDesignPattern.singleton;

/*if multiple threads are inside the if condition at the same time.
It will destroy the singleton pattern and both threads will get the
different instances of the singleton class*/
public class LazyInitializedSingleton {
    private LazyInitializedSingleton() {
    }

    private static  LazyInitializedSingleton  instance ;
    public static LazyInitializedSingleton getInstance(){
        if(instance== null) {instance = new LazyInitializedSingleton();}
        return instance;
    }

}
