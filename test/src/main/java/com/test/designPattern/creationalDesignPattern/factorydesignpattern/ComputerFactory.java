package com.test.designPattern.creationalDesignPattern.factorydesignpattern;

public class ComputerFactory {
    public static Computer getComputer(String type, String ram, String hdd, String cpu){
        if("PC".equalsIgnoreCase(type)) return new PC(ram, hdd);
        else if("Server".equalsIgnoreCase(type)) return new Server(ram, hdd);

        return null;

    }
}
