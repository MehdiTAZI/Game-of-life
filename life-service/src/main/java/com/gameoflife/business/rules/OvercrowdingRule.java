package com.gameoflife.business.rules;

import com.gameoflife.core.consts.CellState;
import com.gameoflife.core.exceptions.OutOfGridException;
import com.gameoflife.core.models.Cell;
import com.gameoflife.core.models.Grid;
import com.gameoflife.maths.Vector2D;

/**
 * Created by Mehdi on 17/08/2015.
 */
public class OvercrowdingRule implements CellRule {

    private static OvercrowdingRule instance =  null;
    synchronized  public static OvercrowdingRule getInstance(){
        if(instance==null){
            instance = new OvercrowdingRule();
        }
        return instance;
    }
    private OvercrowdingRule(){

    }

    private static final int MAXIMUM_ALIVE = 3;
    public boolean simulate(Vector2D cellPosition, Grid grid) {
        try {
            Cell cell = grid.getCellAt(cellPosition);
            if (cell.isAlive() && grid.getLiveNeighboursAt(cellPosition) >   MAXIMUM_ALIVE) {
                cell.setCellState(CellState.DEAD);
                return true;
            }

        } catch (OutOfGridException e) {
            //log simulation failed
        }
        return false;
    }
}
