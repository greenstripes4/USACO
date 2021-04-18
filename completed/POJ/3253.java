import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0; i < N; i++) {
            queue.offer(Integer.parseInt(f.readLine()));
        }
        long sum = 0;
        while(queue.size() > 1) {
            int temp = queue.poll()+queue.poll();
            sum += temp;
            queue.offer(temp);
        }
        out.println(sum);
        f.close();
        out.close();
    }
}