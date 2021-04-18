import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        PriorityQueue<Double> queue = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double aDouble, Double t1) {
                return Double.compare(t1, aDouble);
            }
        });
        for(int i = 0; i < N; i++) {
            queue.offer(Double.parseDouble(f.readLine()));
        }
        while(queue.size() > 1) {
            queue.offer(2*Math.sqrt(queue.poll()*queue.poll()));
        }
        out.printf("%.3f\n", queue.poll());
        f.close();
        out.close();
    }
}
