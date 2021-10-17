import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int n = Integer.parseInt(st.nextToken());
                char c = st.nextToken().charAt(0);
                char[] s = f.readLine().toCharArray();
                boolean flag = false;
                for(char i: s) {
                        if(i != c) {
                                flag = true;
                                break;
                        }
                }
                if(!flag) {
                        out.println(0);
                } else {
                        for(int i = 1; i <= n; i++) {
                                boolean valid = true;
                                for(int j = i; j <= n; j += i) {
                                        if(s[j-1] != c) {
                                                valid = false;
                                                break;
                                        }
                                }
                                if(valid) {
                                        flag = false;
                                        out.println(1);
                                        out.println(i);
                                        break;
                                }
                        }
                        if(flag) {
                                out.println(2);
                                out.println(n + " " + (n-1));
                        }
                }
        }
        f.close();
        out.close();
    }
}
