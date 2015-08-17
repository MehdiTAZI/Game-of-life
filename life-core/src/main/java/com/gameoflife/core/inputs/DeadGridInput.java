package com.gameoflife.core.inputs;

import com.gameoflife.core.models.Cell;

/**
 * Created by Mehdi on 17/08/2015.
 */
public class DeadGridInput implements  GridInput {

    private int width;
    private int height;
    private Cell[][] cells;

    public DeadGridInput(final int width,final int height){
        this.width=width;
        this.height=height;
        this.cells = new Cell[width][height];
        for(int row =0;row <width;row++){
            for(int col =0;col <height;col++){
                this.cells[row][col]= Cell.createDeadCell();
            }
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Cell[][] getCells() {
        return this.cells;
    }
}
