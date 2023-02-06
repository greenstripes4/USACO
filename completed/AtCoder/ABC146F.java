import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[] S = f.readLine().toCharArray();
        int[] arr = new int[N+1];
        arr[N] = N;
        for(int i = N-1; i >= 0; i--) {
            arr[i] = S[i] == '0' ? i : arr[i+1];
        }
        Stack<Integer> res = new Stack<>();
        int cur = N;
        while(cur > 0) {
            int next = arr[Math.max(0, cur-M)];
            if(next == cur) {
                cur = -1;
                break;
            }
            res.push(cur-next);
            cur = next;
        }
        if(cur == -1) {
            out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            while(!res.isEmpty()) {
                sb.append(res.pop());
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            out.println(sb);
        }
        f.close();
        out.close();
    }
}
