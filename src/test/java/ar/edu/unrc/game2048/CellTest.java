package ar.edu.unrc.game2048;
import org.junit.jupiter.api.Test;
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

// 
// ------ Cell.isEmpty() ------
// Verifica que el metodo isEmpty() de la clase Cell devuelva true si la celda esta vacia
// 

@Test
public void testCellIsEmpty(){
    // arrange
    Cell cell = new Cell(0);
    // act
    boolean result = cell.isEmpty();

    // assert
    assertTrue(result);
}

// 
// ------ Cell.isNotEmpty() ------
// Verifica que el metodo isEmpty() de la clase Cell devuelva false si la celda esta vacia
// 

@Test
public void testCellIsNotEmpty(){
    // arrange
    Cell cell = new Cell(3);
    // act
    boolean result = cell.isEmpty();

    // assert
    assertFalse(result);
}

// 
// ------ Cell.mergeWith(Cell other) ------
// Verifica que el metodo mergeWith() de la clase Cell funcione correctamente al unir dos celdas con el mismo valor
// 

@Test
public void testCellMergeWith(){
    // arrange
    Cell cell = new Cell(4);
    Cell otherCell = new Cell(4);
    // act
    Cell result = cell.mergeWith(otherCell);

    // assert
    assertEquals(8, result.getValue());
}

// 
// ------ Cell.equals(Object o) ------
// Verifica que el metodo equals() de la clase Cell funcione correctamente
// (caso positivo: dos celdas con el mismo valor son iguales)
// 

@Test
public void testCellEquals(){
    // arrange
    Cell cell = new Cell(4);
    Cell otherCell = new Cell(4);
    // act
    boolean result = cell.equals(otherCell);

    // assert
    assertTrue(result);
}

// 
// ------ Cell.notEquals() ------
// Verifica que el metodo equals() de la clase Cell funcione correctamente
// (caso negativo: dos celdas con valores diferentes no son iguales)
// 

@Test
public void testCellNotEquals(){
    // arrange
    Cell cell = new Cell(4);
    Cell otherCell = new Cell(8);
    // act
    boolean result = cell.equals(otherCell);

    // assert
    assertFalse(result);
}

    @Test
    public void testCellNotEqualsByHash(){
        // arrange
        Cell cell = new Cell(4);
        Cell otherCell = new Cell(8);

        // act
        int hashCell = cell.hashCode();
        int hashOtherCell = otherCell.hashCode();

        // assert
        assertNotEquals(hashCell, hashOtherCell);
    }

    @Test
    public void testCellEqualsByHash(){
        // arrange
        Cell cell = new Cell(4);
        Cell otherCell = new Cell(4);

        // act
        int hashCell = cell.hashCode();
        int hashOtherCell = otherCell.hashCode();

        // assert
        assertEquals(hashCell, hashOtherCell);
    }

}
