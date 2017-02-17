package com.zcc.puzzle.resource;

/**
 * Created by Hengyun on 17/02/2017.
 */

public class ResourceManager {
    private final int MAX_SIZE;
    private final Object MUTEX = new Object();
    private ResourcePool resourcePool;

    public ResourceManager(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        resourcePool = new ResourcePool();
    }

    public int addOneGoodsBlock() {
        while (true) {
            synchronized (MUTEX) {
                if (resourcePool.getmGoodsAmount() < MAX_SIZE) {
                    return resourcePool.addOneGoods();
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
                if (resourcePool.getmGoodsAmount() > 0) {
                    return resourcePool.useOneGoods();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ResourcePool {

        private volatile int mGoodsAmount = 0;

        ResourcePool() {
        }

        int addOneGoods() {
            ++mGoodsAmount;
            System.out.print("one goods added " + "now we have" + mGoodsAmount + "\n");
            return mGoodsAmount;
        }

        int useOneGoods() {
            --mGoodsAmount;
            System.out.print("one goods used " + "now we have" + mGoodsAmount + "\n");
            return mGoodsAmount;
        }

        int getmGoodsAmount() {
            return mGoodsAmount;
        }
    }
}
