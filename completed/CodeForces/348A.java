import sun.awt.im.CompositionArea;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        long high = 0;
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            high += a[i];
        }
        long low = 1;
        long ans = high;
        while(low <= high) {
            long mid = (low+high)/2;
            long supervisors = 0;
            for(int i = 0; i < n; i++) {
                if(mid < a[i]) {
                    supervisors = 0;
                    break;
                }
                supervisors += mid-a[i];
            }
            if(supervisors < mid) {
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
