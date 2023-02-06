import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("swap.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] perm = new int[N];
        for(int i = 0; i < N; i++) {
            perm[i] = i;
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            int L = Integer.parseInt(st.nextToken())-1;
            int R = Integer.parseInt(st.nextToken())-1;
            while(L < R) {
                int temp = perm[L];
                perm[L] = perm[R];
                perm[R] = temp;
                L++;
                R--;
            }
        }
        int[] next = new int[N];
        for(int i = 0; i < N; i++) {
            next[perm[i]] = i;
        }
        int[] res = new int[N];
        Arrays.fill(res, -1);
        for(int i = 0; i < N; i++) {
            if(res[i] < 0) {
                ArrayList<Integer> cycle = new ArrayList<>();
                int j = i;
                while(true) {
                    cycle.add(j);
                    j = next[j];
                    if(j == i) {
                        break;
                    }
                }
                for(int k = 0; k < cycle.size(); k++) {
                    res[cycle.get((k+K)%cycle.size())] = cycle.get(k);
                }
            }
        }
        for(int i: res) {
            out.println(i+1);
        }
        f.close();
        out.close();
    }
}
