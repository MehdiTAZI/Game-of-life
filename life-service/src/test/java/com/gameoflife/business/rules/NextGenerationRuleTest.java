package com.gameoflife.business.rules;

import com.gameoflife.core.consts.CellState;
import com.gameoflife.core.exceptions.OutOfGridException;
import com.gameoflife.core.models.Cell;
import com.gameoflife.core.models.Grid;
import com.gameoflife.maths.Vector2D;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Mehdi on 17/08/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class NextGenerationRuleTest {

    private static final Vector2D position = new Vector2D(2,2);

    @Mock
    private Grid grid;

    @Mock
    private Cell cell;

    @InjectMocks
    NextGenerationRule nextGenerationRule;

    @Test
    public void newGenerationRuleSatisfied() throws OutOfGridException {

        Mockito.when(cell.isAlive()).thenReturn(true);

        Mockito.when(grid.getLiveNeighboursAt(position)).thenReturn(2);
        Mockito.when(grid.getCellAt(position)).thenReturn(cell);

        Cell newCell = nextGenerationRule.simulate(position, grid);

        assertThat(newCell).isNotEqualTo(null);
        assertThat(newCell.getCellState()).isEqualTo(CellState.ALIVE);


    }
    @Test
    public void newGenerationRuleUnsatisfied() throws OutOfGridException {

        Mockito.when(cell.isAlive()).thenReturn(false);

        Mockito.when(grid.getLiveNeighboursAt(position)).thenReturn(2);
        Mockito.when(grid.getCellAt(position)).thenReturn(cell);

        assertThat(nextGenerationRule.simulate(position, grid)).isEqualTo(null);
    }

}
