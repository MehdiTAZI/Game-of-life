package com.gameoflife.core.consts;

import com.gameoflife.maths.Vector2D;

/**
 * Created by Mehdi on 17/08/2015.
 */
public enum CellNeighbor {

    TOP_LEFT(-1, 1), TOP(0, 1), TOP_RIGHT(1, 1), RIGHT(1, 0), BOTTOM_RIGHT(1, -1), BOTTOM(0, -1), BOTTOM_LEFT(-1, -1), LEFT(-1, 0);

   private final Vector2D position;

    private CellNeighbor(final int x, final int y) {
        this.position = new Vector2D(x,y);
    }

    public Vector2D getPosition(){
        return this.position;
    }

}