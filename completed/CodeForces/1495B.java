import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] p = new int[n];
        for(int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        int[] left = new int[n];
        left[0] = 1;
        for(int i = 1; i < n; i++) {
            if(p[i] > p[i-1]) {
                left[i] = left[i-1]+1;
            } else {
                left[i] = 1;
            }
        }
        int[] right = new int[n];
        right[n-1] = 1;
        for(int i = n-2; i >= 0; i--) {
            if(p[i] > p[i+1]) {
                right[i] = right[i+1]+1;
            } else {
                right[i] = 1;
            }
        }
        int max = 0;
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            int temp = Math.max(left[i], right[i]);
            if(temp > max) {
                max = temp;
                flag = (Math.min(left[i], right[i])+1)/2*2 <= temp;
            } else if(temp == max) {
                flag = true;
            }
        }
        out.println(max%2 == 0 || flag ? 0 : 1);
        f.close();
        out.close();
    }
}
