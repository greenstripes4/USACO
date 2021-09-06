import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            char[] s = input.toCharArray();
            Stack<Integer> stack = new Stack<>();
            int flag = 0;
            int idx = 1;
            for(int i = 0; i < s.length; i++) {
                char next = s[i];
                if(next == '(') {
                    stack.push(0);
                } else if(next == '[') {
                    stack.push(1);
                } else if(next == '{') {
                    stack.push(2);
                } else if(next == '<') {
                    stack.push(3);
                } else if(next == '*') {
                    if(i > 0 && s[i-1] == '(') {
                        stack.pop();
                        stack.push(4);
                        idx--;
                    } else if(i < s.length-1 && s[i+1] == ')') {
                        if(stack.isEmpty() || stack.peek() != 4) {
                            flag = idx;
                            break;
                        } else {
                            stack.pop();
                            i++;
                        }
                    }
                } else if(next == ')') {
                    if(stack.isEmpty() || stack.peek() != 0) {
                        flag = idx;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if(next == ']') {
                    if(stack.isEmpty() || stack.peek() != 1) {
                        flag = idx;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if(next == '}') {
                    if(stack.isEmpty() || stack.peek() != 2) {
                        flag = idx;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if(next == '>') {
                    if(stack.isEmpty() || stack.peek() != 3) {
                        flag = idx;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                idx++;
            }
            if(flag > 0) {
                out.println("NO " + flag);
            } else if(!stack.isEmpty()) {
                out.println("NO " + (s.length+1));
            } else {
                out.println("YES");
            }
        }
        f.close();
        out.close();
    }
}