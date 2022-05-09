import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        int n = Integer.parseInt(f.readLine());
        int[] c = new int[n];
        for(int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(f.readLine());
        }
        int start = 0;
        int total = 0;
        for(int i = 0; i < n; i++) {
            total += c[i]-1;
            if(total < 0) {
                start = i+1;
                total = 0;
            }
        }
        Queue<Integer> cows = new LinkedList<>();
        long ans = 0;
        for(int i = start; i < n; i++) {
            for(int j = 0; j < c[i]; j++) {
                cows.offer(i);
            }
            int first = cows.poll();
            ans += ((long) (i-first))*(i-first);
        }
        for(int i = 0; i < start; i++) {
            for(int j = 0; j < c[i]; j++) {
                cows.offer(i);
            }
            int first = cows.poll();
            if(first > i) {
                ans += ((long) (i+n-first))*(i+n-first);
            } else {
                ans += ((long) (i-first))*(i-first);
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}