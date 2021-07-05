package app;

import evaluator.ExpressionEvaluator;
import evaluator.NotationTransformer;
import parser.ExpressionParser;

import java.util.List;

public class Calculator {
    private final ExpressionParser expressionParser;
    private final NotationTransformer notationTransformer;
    private final ExpressionEvaluator expressionEvaluator;

    public Calculator(ExpressionParser expressionParser, NotationTransformer notationTransformer, ExpressionEvaluator expressionEvaluator) {
        this.expressionParser = expressionParser;
        this.notationTransformer = notationTransformer;
        this.expressionEvaluator = expressionEvaluator;
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
