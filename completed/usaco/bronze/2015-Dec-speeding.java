import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        StringTokenizer segments = new StringTokenizer(f.readLine());
        int speedLimits = Integer.parseInt(segments.nextToken());
        int bessie = Integer.parseInt(segments.nextToken());
        int[] roadLimits = new int[100];
        int[] bessieSpeeds = new int[100];
        int ind = 0;
        int ind2 = 0;
        for(int i = 0; i < speedLimits; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int length = Integer.parseInt(st.nextToken());
            ind2 += length;
            int limit = Integer.parseInt(st.nextToken());
            for(int j = ind; j < ind2; j++){
                roadLimits[j] = limit;
            }
            ind += length;
        }
        ind = 0;
        ind2 = 0;
        for(int k = 0; k < bessie; k++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int length = Integer.parseInt(st.nextToken());
            ind2 += length;
            int limit = Integer.parseInt(st.nextToken());
            for(int l = ind; l < ind2; l++){
                bessieSpeeds[l] = limit;
            }
            ind += length;
        }
        int max = 0;
        for(int m = 0; m < 100; m++){
            if(roadLimits[m] < bessieSpeeds[m]){
                max = Math.max(max, bessieSpeeds[m] - roadLimits[m]);
            }
        }
        out.println(max);
        out.close();
        f.close();
    }
}
