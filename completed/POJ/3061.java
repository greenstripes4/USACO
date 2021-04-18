import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int i = 0;
            int j = 0;
            int s = 0;
            int ans = N+1;
            while(j <= N) {
                if(s >= S) {
                    ans = Math.min(ans, j-i);
                    s -= arr[i++];
                } else {
                    if(j == N) {
                        break;
                    }
                    s += arr[j++];
                }
            }
            out.println(ans > N ? 0 : ans);
        }
        f.close();
        out.close();
    }
}