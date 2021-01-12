import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int v = Integer.parseInt(f.readLine());
        int[] a = new int[9];
        StringTokenizer st = new StringTokenizer(f.readLine());
        int digit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 9; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if(a[i] <= min) {
                digit = i+1;
                min = a[i];
            }
        }
        int max = v/min;
        v -= a[digit-1]*max;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(v > 0 && index < max) {
            int replacement = -1;
            for(int i = 8; i >= digit-1; i--) {
                int cost = a[i]-a[digit-1];
                if(cost <= v) {
                    replacement = i+1;
                    v -= cost;
                    break;
                }
            }
            if(replacement < 0) {
                break;
            }
            sb.append(replacement);
            index++;
        }
        for(int i = index; i < max; i++) {
            sb.append(digit);
        }
        if(sb.length() == 0) {
            out.println(-1);
        } else {
            out.println(sb);
        }
        f.close();
        out.close();
    }
}
