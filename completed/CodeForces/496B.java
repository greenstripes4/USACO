import java.io.*;
import java.util.*;

public class Main {
    private static String solve(int[] cur) {
        StringBuilder sb = new StringBuilder();
        for(int i: cur) {
            sb.append(i);
        }
        String min = sb.toString();
        for(int i = 0; i < cur.length; i++) {
            StringBuilder temp = new StringBuilder();
            for(int j = i; j < cur.length; j++) {
                temp.append(cur[j]);
            }
            for(int j = 0; j < i; j++) {
                temp.append(cur[j]);
            }
            String temp2 = temp.toString();
            if(temp2.compareTo(min) < 0) {
                min = temp2;
            }
        }
        return min;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        char[] temp = f.readLine().toCharArray();
        int[] init = new int[n];
        for(int i = 0; i < n; i++) {
            init[i] = temp[i]-'0';
        }
        String min = new String(temp);
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < n; j++) {
                init[j] = (init[j]+1)%10;
            }
            String cur = solve(init);
            if(cur.compareTo(min) < 0) {
                min = cur;
            }
        }
        out.println(min);
        f.close();
        out.close();
    }
}