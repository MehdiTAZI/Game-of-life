package com.gameoflife.business.actions;

import com.gameoflife.core.models.Grid;

/**
 * Created by Mehdi on 17/08/2015.
 */
public interface NewGenerationAction {
    void onNewGenerationCreated(Grid grid);
}
