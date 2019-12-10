package com.zcc.puzzle.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cc on 2019-12-10.
 */
public class PAndC {

    public static void main(String[] args) {
        final Queue<Product> q = new LinkedList<Product>();
        final Object mutex = new Object();
        final ProductFactory<Product> factory = new ProductFactory<Product>() {
            @Override
            public Product create() {
                return new Product();
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(new Producer<Product>(mutex, q, factory)).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer<Product>(mutex, q)).start();
        }

    }

    public interface ProductFactory<T extends Product> {

        public T create();
    }

    public static class Producer<T extends Product> extends Worker {
        private final Object mToken;
        private final Queue<T> mQueue;
        private final ProductFactory<T> mProductFactory;

        public Producer(Object token, Queue<T> queue, ProductFactory<T> productFactory) {
            this.mToken = token;
            this.mQueue = queue;
            this.mProductFactory = productFactory;
        }


        @Override
        public void doWork() {
            synchronized (mToken) {
                mQueue.add(mProductFactory.create());
                try {
                    mToken.notifyAll();
                } catch (Exception e) {
                }
            }
        }


    }

    public static class Consumer<T extends Product> extends Worker {

        private final Object mToken;
        private final Queue<T> mQueue;

        public Consumer(Object token, Queue<T> queue) {
            this.mToken = token;
            this.mQueue = queue;
        }

        @Override
        public void doWork() {
            synchronized (mToken) {
                if (mQueue.size() == 0) {
                    try {
                        mToken.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    // consume
                    T obj = mQueue.poll();
                    obj.consume();
                }
            }
        }

    }

    public static class Product {

        public void consume() {

        }
    }

    public static abstract class Worker implements Runnable {

        protected boolean quit = false;

        public abstract void doWork();

        void quit() {
            quit = true;
        }

        public void run() {
            while (!quit) {
                doWork();
            }
        }
    }
}
