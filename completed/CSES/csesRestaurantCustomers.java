import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] events = new int[2*n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            events[2*i][0] = Integer.parseInt(st.nextToken());
            events[2*i][1] = 1;
            events[2*i+1][0] = Integer.parseInt(st.nextToken());
            events[2*i+1][1] = -1;
        }
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[0] == t1[0]) {
                    return ints[1]-t1[1];
                }
                return ints[0]-t1[0];
            }
        });
        int max = 0;
        int count = 0;
        for(int[] i: events) {
            count += i[1];
            max = Math.max(max, count);
        }
        out.println(max);
        f.close();
        out.close();
    }
}