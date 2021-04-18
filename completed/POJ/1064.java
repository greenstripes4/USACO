import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = (int) (Double.parseDouble(f.readLine())*100);
        }
        int low = 1;
        int high = 10000000;
        double ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            int temp = 0;
            for(int i: arr) {
                temp += i/mid;
            }
            if(temp >= K) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        out.printf("%.2f\n", ans/100);
        f.close();
        out.close();
    }
}