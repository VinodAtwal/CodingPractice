package com.test.designPattern.creationalDesignPattern.abstractfactorydesignpattern;

import com.test.designPattern.creationalDesignPattern.factorydesignpattern.Computer;

public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}
