package com.gameoflife.business.rules;

import com.gameoflife.core.consts.CellState;
import com.gameoflife.core.exceptions.OutOfGridException;
import com.gameoflife.core.models.Cell;
import com.gameoflife.core.models.Grid;
import com.gameoflife.maths.Vector2D;

/**
 * Created by Mehdi on 17/08/2015.
 */
public class UnderPopulationRule implements CellRule {

    private static final int MINIMUM_ALIVE = 2;

    private static UnderPopulationRule instance =  null;
    synchronized  public static UnderPopulationRule getInstance(){
        if(instance==null){
            instance = new UnderPopulationRule();
        }
        return instance;
    }
    private UnderPopulationRule(){

    }

    public Cell simulate(Vector2D cellPosition, Grid grid) {
        try {
            Cell cell = grid.getCellAt(cellPosition);
            if(cell.isAlive() && grid.getLiveNeighboursAt(cellPosition)<MINIMUM_ALIVE){
                return Cell.createDeadCell();
            }
            return cell;

        } catch (OutOfGridException e) {
           //log simulation failed
            return null;
        }

    }
}
