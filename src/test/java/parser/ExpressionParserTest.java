package parser;

import exception.InvalidCharacterException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpressionParserTest {
    private final ExpressionParser expressionParser = new ExpressionParser();

    @Test
    void shouldReturnEmptyListWhenThereAreNoElements() throws InvalidCharacterException {
        final List<String> elements = expressionParser.convertInfixExpressionToTokens("");

        assertEquals(0, elements.size());
    }

    @Test
    void shouldParseWholeNumbers() throws InvalidCharacterException {
        final List<String> elements = expressionParser.convertInfixExpressionToTokens("10");

        assertEquals(List.of("10"), elements);
    }

    @Test
    void shouldParseFloatingNumbers() throws InvalidCharacterException {
        final List<String> elements = expressionParser.convertInfixExpressionToTokens("10.01");

        assertEquals(List.of("10.01"), elements);
    }

    @Test
    void shouldParseOperators() throws InvalidCharacterException {
        final List<String> elements = expressionParser.convertInfixExpressionToTokens("+");

        assertEquals(List.of("+"), elements);
    }

    @Test
    void shouldThrowExceptionWhenParsingAnInvalidCharacter() {
        final InvalidCharacterException exception = assertThrows(InvalidCharacterException.class, () -> expressionParser.convertInfixExpressionToTokens("$"));

        assertEquals("Encountered an invalid character in expression:$", exception.getMessage());
    }

    @Test
    void shouldParseMultipleElements() throws InvalidCharacterException {
        final List<String> elements = expressionParser.convertInfixExpressionToTokens("(10+2.5)");

        assertEquals(List.of("(", "10", "+", "2.5", ")"), elements);
    }
}