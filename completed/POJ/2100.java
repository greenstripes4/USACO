import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long n = Long.parseLong(f.readLine());
        long i = 1;
        long j = 1;
        long sum = 0;
        ArrayList<long[]> res = new ArrayList<long[]>();
        while(j <= 10000001) {
            if(sum == n) {
                res.add(new long[]{i, j});
                sum -= i*i;
                i++;
            } else if(sum < n) {
                if(j == 10000001) {
                    break;
                }
                sum += j*j;
                j++;
            } else {
                sum -= i*i;
                i++;
            }
        }
        Collections.sort(res, new Comparator<long[]>() {
            @Override
            public int compare(long[] longs, long[] t1) {
                return (int) (t1[1]-t1[0]-longs[1]+longs[0]);
            }
        });
        out.println(res.size());
        for(long[] k: res) {
            out.print(k[1]-k[0]);
            for(long l = k[0]; l < k[1]; l++) {
                out.print(" " + l);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
