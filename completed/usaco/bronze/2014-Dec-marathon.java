import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("marathon.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] checkpoints = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] cp = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            checkpoints[i] = cp;
        }
        int distance = 0;
        for(int j = 1; j < N; j++){
            distance += (Math.abs(checkpoints[j][0] - checkpoints[j-1][0]) + Math.abs(checkpoints[j][1] - checkpoints[j-1][1]));
        }
        int min = distance;
        for(int i = 1; i < N-1; i++){
            int oldDistance = Math.abs(checkpoints[i][0] - checkpoints[i-1][0]) + Math.abs(checkpoints[i][1] - checkpoints[i-1][1]) + Math.abs(checkpoints[i+1][0] - checkpoints[i][0]) + Math.abs(checkpoints[i+1][1] - checkpoints[i][1]);
            int newDistance = Math.abs(checkpoints[i+1][0] - checkpoints[i-1][0]) + Math.abs(checkpoints[i+1][1] - checkpoints[i-1][1]);
            int temp = distance - (oldDistance - newDistance);
            min = Math.min(temp,min);
        }
        out.println(min);
        f.close();
        out.close();
    }
}
