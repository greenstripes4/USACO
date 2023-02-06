import java.io.*;
import java.util.*;

public class Main {
    private static void dfs(ArrayList<Integer>[] adjacencyList, int[] blame, int start) {
        blame[start] = adjacencyList[start].size();
        for(int i: adjacencyList[start]) {
            if(blame[i] == -1) {
                dfs(adjacencyList, blame, i);
            }
            blame[start] += blame[i];
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[][] cows = new int[N][2];
        ArrayList<Integer> east = new ArrayList<>();
        ArrayList<Integer> north = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            char direction = st.nextToken().charAt(0);
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
            if(direction == 'E') {
                east.add(i);
            } else {
                north.add(i);
            }
        }
        Collections.sort(east, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return cows[integer][1]-cows[t1][1];
            }
        });
        Collections.sort(north, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return cows[integer][0]-cows[t1][0];
            }
        });
        boolean[] stopped = new boolean[N];
        ArrayList<Integer>[] adjacencyList = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i: east) {
            for(int j: north) {
                if(stopped[i]) {
                    break;
                }
                if(stopped[j] || cows[i][0] > cows[j][0] || cows[i][1] < cows[j][1]) {
                    continue;
                }
                int distanceX = cows[j][0]-cows[i][0];
                int distanceY = cows[i][1]-cows[j][1];
                if(distanceX < distanceY) {
                    stopped[j] = true;
                    adjacencyList[i].add(j);
                } else if(distanceX > distanceY) {
                    stopped[i] = true;
                    adjacencyList[j].add(i);
                }
            }
        }
        int[] blame = new int[N];
        Arrays.fill(blame, -1);
        for(int i = 0; i < N; i++) {
            if(blame[i] == -1) {
                dfs(adjacencyList, blame, i);
            }
        }
        for(int i = 0; i < N; i++) {
            out.println(blame[i]);
        }
        f.close();
        out.close();
    }
}
