package com.gameoflife.core.inputs;

import com.gameoflife.core.models.Cell;

/**
 * Created by Mehdi on 17/08/2015.
 */
public class FileGridInput implements  GridInput {

    public int getWidth() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }

    public Cell[][] getCells() {
        return new Cell[0][];
    }
}
