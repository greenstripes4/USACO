import java.io.*;
import java.util.*;

public class Main {
    private static class Interval implements Comparable<Interval> {
        public int s;
        public int e;
        Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Interval o) {
            return s-o.s;
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        Interval[] arr = new Interval[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            arr[i] = new Interval(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        if(arr[0].s > 1) {
            out.println(-1);
        } else {
            int i = 1;
            int j = 0;
            int c = 0;
            while(i <= T) {
                int max = 0;
                while(j < N && arr[j].s <= i) {
                    max = Math.max(max, arr[j].e);
                    j++;
                }
                if(max < i) {
                    break;
                }
                i = max+1;
                c++;
            }
            out.println(i > T ? c : -1);
        }
        f.close();
        out.close();
    }
}