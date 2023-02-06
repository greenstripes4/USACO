import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[] x = new int[n+1];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 1; i <= n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i <= n; i++) {
            while(x[stack.peek()] >= x[i]) {
                stack.pop();
            }
            out.print(stack.peek());
            if(i == n) {
                out.println();
            } else {
                out.print(" ");
            }
            stack.push(i);
        }
        f.close();
        out.close();
    }
}