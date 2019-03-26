import java.util.*;
import java.io.*;

public class Calculator {
  public static double eval(String s) {
    Scanner in = new Scanner(s); // to scan the string
    @SuppressWarnings("unchecked")
    MyDeque<Double> stack = new MyDeque<>(); //to hold the stack
    String cur = ""; //current token
    while (in.hasNext()) {
      cur = in.next(); //update token
      if (cur.equals("+")) { //if + operator appears
        Double val2 = stack.removeLast();//remove and store last 2 values
        Double val1 = stack.removeLast();
        stack.addLast(val1+val2); //add values and add sum back to the stack
      }
      else if (cur.equals("-")) { //else if  - operator appears
        Double val2 = stack.removeLast(); // remove and store last 2 values
        Double val1 = stack.removeLast();
        stack.addLast(val1-val2); //subtract values and add difference back to the stack
      }
      else if (cur.equals("*")) { //else if * operator appears
        Double val2 = stack.removeLast(); //remove and store last 2 values
        Double val1 = stack.removeLast();
        stack.addLast(val1*val2); //multiply values and add product back to the stack
      }
      else if (cur.equals("/")) { //else if / operator appears
        Double val2 = stack.removeLast(); //remove and store last 2 values
        Double val1 = stack.removeLast();
        stack.addLast(val1/val2); //divide values and add quotient back to the stack
      }
      else if (cur.equals("%")) { //else if % operator appears
        Double val2 = stack.removeLast(); //remove and store last 2 values
        Double val1 = stack.removeLast();
        stack.addLast(val1%val2); //mode values and add result back to the stack
      }
      else { // else when token is a number
        stack.addLast(Double.parseDouble(cur));//add number to the stack
      }
    }
    return stack.getLast(); // return the resulting value
  }

  public static void main(String[] args) {
    System.out.println(eval("2 4 71 8.5 + - * 5 +"));
  }
}
