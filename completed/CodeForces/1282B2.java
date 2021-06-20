import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = f.nextInt();
        while(t-- > 0) {
            int n = f.nextInt();
            int p = f.nextInt();
            int k = f.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = f.nextInt();
            }
            Arrays.sort(a);
            int sum = 0;
            int max = 0;
            for(int i = 0; i < k; i++) {
                if(sum > p) {
                    break;
                }
                int total = sum;
                int cnt = i;
                for(int j = i+k-1; j < n; j += k) {
                    total += a[j];
                    if(total > p) {
                        break;
                    }
                    cnt += k;
                }
                max = Math.max(max, cnt);
                sum += a[i];
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}