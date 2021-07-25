import java.io.*;
import java.util.*;

public class Main {
    private static int binarySearch(int n) {
        int low = 1;
        int high = n;
        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            if(mid >= (n+mid-1)/mid) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            ArrayList<String> res = new ArrayList<>();
            while(n > 2) {
                int y = binarySearch(n);
                for(int i = y+1; i < n; i++) {
                    res.add(i + " " + n);
                }
                res.add(n + " " + y);
                res.add(n + " " + y);
                n = y;
            }
            out.println(res.size());
            for(String i: res) {
                out.println(i);
            }
        }
        f.close();
        out.close();
    }
}