import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("blist.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] startEndBuckets = new int[N][3];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            startEndBuckets[i][0] = Integer.parseInt(st.nextToken());
            startEndBuckets[i][1] = Integer.parseInt(st.nextToken());
            startEndBuckets[i][2] = Integer.parseInt(st.nextToken());
        }
        int maxBuckets = 0;
        for(int j = 1; j < 1001; j++){
            int bucketsNeeded = 0;
            for(int k = 0; k < N; k++){
                if(j >= startEndBuckets[k][0] && j <= startEndBuckets[k][1]){
                    bucketsNeeded += startEndBuckets[k][2];
                }
            }
            if(bucketsNeeded > maxBuckets){
                maxBuckets = bucketsNeeded;
            }
        }
        out.println(maxBuckets);
        f.close();
        out.close();
    }
}