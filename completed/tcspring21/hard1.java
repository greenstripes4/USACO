import java.io.*;
import java.util.*;

public class program {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        int N = f.nextInt();
        int M = f.nextInt();
        int Q = f.nextInt();
        int[] d = new int[N+1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return d[t1]-d[integer];
            }
        });
        boolean[] processed = new boolean[N+1];
        for(int i = 1; i <= M; i++) {
            int c = f.nextInt();
            d[c] = f.nextInt();
            queue.offer(c);
            processed[c] = true;
        }
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(N+1);
        for(int i = 0; i <= N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < Q; i++) {
            int a = f.nextInt();
            int b = f.nextInt();
            if(a == 1 || b == 1) {
                continue;
            }
            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int i: adjacencyList.get(temp)) {
                if(!processed[i]) {
                    d[i] = d[temp]/2;
                    queue.offer(i);
                }
            }
        }
        PriorityQueue<Integer> idx = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                if(d[t1] == d[integer]) {
                    return integer-t1;
                }
                return d[t1]-d[integer];
            }
        });
        for(int i = 2; i <= N; i++) {
            idx.offer(i);
        }
        while(!idx.isEmpty()) {
            int c = idx.poll();
            System.out.println(c + " " + d[c]);
        }
        f.close();
    }
}
