import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n >= m) {
            out.println(n-m);
        } else {
            LinkedList<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[2*m+1];
            queue.offer(n);
            visited[n] = true;
            int steps = 0;
            while(!queue.isEmpty()) {
                boolean found = false;
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    int temp = queue.poll();
                    if(temp == m) {
                        found = true;
                        break;
                    }
                    if(temp*2 <= 2*m && !visited[temp*2]) {
                        queue.offer(temp*2);
                        visited[temp*2] = true;
                    }
                    if(temp-1 >= 0 && !visited[temp-1]) {
                        queue.offer(temp-1);
                        visited[temp-1] = true;
                    }
                }
                if(found) {
                    break;
                }
                steps++;
            }
            out.println(steps);
        }
        f.close();
        out.close();
    }
}
