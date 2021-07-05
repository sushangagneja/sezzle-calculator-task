package operator;

import org.junit.jupiter.api.Test;

import static operator.ParenthesisOperator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ParenthesisOperatorTest {
    @Test
    void shouldReturnOpenParenthesisOperatorForStar() {
        assertEquals(OPEN, getOperator("("));
    }

    @Test
    void shouldReturnCloseParenthesisOperatorForSlash() {
        assertEquals(CLOSE, getOperator(")"));
    }

    @Test
    void shouldReturnNullForInvalidOperatorSymbol() {
        assertNull(getOperator("$"));
    }
}