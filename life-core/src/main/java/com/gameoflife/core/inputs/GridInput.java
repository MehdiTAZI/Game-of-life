package com.gameoflife.core.inputs;

import com.gameoflife.core.models.Cell;

/**
 * Created by Mehdi on 17/08/2015.
 */
public interface GridInput {
    public int getWidth();
    public int getHeight();
    public Cell[][] getCells();
}
