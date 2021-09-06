import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int H = Integer.parseInt(st.nextToken());
        if(!st.hasMoreTokens()) {
            out.println((1L<<(H+1))-1);
        } else {
            char[] d = st.nextToken().toCharArray();
            int cur = 1;
            for(char i: d) {
                cur *= 2;
                if(i == 'R') {
                    cur++;
                }
            }
            out.println((1L<<(H+1))-cur);
        }
        f.close();
        out.close();
    }
}