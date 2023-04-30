package com.example.dampouring;

import com.example.dampouring.model.vo.TianqiVO;
import com.example.dampouring.util.TianqiUtils;

import java.util.List;
class testD
{
    static synchronized void print(String s)
    {
        System.out.println(s);
    }
}
class testA extends Thread
{
    @Override
    public void run()
    {
        while (true)
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("start......................");
            testD.print("testA,aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        }
    }
}
class testB extends Thread
{
    @Override
    public void run()
    {
        while (true)
        {
            testD.print("testB");
        }
    }
}
public class test {
    public static void main(String[] args) {
        new testB().start();
        new testA().start();
//        Thread t1 = new Print100(0);
//        Thread t2 = new Print100(1);
//        Thread t3 = new Print100(2);
//        t1.start();
//        t2.start();
//        t3.start();
//        Thread t1 = new Print100(0);
//        Thread t2 = new Print100(1);
//        Thread t3 = new Print100(2);
//        t1.start();
//        t2.start();
//        t3.start();
    }
    static class Print100 extends Thread {

        private static final Object lock = new Object();

        private static int count = 0;

        int id;

        public Print100(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while(true)
            {
                synchronized (lock)
                {
                    if(count>=100)
                        break;
                    if(count%3==id)
                    {
                        count++;
                        System.out.println(this.id+">>>"+count);
                    }
                    else
                    {
                        try {
                            lock.notifyAll();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}