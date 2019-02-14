package com.zcc.puzzle.problems;

public class NotifyTest implements Runnable {

    private final Object lock;
    private int num;

    public NotifyTest(Object lock, int num) {
        this.lock = lock;
        this.num = num;
    }

    @Override
    public void run() {
        synchronized(lock){
//            try
//            {
//                lock.wait();
                System.out.println("--- "+num);
//            } catch (InterruptedException e){
//                e.printStackTrace();
//            }
        }
    }

    public static void main(String[] args) {
        // 利用obj 的wait 方法实
        final  Object lock = new Object() ;
        new Thread(new NotifyTest(lock,2)).start();
        new Thread(new NotifyTest(lock,1)).start();

        try {
            // 等待另外两个线程进入wait状态
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock){
            // 请将 lock.notify() 改成lock.notifyAll() 再执行观察二者区别 !!
            System.out.println("--- notify begin");
            lock.notify();
            System.out.println("--- notify end");
        }
        System.out.println("--- end");
    }
}
