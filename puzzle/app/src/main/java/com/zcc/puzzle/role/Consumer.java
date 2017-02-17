package com.zcc.puzzle.role;

import com.zcc.puzzle.resource.ResourceManager;

/**
 * Created by Hengyun on 17/02/2017.
 */

public class Consumer implements IRole {

    private int tag = 0;
    private ResourceManager resourceManager;

    public Consumer(int tag) {
        this.tag = tag;
    }

    @Override
    public IRole bindResource(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
        return this;
    }

    @Override
    public void run() {

        while (true) {
            System.out.print("Consumer" + tag + "isRunning \n");
            resourceManager.useOneGoodsBlock();
            System.out.print("Consumer" + tag + "Run finished \n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
