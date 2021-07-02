import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int t1 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int p = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int timeToTram;
        int dir;
        if(p == x1) {
            timeToTram = 0;
            dir = d;
        } else if(p > x1) {
            timeToTram = d < 0 ? t1*(p-x1) : t1*(2*s-p-x1);
            dir = -1;
        } else {
            timeToTram = d > 0 ? t1*(x1-p) : t1*(p+x1);
            dir = 1;
        }
        int timeToDest;
        if(x1 == x2) {
            timeToDest = 0;
        } else if(x1 > x2) {
            timeToDest = dir < 0 ? t1*(x1-x2) : t1*(2*s-x1-x2);
        } else {
            timeToDest = dir > 0 ? t1*(x2-x1) : t1*(x1+x2);
        }
        out.println(Math.min(t2*Math.abs(x1-x2), timeToTram+timeToDest));
        f.close();
        out.close();
    }
}