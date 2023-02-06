import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] breeds = new int[N+1];
        for(int i = 1; i <= N; i++){
            breeds[i] = Integer.parseInt(f.readLine());
        }
        int[][] counts = new int[N+1][3];
        int h = 0;
        int g = 0;
        int j = 0;
        for(int i = 1; i <= N; i++) {
            if (breeds[i] == 1) {
                h++;
            } else if (breeds[i] == 2) {
                g++;
            } else {
                j++;
            }
            counts[i][0] = h;
            counts[i][1] = g;
            counts[i][2] = j;
        }
        for(int i = 0; i < Q; i++){
            StringTokenizer interval = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(interval.nextToken());
            int b = Integer.parseInt(interval.nextToken());
            out.println((counts[b][0]-counts[a-1][0])+" "+(counts[b][1]-counts[a-1][1])+" "+(counts[b][2]-counts[a-1][2]));
        }
        f.close();
        out.close();
    }
}
