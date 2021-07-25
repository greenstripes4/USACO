import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long x1 = Integer.parseInt(st.nextToken());
            long y1 = Integer.parseInt(st.nextToken());
            long x2 = Integer.parseInt(st.nextToken());
            long y2 = Integer.parseInt(st.nextToken());
            out.println((x2-x1)*(y2-y1)+1);
        }
        f.close();
        out.close();
    }
}