import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            ArrayList<ArrayList<int[]>> arr = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                arr.add(new ArrayList<>());
            }
            for(int i = 1; i <= n; i++) {
                int b = Integer.parseInt(st.nextToken());
                if(b == 0) {
                    arr.get(i+1).add(new int[]{n, i-1});
                } else {
                    arr.get(i/(b+1)+1).add(new int[]{i/b, i-1});
                }
            }
            int[] a = new int[n];
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
            for(int i = 1; i <= n; i++) {
                for(int[] j: arr.get(i)) {
                    queue.offer(j);
                }
                a[queue.poll()[1]] = i;
            }
            out.print(a[0]);
            for(int i = 1; i < n; i++) {
                out.print(" " + a[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}