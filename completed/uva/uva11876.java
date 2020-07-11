import java.io.*;
import java.util.*;

public class Main{
    private static int numDivisors(int n) {
        int ans = 0;
        for (int i = 1; i * i <= n; i++){
            if (n % i == 0) {
                ans++;
                if (n / i != i)
                    ans++;
            }
        }
        return ans;
    }
    private static int low(int[] sequence, int target){
        int low = 0;
        int high = sequence.length - 1;
        int ans = -1;
        while(low <= high) {
            int mid = low + high >> 1;
            if(sequence[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private static int high(int[] sequence, int target){
        int low = 0;
        int high = sequence.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = low + high >> 1;
            if(sequence[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] sequence = new int[65000];
        sequence[0] = 1;
        for(int i = 1; i < 65000; i++){
            sequence[i] = sequence[i-1] + numDivisors(sequence[i-1]);
        }
        int T = f.nextInt();
        for(int i = 0; i < T; i++){
            int A = f.nextInt();
            int B = f.nextInt();
            int low = low(sequence,A);
            int high = high(sequence,B);
            out.println("Case " + (i+1) + ": " + (high-low+1));
        }
        f.close();
        out.close();
    }
}
