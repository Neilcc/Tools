package com.zcc.puzzle.role;

import com.zcc.puzzle.resource.ResourceManager;

/**
 * Created by Hengyun on 17/02/2017.
 */

public interface IRole extends Runnable {

    IRole bindResource(ResourceManager resourceManager);

}
