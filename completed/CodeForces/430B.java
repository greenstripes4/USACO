import java.io.*;
import java.util.*;

public class Main {
    private static int solve(ArrayList<Integer> c, int k) {
        int i = k;
        int j = k+1;
        int ans = 0;
        while(i >= 0) {
            int temp = c.get(i);
            int cur = 0;
            while(i >= 0 && c.get(i) == temp) {
                cur++;
                i--;
            }
            while(j < c.size() && c.get(j) == temp) {
                cur++;
                j++;
            }
            if(cur >= 3) {
                ans += cur;
            } else {
                break;
            }
        }
        return ans-1;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        ArrayList<Integer> c = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            c.add(Integer.parseInt(st.nextToken()));
        }
        int max = 0;
        for(int i = 1; i < n; i++) {
            c.add(i, x);
            max = Math.max(max, solve(c, i));
            c.remove(i);
        }
        out.println(max);
        f.close();
        out.close();
    }
}