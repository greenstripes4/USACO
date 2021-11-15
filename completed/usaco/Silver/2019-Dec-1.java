import java.io.*;
import java.util.*;

public class Main {
        private static long binarySearch(long N) {
                long low = 1;
                long high = 2000000000;
                long ans = 0;
                while(low <= high) {
                        long mid = (low+high)/2;
                        long temp = mid-mid/3-mid/5+mid/15;
                        if(temp < N) {
                                low = mid+1;
                        } else {
                                ans = mid;
                                high = mid-1;
                        }
                }
                return ans;
        }
        public static void main(String[] args) throws IOException{
                BufferedReader f = new BufferedReader(new FileReader("moobuzz.in"));
                //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
                //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                int N = Integer.parseInt(f.readLine());
                out.println(binarySearch(N));
                f.close();
                out.close();
    }
}
