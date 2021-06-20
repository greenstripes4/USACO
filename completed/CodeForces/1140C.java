import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] tb = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            tb[i][0] = Integer.parseInt(st.nextToken());
            tb[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tb, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return t1[1]-ints[1];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long total = 0;
        long max = 0;
        for(int[] i: tb) {
            queue.offer(i[0]);
            total += i[0];
            if(queue.size() > k) {
                total -= queue.poll();
            }
            max = Math.max(max, total*i[1]);
        }
        out.println(max);
        f.close();
        out.close();
    }
}