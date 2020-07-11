import java.io.*;
import java.util.*;

public class Main{
    private static int gold;
    private static void dfs(char[][] map, int r, int c) {
        if(map[r][c] == 'G') {
            gold++;
        }
        map[r][c] = '#';
        int[] directionsX = {0,0,-1,1};
        int[] directionsY = {-1,1,0,0};
        for(int i = 0; i < 4; i++) {
            int nextR = r+directionsX[i];
            int nextC = c+directionsY[i];
            if(nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map[0].length || map[nextR][nextC] == '#') {
                continue;
            }
            if(map[nextR][nextC] == 'T') {
                return;
            }
        }
        for(int i = 0; i < 4; i++) {
            int nextR = r+directionsX[i];
            int nextC = c+directionsY[i];
            if(nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map[0].length || map[nextR][nextC] == '#') {
                continue;
            }
            dfs(map,nextR,nextC);
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];
            for(int i = 0; i < H; i++) {
                map[i] = f.readLine().toCharArray();
            }
            int playerR = -1;
            int playerC = -1;
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    if(map[i][j] == 'P') {
                        playerR = i;
                        playerC = j;
                        break;
                    }
                }
                if(playerR != -1) {
                    break;
                }
            }
            gold = 0;
            dfs(map,playerR,playerC);
            out.println(gold);
        }
        f.close();
        out.close();
    }
}
