package com.gameoflife.business.service;

import com.gameoflife.business.rules.CellRule;
import com.gameoflife.business.rules.NextGenerationRule;
import com.gameoflife.business.rules.OvercrowdingRule;
import com.gameoflife.business.rules.ReproductionRule;
import com.gameoflife.business.rules.UnderPopulationRule;
import com.gameoflife.business.actions.NewGenerationAction;
import com.gameoflife.core.exceptions.OutOfGridException;
import com.gameoflife.core.inputs.DeadGridInput;
import com.gameoflife.core.inputs.GridInput;
import com.gameoflife.core.models.Cell;
import com.gameoflife.core.models.Grid;
import com.gameoflife.maths.Vector2D;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mehdi on 17/08/2015.
 */
public class Population {

    private List<Grid> gridTimeLine;
    private Grid currentGrid;
    private final GridInput gridInput;

    private CellRule[] rules = { UnderPopulationRule.getInstance(), NextGenerationRule.getInstance(), OvercrowdingRule.getInstance(), ReproductionRule.getInstance()};

    public Grid getCurrentGrid() {
        return currentGrid;
    }

    public Population(GridInput gridInput){
        this.gridInput = gridInput;
        initialize();
    }

    public void initialize(){
        this.gridTimeLine = new LinkedList<Grid>();
        this.gridTimeLine.add(new Grid(this.gridInput));
        this.currentGrid =  this.gridTimeLine.get(0) ;
    }

    public Grid simulateNextGeneration() throws OutOfGridException {

        final int maxRow = gridInput.getWidth();
        final int maxColumn = gridInput.getHeight();

        Grid result = new Grid(new DeadGridInput(maxRow,maxColumn));

        for (int x = 0; x < maxRow; x++) {
            for (int y = 0; y < maxColumn; y++) {
                for(CellRule rule : rules){
                    Cell newCell = rule.simulate(new Vector2D(x, y), currentGrid);
                    if(newCell!=null) {
                        result.setCellAt(x, y, newCell);
                    }
                }
            }
        }
        this.currentGrid = result;
        this.gridTimeLine.add(result);
        return result;
    }


    // todo : to fix
    public void simulateAll(NewGenerationAction newGenerationAction){

        final int maxRow =0;
        final int maxColumn = 0;

        for (int x = 0; x < maxRow; x++) {
            for (int y = 0; y < maxColumn; y++) {
                for(CellRule rule : rules){
                    rule.simulate(new Vector2D(x,y),null);
                }
                if(newGenerationAction !=null){
                    newGenerationAction.onNewGenerationCreated(null);
                }

            }
        }
    }

}
