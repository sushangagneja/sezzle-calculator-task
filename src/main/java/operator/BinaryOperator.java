package operator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public enum BinaryOperator implements Operator {

    ADD {
        @Override
        public Double operate(Double a, Double b) {
            return a + b;
        }

        @Override
        public String getSymbol() {
            return "+";
        }

        @Override
        public int getPrecedence() {
            return 1;
        }
    },
    SUBTRACT {
        @Override
        public Double operate(Double a, Double b) {
            return a - b;
        }

        @Override
        public String getSymbol() {
            return "-";
        }

        @Override
        public int getPrecedence() {
            return 1;
        }
    },
    MULTIPLY {
        @Override
        public Double operate(Double a, Double b) {
            return a * b;
        }

        @Override
        public String getSymbol() {
            return "*";
        }

        @Override
        public int getPrecedence() {
            return 2;
        }
    },
    DIVIDE {
        @Override
        public Double operate(Double a, Double b) {
            if (b == 0) {
                throw new ArithmeticException("Can't divide by zero");
            }
            return a / b;
        }

        @Override
        public String getSymbol() {
            return "/";
        }

        @Override
        public int getPrecedence() {
            return 2;
        }
    };
    private static HashMap<String, BinaryOperator> operatorMap =
            (HashMap<String, BinaryOperator>) Arrays.stream(values())
                    .collect(Collectors.toMap(BinaryOperator::getSymbol, operator -> operator));

    public static BinaryOperator getOperator(String operator) {
        return operatorMap.getOrDefault(operator, null);
    }

    public Double operate(Double a, Double b) {
        return 0.0;
    }

    @Override
    public String getSymbol() {
        return "";
    }

    @Override
    public int getPrecedence() {
        return 0;
    }
}
