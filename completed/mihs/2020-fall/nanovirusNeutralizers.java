import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class nanovirusNeutralizers {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        int t = f.nextInt();
        char[][] country = new char[N][N];
        for(int i = 0; i < N; i++) {
            country[i] = f.next().toCharArray();
        }
        int startR = -1;
        int startC = -1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(country[i][j] == 'Z') {
                    startR = i;
                    startC = j;
                    break;
                }
            }
            if(startR >= 0) {
                break;
            }
        }
        Queue<Integer> queueR = new LinkedList<>();
        Queue<Integer> queueC = new LinkedList<>();
        queueR.add(startR);
        queueC.add(startC);
        int[] directionsR = {-1,0,0,1};
        int[] directionsC = {0,-1,1,0};
        for(int i = 0; i <= t; i++) {
            int size = queueR.size();
            for(int j = 0; j < size; j++) {
                int tempR = queueR.poll();
                int tempC = queueC.poll();
                for(int k = 0; k < 4; k++) {
                    int nextR = tempR+directionsR[k];
                    int nextC = tempC+directionsC[k];
                    if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || country[nextR][nextC] != '*') {
                        continue;
                    }
                    country[nextR][nextC] = 'Z';
                    queueR.add(nextR);
                    queueC.add(nextC);
                }
            }
        }
        out.println(queueR.size());
        f.close();
        out.close();
    }
}
