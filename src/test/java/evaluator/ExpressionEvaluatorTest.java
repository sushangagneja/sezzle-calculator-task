package evaluator;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {
    private final ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

    @Test
    void shouldReturnZeroWhenThereAreNoElements() {
        final Double result = expressionEvaluator.evaluatePostfixElements(Collections.emptyList());

        assertEquals(0.0, result);
    }

    @Test
    void shouldEvaluateExpressionWithNoOperators() {
        final Double result = expressionEvaluator.evaluatePostfixElements(List.of("5"));

        assertEquals(5.0, result);
    }

    @Test
    void shouldEvaluateExpressionWithTwoOperandsAndOneOperator() {
        final Double result = expressionEvaluator.evaluatePostfixElements(List.of("5", "1", "+"));

        assertEquals(6.0, result);
    }

    @Test
    void shouldEvaluateExpressionWithMultipleOperandsAndOperators() {
        final Double result = expressionEvaluator.evaluatePostfixElements(List.of("2", "5", "1", "+", "*"));

        assertEquals(12.0, result);
    }
}