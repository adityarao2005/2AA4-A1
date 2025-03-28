package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.common.CellType;

public class CellTypeTest {

    @Test
    public void testWall() {
        // Test the WALL cell type
        CellType wallCell = CellType.WALL;
        assertTrue(wallCell.isWall());
        assertEquals(wallCell, CellType.fromChar('#'));
    }

    @Test
    public void testPassage() {
        // Test the PASSAGE cell type
        CellType passageCell = CellType.PASSAGE;
        assertFalse(passageCell.isWall());
        assertEquals(passageCell, CellType.fromChar(' '));
    }

}
