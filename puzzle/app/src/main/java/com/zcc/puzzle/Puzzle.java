package com.zcc.puzzle;

import com.zcc.puzzle.resource.ResourceManager;
import com.zcc.puzzle.role.Consumer;
import com.zcc.puzzle.role.Producer;

/**
 * Created by Hengyun on 2017/1/2.
 */

public class Puzzle {


    public static void main(String[] args) {
//        simulate(7, 9);
//        simulate(9, 7);
        simulate(7, 7);
    }

    private static void simulate(int producerNumb, int consumerNumb) {
        ResourceManager resourceManager = new ResourceManager(20);
        for (int i = 0; i < producerNumb; i++) {
            new Thread(new Producer(i).bindResource(resourceManager)).start();
        }
        for (int i = 0; i < consumerNumb; i++) {
            new Thread(new Consumer(i).bindResource(resourceManager)).start();
        }
    }


}

