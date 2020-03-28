/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */


import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        //long start = System.nanoTime();
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int n = Integer.parseInt(f.readLine());
        for(int i = 0; i < n; i++){
            char[] parenthesis = f.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            for(char j: parenthesis){
                if(j == '(' || j == '['){
                    stack.push(j);
                } else if(j == ')'){
                    if(stack.isEmpty()){
                        isValid = false;
                        break;
                    }
                    char prev = stack.pop();
                    if(prev != '('){
                        isValid = false;
                        break;
                    }
                } else if(j == ']'){
                    if(stack.isEmpty()){
                        isValid = false;
                        break;
                    }
                    char prev = stack.pop();
                    if(prev != '['){
                        isValid = false;
                        break;
                    }
                }
            }
            out.println(isValid && stack.isEmpty() ? "Yes":"No");
        }
        f.close();
        //out.flush();
        //long end = System.nanoTime();
        //long ms = ((end - start) / 1000000);
        //out.println("Run for " + ms + "ms");
        out.close();
    }
}
