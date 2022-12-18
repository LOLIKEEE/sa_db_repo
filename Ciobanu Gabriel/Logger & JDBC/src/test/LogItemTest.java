package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sa.homework.logger.classes.LogItem;
import sa.homework.logger.enums.Level;

import java.time.LocalDateTime;

class LogItemTest {

    @Test
    void testToString() {
        Assertions.assertEquals("18-Apr-1994 13:30:20.505 DEBUG -> This is a message",new LogItem(Level.DEBUG,"This is a message",
                LocalDateTime.of(1994,4,18,13,30,20,5)).toString());
    }

    @Test
    void parseLog() {
    }

    @Test
    void getDateTime() {
    }

    @Test
    void getLevel() {
    }

    @Test
    void getMessage() {
    }
}