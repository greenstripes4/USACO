/*
ID: strongh2
LANG: JAVA
PROG: castle
TASK: castle
 */

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class castle {
    public static int size;
    public static void dfs(int[][] stats, int[][] rooms, int roomNumber, int r, int c){
        rooms[r][c] = roomNumber;
        size++;
        if(c-1 >= 0 && (stats[r][c] & 1) == 0 && rooms[r][c-1] == 0){
            dfs(stats,rooms,roomNumber,r,c-1);
        }
        if(r-1 >= 0 && (stats[r][c] & 2) == 0 && rooms[r-1][c] == 0){
            dfs(stats,rooms,roomNumber,r-1,c);
        }
        if(c+1 < stats[0].length && (stats[r][c] & 4) == 0 && rooms[r][c+1] == 0){
            dfs(stats,rooms,roomNumber,r,c+1);
        }
        if(r+1 < stats.length && (stats[r][c] & 8) == 0 && rooms[r+1][c] == 0){
            dfs(stats,rooms,roomNumber,r+1,c);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] stats = new int[N][M];
        for(int i = 0; i < N; i++){
            StringTokenizer line = new StringTokenizer(f.readLine());
            for(int j = 0; j < M; j++){
                stats[i][j] = Integer.parseInt(line.nextToken());
            }
        }
        int[][] rooms = new int[N][M];
        int roomCount = 0;
        int maxSize = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(rooms[i][j] == 0){
                    roomCount++;
                    size = 0;
                    dfs(stats,rooms,roomCount,i,j);
                    maxSize = Math.max(maxSize,size);
                    map.put(roomCount,size);
                }
            }
        }
        out.println(roomCount);
        out.println(maxSize);
        int maxChangedSize = 0;
        int r = 0;
        int c = 0;
        char dir = ' ';
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(j-1 >= 0 && rooms[i][j-1] != rooms[i][j]){
                    int size = map.get(rooms[i][j-1])+map.get(rooms[i][j]);
                    if(size > maxChangedSize || (size == maxChangedSize && (j < c || (j == c && (i+1 > r))))) {
                        maxChangedSize = map.get(rooms[i][j - 1]) + map.get(rooms[i][j]);
                        r = i + 1;
                        c = j;
                        dir = 'E';
                    }
                }
                if(i+1 < N && rooms[i+1][j] != rooms[i][j]){
                    int size = map.get(rooms[i+1][j])+map.get(rooms[i][j]);
                    if(size > maxChangedSize || (size == maxChangedSize && (j+1 < c || (j+1 == c && (i+2 > r))))) {
                        maxChangedSize = map.get(rooms[i + 1][j]) + map.get(rooms[i][j]);
                        r = i + 2;
                        c = j + 1;
                        dir = 'N';
                    }
                }
            }
        }
        out.println(maxChangedSize);
        out.println(r + " " + c + " " + dir);
        f.close();
        out.close();
    }
}
