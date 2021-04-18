import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] events = new int[2*n][3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            events[2*i][0] = Integer.parseInt(st.nextToken());
            events[2*i][1] = 1;
            events[2*i][2] = i;
            events[2*i+1][0] = Integer.parseInt(st.nextToken());
            events[2*i+1][1] = -1;
            events[2*i+1][2] = i;

        }
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[0] == t1[0]) {
                    return t1[1]-ints[1];
                }
                return ints[0]-t1[0];
            }
        });
        HashSet<Integer> available = new HashSet<Integer>();
        int next = 1;
        int[] ans = new int[n];
        for(int[] i: events) {
            if(i[1] > 0) {
                for(int j: available) {
                    ans[i[2]] = j;
                    break;
                }
                if(ans[i[2]] == 0) {
                    ans[i[2]] = next++;
                } else {
                    available.remove(ans[i[2]]);
                }
            } else {
                available.add(ans[i[2]]);
            }
        }
        out.println(next-1);
        for(int i = 0; i < n; i++) {
            out.println(ans[i]);
        }
        f.close();
        out.close();
    }
}