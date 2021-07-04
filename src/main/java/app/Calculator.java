package app;

import evaluator.ExpressionEvaluator;
import evaluator.NotationTransformer;
import parser.ExpressionParser;

import java.util.List;

public class Calculator {
    private final ExpressionParser expressionParser;
    private final NotationTransformer notationTransformer;
    private final ExpressionEvaluator expressionEvaluator;

    public Calculator() {
        this.expressionParser = new ExpressionParser();
        this.notationTransformer = new NotationTransformer();
        this.expressionEvaluator = new ExpressionEvaluator();
    }

    public String evaluate(String expression) {
        try {
            final List<String> infixElements = expressionParser.convertInfixExpressionToTokens(expression);
            final List<String> postfixElements = notationTransformer.convertInfixToPostfix(infixElements);
            return expressionEvaluator.evaluatePostfixElements(postfixElements).toString();
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
}
