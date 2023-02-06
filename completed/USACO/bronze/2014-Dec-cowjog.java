import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowjog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjog.out")));
        int N = Integer.parseInt(f.readLine());
        int[] speeds = new int[N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            st.nextToken();
            speeds[i] = Integer.parseInt(st.nextToken());
        }
        int groups = 0;
        int slowest = N-1;
        for(int i = N-1; i >= 0; i--){
            if(speeds[i] <= speeds[slowest]){
                groups++;
                slowest = i;
            }
        }
        out.println(groups);
        f.close();
        out.close();
    }
}
