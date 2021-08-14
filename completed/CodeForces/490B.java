import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> total = new HashSet<>();
        HashSet<Integer> behind = new HashSet<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            total.add(a);
            total.add(b);
            behind.add(b);
            map.put(a, b);
        }
        total.removeAll(behind);
        int first = 0;
        for(int i: total) {
            first = i;
        }
        int[] res = new int[n+1];
        res[1] = first;
        for(int i = 2; i <= n; i++) {
            res[i] = map.get(res[i-2]);
        }
        out.print(res[1]);
        for(int i = 2; i <= n; i++) {
            out.print(" " + res[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}
