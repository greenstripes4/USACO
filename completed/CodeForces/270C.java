import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int max = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int size = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            long occ = 4;
            int temp = 1;
            while(occ < cnt) {
                occ *= 4;
                temp++;
            }
            max = Math.max(max, size+temp);
        }
        out.println(max);
        f.close();
        out.close();
    }
}