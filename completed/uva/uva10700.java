import java.io.*;
import java.util.*;

public class Main{
    private static long computeMaxValue(String expression) {
        Stack<Long> values = new Stack<>();
        Stack<Character> operations = new Stack<>();
        long lastValue = 0;
        for(char i: expression.toCharArray()) {
            if(i != '+' && i != '*') {
                lastValue = lastValue*10 + Character.getNumericValue(i);
            } else {
                values.push(lastValue);
                lastValue = 0;
                if(i == '+') {
                    while(!operations.isEmpty() && operations.peek() == '+') {
                        values.push(values.pop()+values.pop());
                        operations.pop();
                    }
                    operations.push('+');
                } else {
                    while(!operations.isEmpty()) {
                        if(operations.pop() == '+') {
                            values.push(values.pop()+values.pop());
                        } else {
                            values.push(values.pop()*values.pop());
                        }
                    }
                    operations.push('*');
                }
            }
        }
        values.push(lastValue);
        while(!operations.isEmpty()) {
            if(operations.pop() == '+') {
                values.push(values.pop()+values.pop());
            } else {
                values.push(values.pop()*values.pop());
            }
        }
        return values.pop();
    }
    private static long computeMinValue(String expression) {
        Stack<Long> values = new Stack<>();
        Stack<Character> operations = new Stack<>();
        long lastValue = 0;
        for(char i: expression.toCharArray()) {
            if(i != '+' && i != '*') {
                lastValue = lastValue*10 + Character.getNumericValue(i);
            } else {
                values.push(lastValue);
                lastValue = 0;
                if(i == '+') {
                    while(!operations.isEmpty()) {
                        if(operations.pop() == '+') {
                            values.push(values.pop()+values.pop());
                        } else {
                            values.push(values.pop()*values.pop());
                        }
                    }
                    operations.push('+');
                } else {
                    while(!operations.isEmpty() && operations.peek() == '*') {
                        values.push(values.pop()*values.pop());
                        operations.pop();
                    }
                    operations.push('*');
                }
            }
        }
        values.push(lastValue);
        while(!operations.isEmpty()) {
            if(operations.pop() == '+') {
                values.push(values.pop()+values.pop());
            } else {
                values.push(values.pop()*values.pop());
            }
        }
        return values.pop();
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int t = 0; t < N; t++) {
            String expression = f.readLine();
            long max = computeMaxValue(expression);
            long min = computeMinValue(expression);
            out.println("The maximum and minimum are " + max + " and " + min + ".");
        }
        f.close();
        out.close();
    }
}
