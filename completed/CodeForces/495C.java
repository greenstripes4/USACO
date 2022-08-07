import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] s = f.readLine().toCharArray();
        int cnt = 0;
        int other = 0;
        for(char i: s) {
            if(i == '(') {
                cnt++;
            } else if(i == ')') {
                cnt--;
            } else {
                other++;
            }
        }
        if(other > cnt) {
            out.println(-1);
        } else {
            int[] res = new int[other];
            Arrays.fill(res, 1);
            res[other-1] += cnt-other;
            int idx = 0;
            boolean flag = false;
            cnt = 0;
            for(char i: s) {
                if(i == '(') {
                    cnt++;
                } else if(i == ')') {
                    if(cnt == 0) {
                        flag = true;
                        break;
                    }
                    cnt--;
                } else {
                    if(cnt < res[idx]) {
                        flag = true;
                        break;
                    }
                    cnt -= res[idx];
                    idx++;
                }
            }
            if(flag || cnt != 0) {
                out.println(-1);
            } else {
                for(int i: res) {
                    out.println(i);
                }
            }
        }
        f.close();
        out.close();
    }
}