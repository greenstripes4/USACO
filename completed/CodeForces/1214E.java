import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] d = new int[n];
        ArrayList<Integer> order = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
            order.add(i);
        }
        Collections.sort(order, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return d[o2]-d[o1];
            }
        });
        for(int i = 0; i < n; i++) {
            order.set(i, 2*order.get(i)+1);
        }
        for(int i = 0; i < n-1; i++) {
            out.println(order.get(i) + " " + order.get(i+1));
        }
        for(int i = 0; i < n; i++) {
            int dist = d[order.get(i)/2];
            int next = order.get(i)+1;
            out.println(order.get(i+dist-1) + " " + next);
            if(i+dist >= order.size()) {
                order.add(next);
            }
        }
        f.close();
        out.close();
    }
}
