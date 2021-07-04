package parser;

import exception.InvalidCharacterException;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constant.CalculatorConstants.OPERATOR_SYMBOLS;

public class ExpressionParser {
    public List<String> convertInfixExpressionToTokens(String expression) throws InvalidCharacterException {
        List<String> elements = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            final char currentCharacter = expression.charAt(i);
            if (isNumeric(currentCharacter)) {
                Pattern pattern = Pattern.compile("([^.\\d]+)");
                Matcher matcher = pattern.matcher(expression.substring(i));
                int position = matcher.find()? matcher.start()+i : expression.length();
                elements.add(expression.substring(i, position));
                i=position-1;
            } else if (isOperator(currentCharacter)){
                elements.add(String.valueOf(currentCharacter));
            } else {
                throw new InvalidCharacterException("Encountered an invalid character in expression:" + currentCharacter);
            }
        }
        return elements;
    }

    private boolean isOperator(char character) {
        return OPERATOR_SYMBOLS.contains(String.valueOf(character));
    }

    private boolean isNumeric(char character) {
        return Character.isDigit(character) || character == '.';
    }
}
