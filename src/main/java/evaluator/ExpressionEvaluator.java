package evaluator;

import operator.*;
import utils.NumberUtils;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import static constant.CalculatorConstants.*;
import static constant.CalculatorConstants.DIVISION_SYMBOL;

public class ExpressionEvaluator {

    public Double evaluatePostfixElements(List<String> elements) {
        Stack<Double> stack = new Stack<>();
        for (String element : elements) {
            if (NumberUtils.isNumeric(element)) {
                stack.push(Double.parseDouble(element));
            }
            else {
                Double operand2 = stack.pop();
                Double operand1 = stack.pop();
                final Double intermediateResult = BinaryOperator.getOperator(element).operate(operand1, operand2);
                stack.push(intermediateResult);
            }
        }
        return stack.isEmpty() ? 0.0 : stack.pop();
    }
}
