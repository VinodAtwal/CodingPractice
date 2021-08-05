package com.test;

abstract class A {
    abstract void e();
}

class D extends A {
    @Override
    void e() {
        System.out.println("d");
    }
}

class C extends A {
    @Override
    void e() {
        System.out.println("c");
    }
}

public class t {


    public static void main(String[] args) throws Exception {
        String s = "";
        A[] a = new D[2];
        a[0] = new C();
        a[1] = new D();


        a[0].e();
        a[1].e();

    }

}
