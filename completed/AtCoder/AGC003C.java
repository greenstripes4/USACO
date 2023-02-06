import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(f.readLine());
            set.add(A[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for(int i: set) {
            map.put(i, idx++);
        }
        for(int i = 0; i < N; i++) {
            A[i] = map.get(A[i]);
        }
        int ans = 0;
        for(int i = 0; i < N; i += 2) {
            if(A[i]%2 == 0) {
                ans++;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
