package com.test.designPattern.creationalDesignPattern.singleton;

public class StaticBlockSingleton {
    private static StaticBlockSingleton staticBlockSingleton;

    private StaticBlockSingleton() {
    }

    static {
        try {
            staticBlockSingleton = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return staticBlockSingleton;
    }
}
