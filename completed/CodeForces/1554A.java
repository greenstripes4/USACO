import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int k = 0;
            while(1 << k <= n) {
                k++;
            }
            int[][] sparseTable = new int[n][k];
            for(int i = 0; i < n; i++) {
                sparseTable[i][0] = a[i];
            }
            for(int j = 1; j < k; j++) {
                for(int i = 0; i < n; i++) {
                    if(i+(1 << j) > n) {
                        break;
                    }
                    sparseTable[i][j] = Math.max(sparseTable[i][j-1], sparseTable[i+(1 << (j-1))][j-1]);
                }
            }
            Stack<Integer> stack = new Stack<>();
            int[] left = new int[n];
            for(int i = 0; i < n; i++) {
                while(!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    left[i] = stack.peek()+1;
                }
                stack.push(i);
            }
            stack = new Stack<>();
            int[] right = new int[n];
            for(int i = n-1; i >= 0; i--) {
                while(!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    right[i] = stack.peek()-1;
                } else {
                    right[i] = n-1;
                }
                stack.push(i);
            }
            long ans = 0;
            for(int i = 0; i < n; i++) {
                if(left[i] == right[i]) {
                    continue;
                }
                int size = 0;
                while(1 << size <= right[i]-left[i]+1) {
                    size++;
                }
                size--;
                long max = Math.max(sparseTable[left[i]][size], sparseTable[right[i]-(1 << size)+1][size]);
                ans = Math.max(ans, a[i]*max);
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}