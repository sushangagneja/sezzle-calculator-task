package operator;

import org.junit.jupiter.api.Test;

import static operator.BinaryOperator.*;
import static org.junit.jupiter.api.Assertions.*;

class BinaryOperatorTest {
    @Test
    void shouldPerformAdditionForAdd() {
        assertEquals(4.0, ADD.operate(3.0, 1.0));
    }

    @Test
    void shouldPerformSubtractionForSubtract() {
        assertEquals(2.0, SUBTRACT.operate(3.0, 1.0));
    }

    @Test
    void shouldPerformMultiplicationForMultiply() {
        assertEquals(3.0, MULTIPLY.operate(3.0, 1.0));
    }

    @Test
    void shouldPerformDivisionForDivide() {
        assertEquals(3.0, DIVIDE.operate(3.0, 1.0));
    }

    @Test
    void shouldThrowExceptionWhenDivisorIsZeroForDivide() {
        final ArithmeticException exception = assertThrows(ArithmeticException.class, () -> DIVIDE.operate(3.0, 0.0));
        assertEquals("Can't divide by zero", exception.getMessage());
    }

    @Test
    void shouldReturnAddOperatorForPlus() {
        assertEquals(ADD, getOperator("+"));
    }

    @Test
    void shouldReturnSubtractOperatorForMinus() {
        assertEquals(SUBTRACT, getOperator("-"));
    }

    @Test
    void shouldReturnMultiplyOperatorForStar() {
        assertEquals(MULTIPLY, getOperator("*"));
    }

    @Test
    void shouldReturnDivideOperatorForSlash() {
        assertEquals(DIVIDE, getOperator("/"));
    }

    @Test
    void shouldReturnNullForInvalidOperatorSymbol() {
        assertNull(getOperator("$"));
    }
}