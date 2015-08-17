package com.gameoflife.business.service;

import com.gameoflife.business.actions.NewGenerationAction;
import com.gameoflife.core.consts.CellState;
import com.gameoflife.core.inputs.SimpleGridInput;
import com.gameoflife.core.models.Grid;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Mehdi on 17/08/2015.
 */

// todo : move project spring
// @RunWith(SpringJUnit4ClassRunner.class)
public class PopulationTestIT {


    private final CellState dead = CellState.DEAD;
    private final CellState alive = CellState.ALIVE;
    private final int MAX_ROW = 3;
    private final int MAX_COL = 2;

    @Test
    public void simulateAllPattern1Test(){
        final int nbSteps = 3;

        SimpleGridInput simpleGridInput = new SimpleGridInput(MAX_ROW, MAX_COL, new CellState[][] { { dead, alive }, { alive, dead }, { alive, dead } });
        Grid seed = new Grid(simpleGridInput) ;
        Grid firstGeneration = new Grid(new SimpleGridInput(MAX_ROW,MAX_COL,new CellState[][]{{dead,dead},{alive,alive},{dead,dead}}));
        Grid secondGeneration =new Grid(new SimpleGridInput(MAX_ROW,MAX_COL,new CellState[][]{{dead,dead},{dead,dead},{dead,dead}}));

        final Grid[] gridSteps = new Grid[] {seed ,firstGeneration, secondGeneration};

        Population population = new Population(simpleGridInput);


        assertThat(population.getCurrentGrid()).isEqualTo(gridSteps[0]);
        for(int currentStep = 1 ; currentStep <nbSteps;currentStep++){
            Grid currentGrid = population.simulateNextGeneration();
            assertThat(currentGrid).isEqualTo(gridSteps[currentStep]);
        }



    }

}
