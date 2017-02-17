package com.zcc.puzzle.resource;

/**
 * Created by Hengyun on 17/02/2017.
 */

public class ResourceManager {

    private final int MAX_SIZE;
    private final Object MUTEX = new Object();
    private volatile int mGoodsAmount = 0;

    public ResourceManager(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    public int addOneGoodsBlock() {
        while (true) {
            synchronized (MUTEX) {
                if (mGoodsAmount < MAX_SIZE) {
                    ++mGoodsAmount;
                    System.out.print("one goods added " + "now we have" + mGoodsAmount + "\n");
                    return mGoodsAmount;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int useOneGoodsBlock() {
        while (true) {
            synchronized (MUTEX) {
                if (mGoodsAmount > 0) {
                    --mGoodsAmount;
                    System.out.print("one goods used " + "now we have" + mGoodsAmount + "\n");
                    return mGoodsAmount;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
