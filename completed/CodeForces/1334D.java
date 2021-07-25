import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            long total = 0;
            int cur = 0;
            while(cur < n && total < l) {
                cur++;
                total += 2 * (n - cur);
            }
            if(total < l) {
                out.println(1);
                continue;
            }
            int start = cur;
            int posLeft = (int) (2*(n-cur)-(total-l)-1);
            while(cur < n && total < r) {
                cur++;
                total += 2*(n-cur);
            }
            if(total < r) {
                total++;
            }
            int end = cur;
            int posRight = (int) (total-r);
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = start; i <= end; i++) {
                for(int j = i+1; j <= n; j++) {
                    arr.add(i);
                    arr.add(j);
                }
            }
            if(cur == n) {
                arr.add(1);
            }
            out.print(arr.get(posLeft));
            for(int i = posLeft+1; i < arr.size()-posRight; i++) {
                out.print(" " + arr.get(i));
            }
            out.println();
        }
        f.close();
        out.close();
    }
}