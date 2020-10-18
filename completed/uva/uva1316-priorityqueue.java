import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            int n = f.nextInt();
            int[][] items = new int[n][2];
            for(int i = 0; i < n; i++) {
                items[i][0] = f.nextInt();
                items[i][1] = f.nextInt();
            }
            Arrays.sort(items, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[1]-t1[1];
                }
            });
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[0]-t1[0];
                }
            });
            int total = 0;
            for(int[] i: items) {
                if(minHeap.size() < i[1]) {
                    minHeap.offer(i);
                    total += i[0];
                } else if(minHeap.peek()[0] < i[0]) {
                    total -= minHeap.poll()[0];
                    minHeap.offer(i);
                    total += i[0];
                }
            }
            out.println(total);
        }
        f.close();
        out.close();
    }
}
