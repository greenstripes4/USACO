import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        double A = f.nextDouble();
        double low = 0;
        double high = Double.MAX_VALUE/3;
        double ans = Double.MAX_VALUE;
        double eps = Math.pow(10, -7);
        while(high-low >= eps) {
            double mid = (low+high)/2;
            double first = A;
            double second = mid;
            boolean flag = false;
            for(int i = 0; i < N-2; i++) {
                double third = 2*second-first+2;
                if(third < 0) {
                    flag = true;
                    break;
                }
                first = second;
                second = third;
            }
            if(flag) {
                low = mid;
            } else {
                high = mid;
                ans = second;
            }
        }
        out.printf("%.2f\n", ans);
        f.close();
        out.close();
    }
}