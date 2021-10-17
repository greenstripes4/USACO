import java.io.*;
import java.util.*;

public class Main {
    private static int[] BIT;
    private static void update(int index, int add) {
        while(index < BIT.length) {
            BIT[index] += add;
            index += index&-index;
        }
    }
    private static int query(int index) {
        int sum = 0;
        while(index > 0) {
            sum += BIT[index];
            index -= index&-index;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] s = f.readLine().toCharArray();
        int[] dp = new int[s.length];
        int[] match = new int[s.length];
        Arrays.fill(match, -1);
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for(int i = 0; i < s.length; i++) {
            if(s[i] == '(') {
                stack.push(i);
            } else if(!stack.isEmpty()) {
                cur += 2;
                match[stack.pop()] = i;
            }
            dp[i] = cur;
        }
        int m = Integer.parseInt(f.readLine());
        int[][] queries = new int[m][2];
        Integer[] idx = new Integer[m];
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken())-1;
            queries[i][1] = Integer.parseInt(st.nextToken())-1;
            idx[i] = i;
        }
        Arrays.sort(idx, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return queries[integer][0]-queries[t1][0];
            }
        });
        BIT = new int[s.length+1];
        int[] res = new int[m];
        int k = 0;
        for(int i: idx) {
            while(k < queries[i][0]) {
                if(match[k] >= 0) {
                    update(match[k]+1, 1);
                }
                k++;
            }
            res[i] = dp[queries[i][1]]-(queries[i][0] == 0 ? 0 : dp[queries[i][0]-1]);
            res[i] -= (query(queries[i][1]+1)-query(queries[i][0]))*2;
        }
        for(int i = 0; i < m; i++) {
            out.println(res[i]);
        }
        f.close();
        out.close();
    }
}
