import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StackExtraTask {
  private static boolean isOperator(String str) {
    return str.equals("+") || str.equals("*");
  }

  private static int evaluate(int operator1, int operator2, String operand) {
    if (operand.equals("+")) {
      return operator1 + operator2;
    }

    return operator1 * operator2;
  }

  public static int calculate(String expression) {
    ArrayList expressionItems = new ArrayList(Arrays.asList(expression.split(" ")));

    Collections.reverse(expressionItems);

    Stack<String> stack1 = new Stack<String>(String.class);
    Stack<Integer> stack2 = new Stack<Integer>(Integer.class);

    for (Object expressionItem : expressionItems) {
      stack1.push((String) expressionItem);
    }

    int size = stack1.size();

    for (int i = 0; i < size; i++) {
      String stackItem = stack1.pop();

      boolean isOperatorItem = isOperator(stackItem);

      if (!isOperatorItem) {
        stack2.push(Integer.parseInt(stackItem));

        continue;
      }

      int result = evaluate(stack2.pop(), stack2.pop(), stackItem);

      stack2.push(result);
    }

    return stack2.pop();
  }
}
