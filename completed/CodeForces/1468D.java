import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int time = a < b ? b-1 : n-b;
            st = new StringTokenizer(f.readLine());
            int[] s = new int[m];
            for(int j = 0; j < m; j++) {
                s[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(s);
            int low = 0;
            int high = Math.min(m, Math.abs(a-b)-1);
            int ans = -1;
            while(low <= high) {
                int mid = (low+high)/2;
                int max = 0;
                for(int j = 0; j < mid; j++) {
                    max = Math.max(max, s[j]+mid-j);
                }
                if(max <= time) {
                    ans = mid;
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}