import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long cur = 0;
        long nextA = a;
        long nextB = b;
        long totalA = 0;
        long totalB = 0;
        while(nextA != nextB) {
            if(nextA < nextB) {
                totalA += nextA-cur;
                cur = nextA;
                nextA += a;
            } else {
                totalB += nextB-cur;
                cur = nextB;
                nextB += b;
            }
        }
        if(a < b) {
            totalB += nextB-cur;
        } else {
            totalA += nextA-cur;
        }
        out.println(totalA == totalB ? "Equal" : totalA > totalB ? "Dasha" : "Masha");
        f.close();
        out.close();
    }
}