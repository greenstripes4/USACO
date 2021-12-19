import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] s = new int[n];
        for(int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek() < s[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                ans = Math.max(ans, s[i]^stack.peek());
            }
            stack.push(s[i]);
        }
        stack.clear();
        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() < s[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                ans = Math.max(ans, s[i]^stack.peek());
            }
            stack.push(s[i]);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
