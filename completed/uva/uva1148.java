import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            f.readLine();
            if(t > 0) {
                out.println();
            }
            int N = Integer.parseInt(f.readLine());
            ArrayList<Integer>[] adjacencyList = new ArrayList[N];
            for(int i = 0; i < N; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int c = Integer.parseInt(st.nextToken());
                int nc = Integer.parseInt(st.nextToken());
                for(int j = 0; j < nc; j++) {
                    int knownC = Integer.parseInt(st.nextToken());
                    adjacencyList[c].add(knownC);
                }
            }
            StringTokenizer st = new StringTokenizer(f.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(c1);
            int steps = 0;
            boolean found = false;
            boolean[] seen = new boolean[N];
            seen[c1] = true;
            while(!found) {
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int temp = queue.poll();
                    if(temp == c2) {
                        out.println(c1 + " " + c2 + " " + (steps-1));
                        found = true;
                        break;
                    }
                    for(int j: adjacencyList[temp]) {
                        if(!seen[j]) {
                            queue.offer(j);
                            seen[j] = true;
                        }
                    }
                }
                steps++;
            }
        }
        f.close();
        out.close();
    }
}
