import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] road = new int[100];
        int[] bessie = new int[100];
        int ind = 0;
        int ind2 = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer segment = new StringTokenizer(f.readLine());
            int length = Integer.parseInt(segment.nextToken());
            ind2 += length;
            int speed_limit = Integer.parseInt(segment.nextToken());
            for(int j = ind; j < ind2; j++){
                road[j] = speed_limit;
            }
            ind = ind2;
        }
        ind = 0;
        ind2 = 0;
        for(int k = 0; k < m; k++){
            StringTokenizer segment = new StringTokenizer(f.readLine());
            int length = Integer.parseInt(segment.nextToken());
            ind2 += length;
            int speed_limit = Integer.parseInt(segment.nextToken());
            for(int j = ind; j < ind2; j++){
                bessie[j] = speed_limit;
            }
            ind = ind2;
        }
        int max = 0;
        for(int l = 0; l < 100; l++){
            if(bessie[l] - road[l] > max){
                max = bessie[l] - road[l];
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}
