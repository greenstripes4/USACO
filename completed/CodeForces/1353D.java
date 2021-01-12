import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            int[] arr = new int[n];
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    if(ints[1]-ints[0] == t1[1]-t1[0]) {
                        return ints[0]-t1[0];
                    }
                    return t1[1]-t1[0]-ints[1]+ints[0];
                }
            });
            queue.offer(new int[]{0, n-1});
            for(int j = 0; j < n; j++) {
                int[] next = queue.poll();
                arr[(next[0]+next[1])/2] = j+1;
                int[] left = {next[0], (next[0]+next[1])/2-1};
                if(left[0] <= left[1]) {
                    queue.offer(left);
                }
                int[] right = {(next[0]+next[1])/2+1, next[1]};
                if(right[0] <= right[1]) {
                    queue.offer(right);
                }
            }
            out.print(arr[0]);
            for(int j = 1; j < n; j++) {
                out.print(" " + arr[j]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}