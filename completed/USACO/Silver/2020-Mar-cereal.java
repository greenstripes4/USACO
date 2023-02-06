/*
ID: strongh2
LANG: JAVA
PROG: socdist
TASK: socdist
 */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cereal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] favorites = new int[N][2];
        for(int i = 0 ; i < N; i++){
            StringTokenizer ithFavorites = new StringTokenizer(f.readLine());
            favorites[i][0] = Integer.parseInt(ithFavorites.nextToken());
            favorites[i][1] = Integer.parseInt(ithFavorites.nextToken());
        }
        for(int i = 0; i < N; i++) {
            HashSet<Integer> cereals = new HashSet<>();
            for (int j = 1; j <= M; j++) {
                cereals.add(j);
            }
            int total = 0;
            for(int j = i; j < N; j++){
                if(cereals.contains(favorites[j][0])){
                    cereals.remove(favorites[j][0]);
                    total++;
                } else if(cereals.contains(favorites[j][1])){
                    cereals.remove(favorites[j][1]);
                    total++;
                }
            }
            out.println(total);
        }
        f.close();
        out.close();
    }
}
