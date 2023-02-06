import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i = 0; i < n; i++){
            StringTokenizer pos = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(pos.nextToken());
            y[i] = Integer.parseInt(pos.nextToken());
        }
        int M = n;
        for(int i = 0; i < n; i++){
            int xPivot = x[i]+1;
            for(int j = 0; j < n; j++){
                int yPivot = y[j]+1;
                int quadrant1 = 0;
                int quadrant2 = 0;
                int quadrant3 = 0;
                int quadrant4 = 0;
                for(int k = 0; k < n; k++){
                    if(x[k] > xPivot && y[k] > yPivot){
                        quadrant1++;
                    } else if(x[k] > xPivot && y[k] < yPivot){
                        quadrant2++;
                    } else if(x[k] < xPivot && y[k] > yPivot){
                        quadrant3++;
                    } else {
                        quadrant4++;
                    }
                }
                if(Math.max(Math.max(quadrant1,quadrant2),Math.max(quadrant3,quadrant4)) < M){
                    M = Math.max(Math.max(quadrant1,quadrant2),Math.max(quadrant3,quadrant4));
                }
            }
        }
        out.println(M);
        out.close();
        f.close();
    }
}
