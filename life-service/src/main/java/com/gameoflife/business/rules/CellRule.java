package com.gameoflife.business.rules;

import com.gameoflife.core.models.Cell;
import com.gameoflife.core.models.Grid;
import com.gameoflife.maths.Vector2D;

/**
 * Created by Mehdi on 17/08/2015.
 */
public interface CellRule {
    public Cell simulate(Vector2D cellPosition, Grid grid);
}
