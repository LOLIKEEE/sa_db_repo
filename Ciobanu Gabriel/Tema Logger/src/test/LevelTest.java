package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sa.homework.logger.enums.Level;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {

    @Test
    void toLevel() {
        Assertions.assertEquals(Level.toLevel("DEBUG"), Level.DEBUG);
    }
    @Test
    void toLevelFailed() {
        assertNotEquals(Level.toLevel("DEBUg"), Level.DEBUG);
    }

}