import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while(queue.size() > 1) {
            queue.offer(queue.poll());
            out.print(queue.poll() + " ");
        }
        out.println(queue.poll());
        f.close();
        out.close();
    }
}