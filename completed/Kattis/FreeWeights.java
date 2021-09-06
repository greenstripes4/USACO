import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] row1 = new int[n];
        for(int i = 0; i < n; i++) {
            row1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        int[] row2 = new int[n];
        for(int i = 0; i < n; i++) {
            row2[i] = Integer.parseInt(st.nextToken());
        }
        int low = 0;
        int high = 1000000000;
        int ans = high;
        while(low <= high) {
            int mid = (low+high)/2;
            int last = 0;
            boolean flag = false;
            for(int i = 0; i < n; i++) {
                if(row1[i] > mid) {
                    if(last > 0) {
                        if(row1[i] != last) {
                            flag = true;
                            break;
                        }
                        last = 0;
                    } else {
                        last = row1[i];
                    }
                }
            }
            if(flag || last > 0) {
                low = mid+1;
                continue;
            }
            last = 0;
            for(int i = 0; i < n; i++) {
                if(row2[i] > mid) {
                    if(last > 0) {
                        if(row2[i] != last) {
                            flag = true;
                            break;
                        }
                        last = 0;
                    } else {
                        last = row2[i];
                    }
                }
            }
            if(flag || last > 0) {
                low = mid+1;
            } else {
                high = mid-1;
                ans = mid;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}