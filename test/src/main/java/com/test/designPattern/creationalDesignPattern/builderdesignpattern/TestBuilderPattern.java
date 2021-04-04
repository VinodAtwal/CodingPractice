package com.test.designPattern.creationalDesignPattern.builderdesignpattern;

public class TestBuilderPattern {

    public static void main(String[] args) {
        Computer comp =new Computer.ComputerBuilder("5GB","1TB").setBluetoothEnabled(true).build();

    }
}
