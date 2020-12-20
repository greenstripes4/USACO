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
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] adjacencyList = new ArrayList[N+1];
            for(int i = 1; i <= N; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            boolean[] importantStations = new boolean[N+1];
            for(int i = 0; i < S; i++) {
                StringTokenizer trainLine = new StringTokenizer(f.readLine());
                int lastStation = Integer.parseInt(trainLine.nextToken());
                if(adjacencyList[lastStation].size() > 0) {
                    importantStations[lastStation] = true;
                }
                while(true) {
                    int currentStation = Integer.parseInt(trainLine.nextToken());
                    if(currentStation == 0) {
                        break;
                    }
                    if(adjacencyList[currentStation].size() > 0) {
                        importantStations[currentStation] = true;
                    }
                    adjacencyList[lastStation].add(currentStation);
                    adjacencyList[currentStation].add(lastStation);
                    lastStation = currentStation;
                }
            }
            int numImportantStations = 0;
            for(boolean i: importantStations) {
                if(i) {
                    numImportantStations++;
                }
            }
            int X = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 1; i <= N; i++) {
                if(!importantStations[i]) {
                    continue;
                }
                LinkedList<Integer> queue = new LinkedList<>();
                boolean[] visited = new boolean[N+1];
                queue.add(i);
                visited[i] = true;
                int sum = 0;
                int distance = 0;
                int count = 0;
                while(!queue.isEmpty()) {
                    int size = queue.size();
                    boolean found = false;
                    for(int j = 0; j < size; j++) {
                        int currentStation = queue.poll();
                        if(importantStations[currentStation]) {
                            if(sum >= min) {
                                found = true;
                                break;
                            }
                            sum += distance;
                            count++;
                        }
                        if(count == numImportantStations) {
                            found = true;
                            break;
                        }
                        for(int k: adjacencyList[currentStation]) {
                            if(!visited[k]) {
                                queue.add(k);
                                visited[k] = true;
                            }
                        }
                    }
                    if(found) {
                        break;
                    }
                    distance++;
                }
                if(sum < min) {
                    X = i;
                    min = sum;
                }
            }
            out.println("Krochanska is in: " + X);
        }
        f.close();
        out.close();
    }
}
