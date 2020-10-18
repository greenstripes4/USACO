import java.io.*;
import java.util.*;

public class Main {
    private static int minBootIndex;
    private static boolean[][] visited;
    private static void dfs(int[] snow, int[][] boots, int tile, int bootIndex) {
        if(visited[tile][bootIndex]) {
            return;
        }
        visited[tile][bootIndex] = true;
        if(tile == snow.length-1) {
            minBootIndex = Math.min(minBootIndex,bootIndex);
            return;
        }
        for(int j = 1; j <= boots[bootIndex][1] && tile+j < snow.length; j++) {
            if(snow[tile+j] <= boots[bootIndex][0]) {
                dfs(snow,boots,tile+j,bootIndex);
            }
        }
        for(int i = bootIndex+1; i < boots.length; i++) {
            if(snow[tile] <= boots[i][0]) {
                dfs(snow,boots,tile,i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("snowboots.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] snow = new int[N];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < N; i++) {
            snow[i] = Integer.parseInt(st.nextToken());
        }
        int[][] boots = new int[B][2];
        for(int i = 0; i < B; i++) {
            st = new StringTokenizer(f.readLine());
            boots[i][0] = Integer.parseInt(st.nextToken());
            boots[i][1] = Integer.parseInt(st.nextToken());
        }
        minBootIndex = N;
        visited = new boolean[N][B];
        dfs(snow,boots,0,0);
        out.println(minBootIndex);
        f.close();
        out.close();
    }
}
