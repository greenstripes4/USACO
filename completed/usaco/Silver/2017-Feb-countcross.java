import java.io.*;
import java.util.*;

public class Main {
    private static boolean[][][][] roadConnectedFields;
    private static int[][] directions = {{-1,0},{0,-1},{0,1},{1,0}};
    private static void getReachable(int r, int c, boolean[][] reachable) {
        reachable[r][c] = true;
        for(int[] i: directions) {
            int nextR = r+i[0];
            int nextC = c+i[1];
            if(nextR < 0 || nextC < 0 || nextR >= reachable.length || nextC >= reachable.length || reachable[nextR][nextC] || roadConnectedFields[r][c][nextR][nextC]) {
                continue;
            }
            getReachable(nextR,nextC,reachable);
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("countcross.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        roadConnectedFields = new boolean[N][N][N][N];
        for(int i = 0; i < R; i++) {
            StringTokenizer road = new StringTokenizer(f.readLine());
            int r1 = Integer.parseInt(road.nextToken())-1;
            int c1 = Integer.parseInt(road.nextToken())-1;
            int r2 = Integer.parseInt(road.nextToken())-1;
            int c2 = Integer.parseInt(road.nextToken())-1;
            roadConnectedFields[r1][c1][r2][c2] = true;
            roadConnectedFields[r2][c2][r1][c1] = true;
        }
        int[][] cows = new int[K][2];
        int distantPairs = 0;
        for(int i = 0; i < K; i++) {
            StringTokenizer cow = new StringTokenizer(f.readLine());
            int cowR = Integer.parseInt(cow.nextToken())-1;
            int cowC = Integer.parseInt(cow.nextToken())-1;
            boolean[][] reachable = new boolean[N][N];
            getReachable(cowR,cowC,reachable);
            for(int j = 0; j < i; j++) {
                if(!reachable[cows[j][0]][cows[j][1]]) {
                    distantPairs++;
                }
            }
            cows[i][0] = cowR;
            cows[i][1] = cowC;
        }
        out.println(distantPairs);
        f.close();
        out.close();
    }
}
