import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        Stack<int[]> stack = new Stack<>();
        int[] lower = new int[n];
        int cur = 0;
        int idx = 0;
        int[] res = new int[n];
        boolean flag = false;
        for(int i = 0; i < 2*n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            if(st.nextToken().equals("+")) {
                stack.push(new int[]{cur, idx++});
                lower[cur] = 0;
            } else {
                int x = Integer.parseInt(st.nextToken());
                if(stack.isEmpty()) {
                    flag = true;
                    break;
                }
                int[] last = stack.pop();
                if(lower[last[0]] > x) {
                    flag = true;
                    break;
                }
                lower[last[0]] = x;
                res[last[1]] = x;
                cur++;
            }
        }
        out.println(flag ? "NO" : "YES");
        if(!flag) {
            out.print(res[0]);
            for(int i = 1; i < n; i++) {
                out.print(" " + res[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}