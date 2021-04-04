package com.test.designPattern.creationalDesignPattern.factorydesignpattern;

public class PC  extends Computer{
    private String Ram;
    private String HDD;

    public PC(String ram, String HDD) {
        Ram = ram;
        this.HDD = HDD;
    }

    @Override
    public String getRam() {
        return null;
    }

    @Override
    public String getHDD() {
        return null;
    }
}
