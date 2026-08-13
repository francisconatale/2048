package ar.edu.unrc.game2048;

import org.junit.jupiter.api.Test;

import ar.edu.unrc.game2048.Cell;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest{

@Test
public void differentCellsCannotMerge(){
    // arrange
    Cell origin = new Cell(2);
    Cell target = new Cell(4);
    // act
    boolean result = origin.canMergeWith(target);

    assertFalse(result);

}

}
