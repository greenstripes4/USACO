import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("cowqueue.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] times = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return 0;
                }
                return o1[0] > o2[0] ? 1:-1;
            }
        });
        int time = 0;
        for(int[] j: times){
            time = Math.max(time,j[0]) + j[1];
        }
        out.println(time);
        f.close();
        out.close();
    }
}
