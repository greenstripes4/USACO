import java.io.*;
import java.util.*;

public class Main {
    private static long solve(ArrayList<Integer> digits, int a, int b) {
        ArrayList<Integer> res = new ArrayList<>();
        int last = -1;
        for(int i = 0; i < digits.size(); i++) {
            if(digits.get(i) > b) {
                if(last < 0) {
                    return Integer.MAX_VALUE;
                }
                res.set(last, b);
                for(int j = last+1; j < digits.size(); j++) {
                    if(j < res.size()) {
                        res.set(j, a);
                    } else {
                        res.add(a);
                    }
                }
                break;
            }
            if(digits.get(i) < a) {
                res.add(a);
                for(int j = i+1; j < digits.size(); j++) {
                    res.add(a);
                }
                break;
            }
            if(digits.get(i) == a) {
                res.add(a);
                last = i;
            } else if(digits.get(i) == b) {
                res.add(b);
            } else {
                res.add(b);
                for(int j = i+1; j < digits.size(); j++) {
                    res.add(a);
                }
                break;
            }
        }
        long ans = 0;
        for(int i: res) {
            ans = ans*10+i;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            ArrayList<Integer> digits = new ArrayList<>();
            int temp = n;
            while(temp > 0) {
                digits.add(temp%10);
                temp /= 10;
            }
            Collections.reverse(digits);
            long ans = 0;
            for(int i = 0; i < digits.size(); i++) {
                ans = ans*10+digits.get(0);
            }
            if(ans < n) {
                ans = 0;
                for(int i = 0; i < digits.size(); i++) {
                    ans = ans*10+digits.get(0)+1;
                }
            }
            if(k == 2) {
                for(int i = 0; i < 10; i++) {
                    for(int j = i+1; j < 10; j++) {
                        ans = Math.min(ans, solve(digits, i, j));
                    }
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
