package operator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public enum ParenthesisOperator implements Operator{
    OPEN {

        @Override
        public String getSymbol() {
            return "(";
        }

        @Override
        public int getPrecedence() {
            return 1;
        }
    },
    CLOSE {

        @Override
        public String getSymbol() {
            return ")";
        }

        @Override
        public int getPrecedence() {
            return 1;
        }
    };

    private static HashMap<String, ParenthesisOperator> operatorMap =
            (HashMap<String, ParenthesisOperator>) Arrays.stream(values())
                    .collect(Collectors.toMap(ParenthesisOperator::getSymbol, operator -> operator));

    public static ParenthesisOperator getOperator(String operator) {
        return operatorMap.getOrDefault(operator, null);
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
