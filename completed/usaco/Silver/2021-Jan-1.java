import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] perm = new int[N];
        for(int i = 0; i < N; i++) {
            perm[i] = i;
        }
        ArrayList<HashSet<Integer>> visited = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            visited.add(new HashSet<>());
            visited.get(i).add(i);
        }
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            visited.get(perm[a]).add(b);
            visited.get(perm[b]).add(a);
            int temp = perm[a];
            perm[a] = perm[b];
            perm[b] = temp;
        }
        int[] next = new int[N];
        for(int i = 0; i < N; i++) {
            next[perm[i]] = i;
        }
        int[] res = new int[N];
        Arrays.fill(res, -1);
        for(int i = 0; i < N; i++) {
            if(res[i] < 0) {
                int j = next[i];
                HashSet<Integer> set = visited.get(i);
                while(j != i) {
                    set.addAll(visited.get(j));
                    j = next[j];
                }
                res[i] = set.size();
                j = next[i];
                while(j != i) {
                    res[j] = set.size();
                    j = next[j];
                }
            }
        }
        for(int i: res) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}
