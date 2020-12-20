import java.io.*;
import java.util.*;

public class Main{
    private static class Triple implements Comparable<Triple> {
        private int sum;
        private int ind1;
        private int ind2;
        private Triple(int sum, int ind1, int ind2) {
            this.sum = sum;
            this.ind1 = ind1;
            this.ind2 = ind2;
        }
        @Override
        public int compareTo(Triple o) {
            return sum-o.sum;
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            int k = Integer.parseInt(input);
            int[] current = new int[k];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int i = 0; i < k; i++) {
                current[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(current);
            for(int i = 1; i < k; i++) {
                int[] next = new int[k];
                st = new StringTokenizer(f.readLine());
                for(int j = 0; j < k; j++) {
                    next[j] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(next);
                PriorityQueue<Triple> minHeap = new PriorityQueue<>();
                for(int j = 0; j < k; j++) {
                    minHeap.add(new Triple(current[0]+next[j], 0, j));
                }
                int[] nextCurrent = new int[k];
                for(int j = 0; j < k; j++) {
                    Triple min = minHeap.poll();
                    nextCurrent[j] = min.sum;
                    if(min.ind1+1 < k) {
                        minHeap.add(new Triple(current[min.ind1+1]+next[min.ind2], min.ind1+1, min.ind2));
                    }
                }
                current = nextCurrent;
            }
            out.print(current[0]);
            for(int i = 1; i < k; i++) {
                out.print(" " + current[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
