import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            double M = f.nextInt();
            int N = f.nextInt();
            if(M == -1 && N == -1) {
                break;
            }
            double[][] rooms = new double[N][2];
            for(int i = 0; i < N; i++) {
                rooms[i][0] = f.nextInt();
                rooms[i][1] = f.nextInt();
            }
            Arrays.sort(rooms, new Comparator<double[]>() {
                @Override
                public int compare(double[] doubles, double[] t1) {
                    return Double.compare(t1[0]*doubles[1], doubles[0]*t1[1]);
                }
            });
            double ans = 0;
            for(double[] i: rooms) {
                if(M < i[1]) {
                    ans += i[0]*M/i[1];
                    break;
                } else {
                    ans += i[0];
                    M -= i[1];
                }
            }
            out.printf("%.3f\n", ans);
        }
        f.close();
        out.close();
    }
}