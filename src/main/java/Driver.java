import app.Calculator;

public class Driver {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.evaluate("100*(2+12)/7"));    // 200.0
        System.out.println(calculator.evaluate(".2*50/(7-5)"));     // 5.0
        System.out.println(calculator.evaluate("()"));              // 0.0
        System.out.println(calculator.evaluate("((5+9)"));          // Mismatched parentheses
        System.out.println(calculator.evaluate("(5+9))"));          // Mismatched parentheses
        System.out.println(calculator.evaluate("(5+9)&"));          // Encountered an invalid character in expression:&
        System.out.println(calculator.evaluate("5/0"));             // Can't divide by zero
    }
}
