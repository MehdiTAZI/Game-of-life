package com.gameoflife.business.rules;

import com.gameoflife.core.consts.CellState;
import com.gameoflife.core.exceptions.OutOfGridException;
import com.gameoflife.core.models.Cell;
import com.gameoflife.core.models.Grid;
import com.gameoflife.maths.Vector2D;

/**
 * Created by Mehdi on 17/08/2015.
 */
public class ReproductionRule implements CellRule {

    private static ReproductionRule instance =  null;
    synchronized  public static ReproductionRule getInstance(){
        if(instance==null){
            instance = new ReproductionRule();
        }
        return instance;
    }
    private ReproductionRule(){

    }

    private static final int EXACTLY_ALIVE = 3;
    public boolean simulate(Vector2D cellPosition, Grid grid) {
        try {
            Cell cell = grid.getCellAt(cellPosition);
            if (cell.isDead() && grid.getLiveNeighboursAt(cellPosition) ==  EXACTLY_ALIVE) {
                cell.setCellState(CellState.ALIVE);
                return true;
            }

        } catch (OutOfGridException e) {
            //log simulation failed
        }
        return false;
    }
}
