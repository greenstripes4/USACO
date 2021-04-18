import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            char[] s = f.readLine().toCharArray();
            int temp = 0;
            for(char i: s) {
                temp += i == '0' ? 1 : -1;
            }
            int temp2 = 0;
            boolean flag = false;
            int ans = 0;
            for(char i: s) {
                if(temp == 0 && temp2 == x) {
                    flag = true;
                    break;
                } else if(temp != 0 && Math.abs(x-temp2)%Math.abs(temp) == 0 && (x-temp2)/temp >= 0) {
                    ans++;
                }
                temp2 += i == '0' ? 1 : -1;
            }
            out.println(flag ? -1 : ans);
        }
        f.close();
        out.close();
    }
}