import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        f.readLine();
        while(T-- > 0) {
            Stack<Character> stack = new Stack<>();
            String next;
            while((next = f.readLine()) != null && next.length() > 0) {
                char temp = next.charAt(0);
                if(temp >= '0' && temp <= '9') {
                    out.print(temp);
                } else if(temp == ')') {
                    while(stack.peek() != '(') {
                        out.print(stack.pop());
                    }
                    stack.pop();
                } else {
                    stack.push(temp);
                }
            }
            while(!stack.isEmpty()) {
                out.print(stack.pop());
            }
            out.println();
        }
        f.close();
        out.close();
    }
}