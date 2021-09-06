import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String temp = st.nextToken();
            if(temp.equals("Sleep")) {
                stack.push(st.nextToken());
            } else if(temp.equals("Test")) {
                out.println(stack.isEmpty() ? "Not in a dream" : stack.peek());
            } else if(!stack.isEmpty()) {
                stack.pop();
            }
        }
        f.close();
        out.close();
    }
}