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
    // assert
    assertFalse(result);
}

@Test
public void mergeCellDifferentValuesThrowsArgumentException(){
    // arrange
    Cell origin = new Cell(2);
    Cell target = new Cell(4);
    // act and assert
    assertThrows(IllegalArgumentException.class, () -> { origin.mergeWith(target);});
}

@Test
public void cellWithEqualsValueJoin(){
    // arrange
    Cell origin = new Cell(2);
    Cell target = new Cell(2);
    Cell expected = new Cell(4);
    // act
    Cell result = origin.mergeWith(target);
    // assert
    assertEquals(expected, result);
}


}
