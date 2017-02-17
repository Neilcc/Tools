package com.zcc.puzzle.role;

import com.zcc.puzzle.resource.ResourceManager;

/**
 * Created by Hengyun on 17/02/2017.
 */

public class Producer implements IRole {

    private int tag = 0;
    private ResourceManager resourceManager;

    public Producer(int tag) {
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
            System.out.print("Producer" + tag + "isRunning \n");
            resourceManager.addOneGoodsBlock();
            System.out.print("Producer" + tag + "Run finished \n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
