package com.gameoflife.core.inputs;

import com.gameoflife.core.consts.CellState;
import com.gameoflife.core.models.Cell;

/**
 * Created by Mehdi on 17/08/2015.
 */
public class SimpleGridInput implements  GridInput {

    private int width;
    private int height;
    private Cell[][] cells;

    public SimpleGridInput(final int width,final int height,CellState[][] cellStates){
        //check that cellstates width and heigh are equivalent to parameters
        this.width=width;
        this.height=height;
        this.cells = new Cell[width][height];
        for(int row =0;row <width;row++){
            for(int col =0;col <height;col++){
                if(row >= 0 && row < cellStates.length && col >=0 && col < cellStates[row].length) {
                    this.cells[row][col] = new Cell(cellStates[row][col]);
                }
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
