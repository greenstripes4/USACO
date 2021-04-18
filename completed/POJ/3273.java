import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] money = new int[N];
        int low = 0;
        int high = 0;
        for(int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(f.readLine());
            low = Math.max(low, money[i]);
            high += money[i];
        }
        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            int temp = M-1;
            int cur = 0;
            for(int i: money) {
                if(cur+i > mid) {
                    temp--;
                    cur = 0;
                }
                cur += i;
            }
            if(temp < 0) {
                low = mid+1;
            } else {
                ans = mid;
                high = mid-1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}