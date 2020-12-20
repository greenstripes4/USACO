import java.io.*;
import java.util.*;

public class Main{
    private static int count;
    private static void floodFill(ArrayList<Integer>[] adjacencyList, boolean[] visited, int source) {
        visited[source] = true;
        count++;
        for(int i: adjacencyList[source]) {
            if(!visited[i]) {
                floodFill(adjacencyList, visited, i);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] adjacencyList = new ArrayList[N+1];
            for(int i = 1; i <= N; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(f.readLine());
                int V = Integer.parseInt(st.nextToken());
                int W = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                adjacencyList[V].add(W);
                if(P == 2) {
                    adjacencyList[W].add(V);
                }
            }
            boolean connected = true;
            for(int i = 1; i <= N; i++) {
                count = 0;
                floodFill(adjacencyList, new boolean[N+1], i);
                if(count < N) {
                    out.println(0);
                    connected = false;
                    break;
                }
            }
            if(connected) {
                out.println(1);
            }
        }
        f.close();
        out.close();
    }
}
