package com.gameoflife.business.rules;

import com.gameoflife.core.consts.CellState;
import com.gameoflife.core.exceptions.OutOfGridException;
import com.gameoflife.core.models.Cell;
import com.gameoflife.core.models.Grid;
import com.gameoflife.maths.Vector2D;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Mehdi on 17/08/2015.
 */
public class NextGenerationRule implements CellRule {

    private static NextGenerationRule instance =  null;
    synchronized  public static NextGenerationRule getInstance(){
        if(instance==null){
            instance = new NextGenerationRule();
        }
        return instance;
    }
    private NextGenerationRule(){

    }

    private static final List<Integer> WITHIN_VALUES = Lists.newArrayList(2,3);
    public Cell simulate(Vector2D cellPosition, Grid grid) {
        try {
            Cell cell = grid.getCellAt(cellPosition);
            if(cell.isAlive() && WITHIN_VALUES.contains(grid.getLiveNeighboursAt(cellPosition))){
                return  Cell.createAliveCell();
            }
            return cell;
        } catch (OutOfGridException e) {
            //log simulation failed
            return null;
        }

    }
}
