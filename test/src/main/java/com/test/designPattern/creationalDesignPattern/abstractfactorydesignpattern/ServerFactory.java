package com.test.designPattern.creationalDesignPattern.abstractfactorydesignpattern;

import com.test.designPattern.creationalDesignPattern.factorydesignpattern.Computer;
import com.test.designPattern.creationalDesignPattern.factorydesignpattern.Server;

public class ServerFactory implements ComputerAbstractFactory{
    private String Ram;
    private String HDD;

    public ServerFactory(String ram, String HDD) {
        Ram = ram;
        this.HDD = HDD;
    }

    @Override
    public Computer createComputer() {
        return new Server(Ram,HDD);
    }
}
