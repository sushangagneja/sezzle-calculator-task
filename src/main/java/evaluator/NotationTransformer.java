package evaluator;

import operator.*;
import utils.NumberUtils;

import java.util.*;

public class NotationTransformer {

    public List<String> convertInfixToPostfix(List<String> infixElements) {
        List<String> result = new LinkedList<>();
        Stack<Operator> stack = new Stack<>();

        for (String element : infixElements) {
            if (BinaryOperator.getOperator(element)!=null) {
                Operator operator = BinaryOperator.getOperator(element);
                result.addAll(popTillStackTopHasLowerPreference(stack, operator));
            } else if (ParenthesisOperator.getOperator(element) == ParenthesisOperator.OPEN) {
                stack.push(ParenthesisOperator.OPEN);
            } else if (ParenthesisOperator.getOperator(element) == ParenthesisOperator.CLOSE) {
                result.addAll(popTillOpenParanthesisIsFound(stack));
            } else if (NumberUtils.isNumeric(element)) {
                result.add(element);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() instanceof ParenthesisOperator)
                throw new ArithmeticException("Mismatched parentheses");
            result.add(stack.pop().getSymbol());
        }
        return result;
    }

    private List<String> popTillStackTopHasLowerPreference(Stack<Operator> stack, Operator operator) {
        List<String> operators = new ArrayList<>();
        while (!stack.isEmpty() && operator.getPrecedence() < stack.peek().getPrecedence()) {
            operators.add(stack.pop().getSymbol());
        }
        stack.push(operator);
        return operators;
    }

    private List<String> popTillOpenParanthesisIsFound(Stack<Operator> stack) {
        if(!stack.contains(ParenthesisOperator.OPEN)) {
            throw new ArithmeticException("Mismatched parentheses");
        }
        List<String> operators = new ArrayList<>();
        while (!(stack.peek() instanceof ParenthesisOperator)) {
           operators.add(stack.pop().getSymbol());
        }
        stack.pop();
        return operators;
    }
}
