import java.io.*;
import java.util.*;

//http://www.cs.ucf.edu/~dmarino/progcontests/mysols/highschool/usaco/2015/bronze/reduce.java
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("reduce.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
        int N = Integer.parseInt(f.readLine());
        int minX = -1;
        int secondToMinX = -1;
        int maxX = -1;
        int secondToMaxX = -1;
        int minY = -1;
        int secondToMinY = -1;
        int maxY = -1;
        int secondToMaxY = -1;
        int[][] cows = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            cows[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            if(minX == -1 || cows[i][0] <= cows[minX][0]){
                secondToMinX = minX;
                minX = i;
            } else if (secondToMinX == -1 || cows[i][0] < cows[secondToMinX][0]) {
                secondToMinX = i;
            }
            if(minY == -1 || cows[i][1] <= cows[minY][1]){
                secondToMinY = minY;
                minY = i;
            } else if (secondToMinY == -1 || cows[i][1] < cows[secondToMinY][1]) {
                secondToMinY = i;
            }
            if(maxX == -1 || cows[i][0] >= cows[maxX][0]){
                secondToMaxX = maxX;
                maxX = i;
            } else if (secondToMaxX == -1 || cows[i][0] > cows[secondToMaxX][0]) {
                secondToMaxX = i;
            }
            if(maxY == -1 || cows[i][1] >= cows[maxY][1]){
                secondToMaxY = maxY;
                maxY = i;
            } else if (secondToMaxY == -1 || cows[i][1] > cows[secondToMaxY][1]) {
                secondToMaxY = i;
            }
        }
        int removeMinXandMinY = Integer.MAX_VALUE;
        int removeMinXandMaxY = Integer.MAX_VALUE;
        int removeMaxXandMinY = Integer.MAX_VALUE;
        int removeMaxXandMaxY = Integer.MAX_VALUE;
        if(minX == minY){
            removeMinXandMinY = (cows[maxX][0] - cows[secondToMinX][0]) * (cows[maxY][1] - cows[secondToMinY][1]);
        }
        if(minX == maxY){
            removeMinXandMaxY = (cows[maxX][0] - cows[secondToMinX][0]) * (cows[secondToMaxY][1] - cows[minY][1]);
        }
        if(maxX == minY){
            removeMaxXandMinY = (cows[secondToMaxX][0] - cows[minX][0]) * (cows[maxY][1] - cows[secondToMinY][1]);
        }
        if(maxX == maxY){
            removeMaxXandMaxY = (cows[secondToMaxX][0] - cows[minX][0]) * (cows[secondToMaxY][1] - cows[minY][1]);
        }

        int removeMinX = (cows[maxX][0] - cows[secondToMinX][0]) * (cows[maxY][1] - cows[minY][1]);
        int removeMaxX = (cows[secondToMaxX][0] - cows[minX][0]) * (cows[maxY][1] - cows[minY][1]);
        int removeMinY = (cows[maxX][0] - cows[minX][0]) * (cows[maxY][1] - cows[secondToMinY][1]);
        int removeMaxY = (cows[maxX][0] - cows[minX][0]) * (cows[secondToMaxY][1] - cows[minY][1]);
        int solo = Math.min(Math.min(removeMaxX, removeMaxY), Math.min(removeMinX, removeMinY));
        int pair = Math.min(Math.min(removeMinXandMinY, removeMinXandMaxY), Math.min(removeMaxXandMinY, removeMaxXandMaxY));
        out.println(Math.min(solo, pair));
        f.close();
        out.close();
    }
}
