import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] state = new int[n];
            char[] temp = f.readLine().toCharArray();
            boolean flag = false;
            for(int i = 0; i < n; i++) {
                state[i] = temp[i]-'0';
                if(state[i] == 1) {
                    flag = true;
                }
            }
            if(!flag) {
                out.println(new String(temp));
                continue;
            }
            for(int i = 0; i < Math.min(m, n-1); i++) {
                int[] next = new int[n];
                for(int j = 0; j < n; j++) {
                    if(state[j] == 0) {
                        if(j == 0) {
                            if(state[j+1] == 1) {
                                next[j] = 1;
                            }
                        } else if(j == n-1) {
                            if(state[j-1] == 1) {
                                next[j] = 1;
                            }
                        } else if(state[j-1]+state[j+1] == 1) {
                            next[j] = 1;
                        }
                    } else {
                        next[j] = 1;
                    }
                }
                state = next;
            }
            for(int i: state) {
                out.print(i);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}