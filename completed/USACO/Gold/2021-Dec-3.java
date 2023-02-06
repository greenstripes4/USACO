import java.io.*;
import java.util.*;

public class Main {
    private static boolean validBracketSequence(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        boolean[] seen = new boolean[51];
        for(int i: arr) {
            if(seen[i]) {
                if(stack.isEmpty() || stack.pop() != i) {
                    return false;
                }
            } else {
                stack.push(i);
                seen[i] = true;
            }
        }
        return true;
    }
    private static boolean checkRange(int[][] arr, int l, int r, int v) {
        for(int i = l; i <= r; i++) {
            boolean flag = false;
            for(int j: arr[i]) {
                if(j == v) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                return false;
            }
        }
        return true;
    }
    private static boolean consistent(int[] a, int[] b) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        for(int i: a) {
            for(int j: b) {
                if(i == j) {
                    arr1.add(i);
                    break;
                }
            }
        }
        ArrayList<Integer> arr2 = new ArrayList<>();
        for(int i: b) {
            for(int j: a) {
                if(i == j) {
                    arr2.add(i);
                    break;
                }
            }
        }
        return arr1.equals(arr2);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] c = new int[M][];
            int[] left = new int[N+1];
            Arrays.fill(left, -1);
            int[] right = new int[N+1];
            Arrays.fill(right, -1);
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(f.readLine());
                int k = Integer.parseInt(st.nextToken());
                c[i] = new int[k];
                for(int j = 0; j < k; j++) {
                    c[i][j] = Integer.parseInt(st.nextToken());
                    if(left[c[i][j]] == -1) {
                        left[c[i][j]] = i;
                    }
                    right[c[i][j]] = i;
                }
            }
            boolean flag = false;
            for(int[] i: c) {
                if(!validBracketSequence(i)) {
                    flag = true;
                    out.println("NO");
                    break;
                }
            }
            if(flag) {
                continue;
            }
            for(int i = 1; i <= N; i++) {
                if(left[i] == -1) {
                    continue;
                }
                if(!checkRange(c, left[i], right[i], i)) {
                    flag = true;
                    out.println("NO");
                    break;
                }
            }
            if(flag) {
                continue;
            }
            for(int i = 0; i < M && !flag; i++) {
                for(int j = i+1; j < M; j++) {
                    if(!consistent(c[i], c[j])) {
                        flag = true;
                        out.println("NO");
                        break;
                    }
                }
            }
            if(flag) {
                continue;
            }
            out.println("YES");
        }
        f.close();
        out.close();
    }
}
