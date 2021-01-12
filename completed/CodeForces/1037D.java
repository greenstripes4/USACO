import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        ArrayList<Integer>[] adjacencyList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            adjacencyList[x].add(y);
            adjacencyList[y].add(x);
        }
        int[] order = new int[n];
        int[] position = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(st.nextToken())-1;
            position[order[i]] = i;
        }
        for(int i = 0; i < n; i++) {
            Collections.sort(adjacencyList[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return position[integer]-position[t1];
                }
            });
        }
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int index = 0;
        boolean valid = true;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            if(temp != order[index++]) {
                valid = false;
                break;
            }
            for(int i: adjacencyList[temp]) {
                if(!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        out.println(valid ? "Yes" : "No");
        f.close();
        out.close();
    }
}