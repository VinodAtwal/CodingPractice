package com.test.threads;

import static java.lang.Thread.sleep;
import static java.lang.Thread.yield;

class ThreadA extends Thread{
    public void run() {
        yield();
        System.out.println("Start Thread B ....");
        for(int j = 1; j <= 5; j++) {
            System.out.println("From Thread B: j = "+ j);
            if (j==2) stop();
        }
        System.out.println("... Exit Thread B");
    }
}
class ThreadB extends Thread {
    public void run( ) {
        for(int j = 1; j <= 5; j++) {
            System.out.println("From Thread B with j= "+2* j);
        }
        System.out.println("Exiting from Thread B ...");
    }
}
class ThreadC extends Thread{
    public void run( ) {
        for(int k = 1; k <= 5; k++) {
            System.out.println("From Thread C with k = "+ (2*k-1));
        }
        System.out.println("Exiting from Thread C ...");
    }
}
class ThreadY implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("Thread X with i = "+ -1*i);
        }
        System.out.println("Exiting Thread X ...");
    }
}

public class Threaddemo {
    public static void main(String args[]) {
        ThreadA a = new ThreadA();
//        ThreadB b = new ThreadB();
//        ThreadC c = new ThreadC();
//        a.start();
//        b.start();
//        c.start();
//         ThreadY y= new ThreadY();
//         Thread t= new Thread(y);
//         t.run();
//         Thread lambda = new Thread(()->{  for(int k = 1; k <= 5; k++)
//             System.out.println("From Thread C with k = "+ (2*k-1));});
//         lambda.run();

        Thread t1 = new Thread(()->{
            System.out.println("Start thread t1 ");
            for(int i = 1; i <= 5; i++) {
                System.out.println("From Thread t1: i = "+ i);
                if (i==1) yield();

            }
            System.out.println("... Exit Thread t1");
        });
        Thread t3 = new Thread(()->{
            System.out.println("Start Thread t3 ....");
            for(int k = 1; k <= 5; k++) {
                System.out.println("From Thread t3: j = "+ k);
//                if (k==3){
//                    try{
//                        yield();
//                       // sleep(1000);
//                    }catch(Exception e){}
//                }
            }
            System.out.println("... Exit Thread t3");
        });
        t3.setPriority(Thread.MAX_PRIORITY);
        a.setPriority(Thread.MIN_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
//        a.start();
        t3.start();


        System.out.println("... Multithreading is over ");
    }
}
