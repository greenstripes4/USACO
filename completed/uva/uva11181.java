import java.io.*;
import java.util.*;

public class Main{
    private static double[] ans;
    private static double total;
    private static void solve(double[] p, boolean[] test, int ind, int r) {
        if(ind == test.length) {
            double probability = 1;
            for(int i = 0; i < test.length; i++) {
                if(test[i]) {
                    probability *= p[i];
                } else {
                    probability *= 1-p[i];
                }
            }
            for(int i = 0; i < test.length; i++) {
                if(test[i]) {
                    ans[i] += probability;
                }
            }
            total += probability;
            return;
        }
        if(test.length-ind > r) {
            solve(p, test, ind+1, r);
        }
        if(r > 0) {
            test[ind] = true;
            solve(p, test, ind+1, r-1);
            test[ind] = false;
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int testcase = 1;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            double[] p = new double[N];
            for(int i = 0; i < N; i++) {
                p[i] = Double.parseDouble(f.readLine());
            }
            ans = new double[N];
            total = 0;
            solve(p, new boolean[N], 0, r);
            out.println("Case " + testcase + ":");
            for(double i: ans) {
                out.printf("%.6f\n", i/total);
            }
            testcase++;
        }
        f.close();
        out.close();
    }
}
