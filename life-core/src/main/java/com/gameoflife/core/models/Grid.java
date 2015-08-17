package com.gameoflife.core.models;

import com.gameoflife.core.consts.CellNeighbor;
import com.gameoflife.core.consts.CellState;
import com.gameoflife.core.exceptions.OutOfGridException;
import com.gameoflife.core.inputs.GridInput;
import com.gameoflife.maths.Vector2D;

import java.util.Arrays;

/**
 * Created by Mehdi on 17/08/2015.
 */
public class Grid {

    private int width;
    private int height;
    private Cell[][] cells;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

     public Grid(GridInput gridInput) {
         this.width=gridInput.getWidth();
         this.height=gridInput.getHeight();
         this.cells = gridInput.getCells();
    }

    public Cell getCellAt(final int x, final int y) throws OutOfGridException {

        return getCellAt(new Vector2D(x,y));
    }
    public Cell getCellAt(final Vector2D cellPosition) throws OutOfGridException {
        if(isCellOutsideBorders(cellPosition)){
            throw new OutOfGridException();
        }
        return cells[cellPosition.getX()][cellPosition.getY()];
    }

    public boolean isCellOutsideBorders(final Vector2D cellPosition) {
        return (cellPosition.getY() < 0 || cellPosition.getY() >= this.height) ||
                (cellPosition.getX() < 0 || cellPosition.getX() >= this.width);
    }

    public int getLiveNeighboursAt(final Vector2D cellPosition) {
        return getNeighboursWithStateAt(cellPosition, CellState.ALIVE);
    }
    public int getDeadNeighboursAt(final Vector2D cellPosition) {
        return getNeighboursWithStateAt(cellPosition, CellState.DEAD);
    }
    public int getNeighboursWithStateAt(final Vector2D cellPosition,CellState state) {
        int neighbourCount = 0;
        for (CellNeighbor cellNeighbor : CellNeighbor.values()) {
            neighbourCount += countCellNeighboursWithState(cellPosition.add(cellNeighbor.getPosition()), state);
        }
        return neighbourCount;
    }

    private int countCellNeighboursWithState(final Vector2D cellPosition,CellState state) {
        if (isCellOutsideBorders(cellPosition)) {
            return 0;
        }
        return cells[cellPosition.getX()][cellPosition.getY()].getCellState().equals(state)?1:0;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Grid grid = (Grid) o;

        if (width != grid.width)
            return false;
        if (height != grid.height)
            return false;
        return Arrays.deepEquals(cells, grid.cells);

    }

    @Override public int hashCode() {
        int result = width;
        result = 31 * result + height;
        result = 31 * result + Arrays.deepHashCode(cells);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int row =0;row <width;row++){
            for(int col =0;col <height;col++){
                result.append(this.cells[row][col]);
            }
            result.append(System.lineSeparator());
        }

        return result.toString();
    }

}
