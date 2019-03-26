import java.util.*;
import java.io.*;

public class Calculator {
  public static double eval(String s) {
    Scanner in = new Scanner(s);
    @SuppressWarnings("unchecked")
    MyDeque<Double> stack = new MyDeque<>();
    String cur = "";
    while (in.hasNext()) {
      cur = in.next();
      if (cur.equals("+")) {
        Double val2 = stack.removeLast();
        Double val1 = stack.removeLast();
        stack.addLast(val1+val2);
      }
      else if (cur.equals("-")) {
        Double val2 = stack.removeLast();
        Double val1 = stack.removeLast();
        stack.addLast(val1-val2);
      }
      else if (cur.equals("*")) {
        Double val2 = stack.removeLast();
        Double val1 = stack.removeLast();
        stack.addLast(val1*val2);
      }
      else if (cur.equals("/")) {
        Double val2 = stack.removeLast();
        Double val1 = stack.removeLast();
        stack.addLast(val1/val2);
      }
      else if (cur.equals("%")) {
        Double val2 = stack.removeLast();
        Double val1 = stack.removeLast();
        stack.addLast(val1%val2);
      }
      else {
        stack.addLast(Double.parseDouble(cur));
      }
    }
    return stack.getLast();
  }

  public static void main(String[] args) {
    System.out.println(eval("2 4 71 8.5 + - * 5 +"));
  }
}
