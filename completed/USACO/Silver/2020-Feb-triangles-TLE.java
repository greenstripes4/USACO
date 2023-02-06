/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] points = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        int totalArea = 0;
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                for(int k = j+1; k < N; k++){
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    int length = -1;
                    int width = -1;
                    if(x1 == x2){
                        length = Math.abs(x3-x1);
                    } else if(x2 == x3) {
                        length = Math.abs(x1-x2);
                    } else if(x1 == x3) {
                        length = Math.abs(x2-x1);
                    }
                    if(y1 == y2){
                        width = Math.abs(y3-y1);
                    } else if(y2 == y3) {
                        width = Math.abs(y1-y2);
                    } else if(y1 == y3) {
                        width = Math.abs(y2-y1);
                    }
                    if(length != -1 && width != -1) {
                        totalArea += length * width;
                        totalArea %= 1000000007;
                    }
                }
            }
        }
        out.println(totalArea);
        out.close();
        f.close();
    }
}
