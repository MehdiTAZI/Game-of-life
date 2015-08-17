package com.gameoflife.core.models;

import com.gameoflife.core.consts.CellState;

/**
 * Created by Mehdi on 17/08/2015.
 */
public class Cell {

    private CellState cellState;

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public boolean isAlive(){
        return this.cellState.equals(CellState.ALIVE);
    }
    public boolean isDead(){
        return this.cellState.equals(CellState.DEAD);

    }

    public static final Cell createAliveCell(){
        return new Cell(CellState.ALIVE);
    }
    public static final Cell createDeadCell(){return new Cell(CellState.DEAD);}

    public Cell(CellState cellState){
        this.cellState = cellState;
    }

    @Override
    public String toString() {
        return isAlive()?"O":"X";
    }
}
