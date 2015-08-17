package com.gameoflife.core.inputs;

import com.gameoflife.core.models.Cell;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Mehdi on 17/08/2015.
 */

public class FileGridInput implements  GridInput {

    //java 7 features
    public FileGridInput(String fileName){

        //read file using the "using" keyword in order to automatically close  the file handle
        // put exception in one line using ||
    }

    public int getWidth() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }

    public Cell[][] getCells() {
        return new Cell[0][];
    }
}
