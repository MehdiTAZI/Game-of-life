package com.gameoflife.business.service;

import com.gameoflife.business.actions.NewGenerationAction;
import com.gameoflife.core.consts.CellState;
import com.gameoflife.core.exceptions.OutOfGridException;
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
    private final int MAX_COL = 3;


    @Test
    public void simulateRepeatedPatternTest() throws OutOfGridException {

        final int nbSteps = 20;

        SimpleGridInput simpleGridInput = new SimpleGridInput(MAX_ROW, MAX_COL, new CellState[][] { { dead, dead,dead }, { alive, alive,alive }, { dead, dead,dead } });
        Grid firstPattern = new Grid(simpleGridInput) ;
        Grid secondPattern = new Grid(new SimpleGridInput(MAX_ROW,MAX_COL,new CellState[][]{{dead,alive,dead},{dead,alive,dead},{dead,alive,dead}}));


        final Grid[] gridSteps = new Grid[] {firstPattern, secondPattern};

        Population population = new Population(simpleGridInput);

        Grid currentGrid = population.getCurrentGrid();

        for(int currentStep = 0 ; currentStep <nbSteps;currentStep++){
            assertThat(currentGrid).isEqualTo(gridSteps[currentStep%2]);
            currentGrid = population.simulateNextGeneration();
        }
    }

    @Test
    public void simulateNothing1PatternTest() throws OutOfGridException {
        final int nbSteps = 3;

        SimpleGridInput simpleGridInput = new SimpleGridInput(MAX_ROW, MAX_COL, new CellState[][] { { dead, alive,dead }, { alive, dead,dead }, { alive, dead,dead } });
        Grid seed = new Grid(simpleGridInput) ;
        Grid firstGeneration = new Grid(new SimpleGridInput(MAX_ROW,MAX_COL,new CellState[][]{{dead,dead,dead},{alive,alive,dead},{dead,dead,dead}}));
        Grid secondGeneration =new Grid(new SimpleGridInput(MAX_ROW,MAX_COL,new CellState[][]{{dead,dead,dead},{dead,dead,dead},{dead,dead,dead}}));

        final Grid[] gridSteps = new Grid[] {seed ,firstGeneration, secondGeneration};

        Population population = new Population(simpleGridInput);


        assertThat(population.getCurrentGrid()).isEqualTo(gridSteps[0]);
        for(int currentStep = 1 ; currentStep <nbSteps;currentStep++){
            Grid currentGrid = population.simulateNextGeneration();
            assertThat(currentGrid).isEqualTo(gridSteps[currentStep]);
        }
    }

    @Test
    public void simulateStablePatternTest() throws OutOfGridException {
        final int nbSteps = 20;

        SimpleGridInput simpleGridInput = new SimpleGridInput(MAX_ROW, MAX_COL, new CellState[][] { { alive, alive,dead }, { alive, dead,dead }, { dead, dead,dead } });
        Grid seed = new Grid(simpleGridInput) ;
        Grid repeatedGenerations = new Grid(new SimpleGridInput(MAX_ROW,MAX_COL,new CellState[][]{{alive,alive,dead},{alive,alive,dead},{dead,dead,dead}}));

        final Grid[] gridSteps = new Grid[] {seed ,repeatedGenerations};

        Population population = new Population(simpleGridInput);

        assertThat(population.getCurrentGrid()).isEqualTo(gridSteps[0]);
        for(int currentStep = 1 ; currentStep <nbSteps;currentStep++){
            Grid currentGrid = population.simulateNextGeneration();
            assertThat(currentGrid).isEqualTo(gridSteps[1]);
        }
    }

    @Test
    public void simulateNothing2PatternTest() throws OutOfGridException {
        final int nbSteps = 3;

        SimpleGridInput simpleGridInput = new SimpleGridInput(MAX_ROW, MAX_COL, new CellState[][] { { dead, dead,alive }, { dead, alive,dead }, { alive, dead,dead } });
        Grid seed = new Grid(simpleGridInput) ;
        Grid firstGeneration = new Grid(new SimpleGridInput(MAX_ROW,MAX_COL,new CellState[][]{{dead,dead,dead},{dead,alive,dead},{dead,dead,dead}}));
        Grid secondGeneration =new Grid(new SimpleGridInput(MAX_ROW,MAX_COL,new CellState[][]{{dead,dead,dead},{dead,dead,dead},{dead,dead,dead}}));

        final Grid[] gridSteps = new Grid[] {seed ,firstGeneration, secondGeneration};

        Population population = new Population(simpleGridInput);

        assertThat(population.getCurrentGrid()).isEqualTo(gridSteps[0]);
        for(int currentStep = 1 ; currentStep <nbSteps;currentStep++){
            Grid currentGrid = population.simulateNextGeneration();
            assertThat(currentGrid).isEqualTo(gridSteps[currentStep]);
        }
    }

}
