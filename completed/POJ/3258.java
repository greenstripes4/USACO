import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] D = new int[N];
        for(int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(D);
        int low = 1;
        int high = L;
        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            int temp = M;
            int cur = 0;
            for(int i: D) {
                if(i-cur < mid) {
                    temp--;
                } else {
                    cur = i;
                }
            }
            if(L-cur < mid) {
                temp--;
            }
            if(temp < 0) {
                high = mid-1;
            } else {
                ans = mid;
                low = mid+1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}