import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            long even = 0;
            for(int j = 0; j < n; j += 2) {
                even += a[j];
            }
            long option1 = 0;
            long option2 = 0;
            long maxBenefit = 0;
            for(int j = 0; j < n; j += 2) {
                if(j > 0) {
                    option1 += a[j-1]-a[j];
                    maxBenefit = Math.max(maxBenefit, option1);
                    if(option1 < 0) {
                        option1 = 0;
                    }
                }
                if(j < n-1) {
                    option2 += a[j+1]-a[j];
                    maxBenefit = Math.max(maxBenefit, option2);
                    if(option2 < 0) {
                        option2 = 0;
                    }
                }
            }
            out.println(even+maxBenefit);
        }
        f.close();
        out.close();
    }
}