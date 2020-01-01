/*
ID: strongh2
LANG: JAVA
PROG: gymnastics
TASK: gymnastics
 */

import java.io.*;
import java.util.StringTokenizer;

public class gymnastics {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] ordering = new int[K][N];
        for(int i = 0; i < K; i++){
            StringTokenizer cows = new StringTokenizer(f.readLine());
            for(int j = 0; j < N; j++){
                ordering[i][j] = Integer.parseInt(cows.nextToken());
            }
        }
        int[][] pairs = new int[N*N][2];
        int ind = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                pairs[ind][0] = i;
                pairs[ind][1] = j;
                ind++;
            }
        }
        int count = 0;
        for(int[] i: pairs){
            if(i[0] != i[1]) {
                int firstInd = -1;
                int secondInd = -1;
                boolean validPair = true;
                for (int j = 0; j < K; j++) {
                    for (int k = 0; k < N; k++) {
                        if (ordering[j][k] == i[0]) {
                            firstInd = k;
                        } else if (ordering[j][k] == i[1]){
                            secondInd = k;
                        }
                    }
                    if(firstInd > secondInd){
                        validPair = false;
                        break;
                    }
                }
                if(validPair){
                    count++;
                }
            }
        }
        out.println(count);
        out.close();
        f.close();
    }
}
