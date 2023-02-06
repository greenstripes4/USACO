import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("cereal.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] first = new int[N];
        int[] second = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            first[i] = Integer.parseInt(st.nextToken())-1;
            second[i] = Integer.parseInt(st.nextToken())-1;
        }
        int[] taken = new int[M];
        Arrays.fill(taken, -1);
        int[] res = new int[N+1];
        for(int i = N-1; i >= 0; i--) {
            int prev = taken[first[i]];
            int next = i;
            int item = first[i];
            while(next < prev && item == first[prev]) {
                taken[item] = next;
                next = prev;
                item = second[prev];
                prev = taken[item];
            }
            if(next < prev || prev < 0) {
                taken[item] = next;
            }
            res[i] = res[i+1];
            if(prev < 0) {
                res[i]++;
            }
        }
        for(int i = 0; i < N; i++) {
            out.println(res[i]);
        }
        f.close();
        out.close();
    }
}