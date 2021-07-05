package app;

import evaluator.ExpressionEvaluator;
import evaluator.NotationTransformer;
import exception.InvalidCharacterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import parser.ExpressionParser;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CalculatorTest {
    private final String expression = "2.0-1.0";
    private final List<String> elements = Collections.emptyList();

    private final ExpressionParser expressionParser = Mockito.mock(ExpressionParser.class);
    private final NotationTransformer notationTransformer = Mockito.mock(NotationTransformer.class);
    private final ExpressionEvaluator expressionEvaluator = Mockito.mock(ExpressionEvaluator.class);

    private final Calculator calculator = new Calculator(expressionParser, notationTransformer, expressionEvaluator);

    @BeforeEach
    void setUp() throws InvalidCharacterException {
        when(expressionParser.convertInfixExpressionToTokens(anyString())).thenReturn(elements);
        when(notationTransformer.convertInfixToPostfix(anyList())).thenReturn(elements);
        when(expressionEvaluator.evaluatePostfixElements(elements)).thenReturn(1.0);
    }

    @Test
    void shouldCallExpressionParserToParseElementsIntoElements() throws InvalidCharacterException {
        calculator.evaluate(expression);

        verify(expressionParser).convertInfixExpressionToTokens(expression);
    }

    @Test
    void shouldReturnExceptionMessageIfExceptionIsThrownByExpressionParser() throws InvalidCharacterException {
        when(expressionParser.convertInfixExpressionToTokens(anyString())).thenThrow(new InvalidCharacterException("message"));

        final String result = calculator.evaluate(expression);

        assertEquals("message", result);
    }

    @Test
    void shouldCallNotationTransformerToTransformInfixElementsToPostfixOrder() {
        calculator.evaluate(expression);

        verify(notationTransformer).convertInfixToPostfix(elements);
    }

    @Test
    void shouldCallExpressionEvaluatorToReturnResultOfPostfixElementsAndReturnResult() {
        final String result = calculator.evaluate(expression);

        verify(expressionEvaluator).evaluatePostfixElements(elements);
        assertEquals("1.0", result);
    }
}