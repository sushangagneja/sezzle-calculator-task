package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    @Test
    void shouldReturnTrueIfStringIsNumeric() {
        assertTrue(NumberUtils.isNumeric("1.0"));
    }

    @Test
    void shouldReturnFalseIfStringIsNonNumeric() {
        assertFalse(NumberUtils.isNumeric("123;?"));
    }
}