import java.io.*;
import java.util.*;

public class Main {
    private static boolean intersect(double[] a, double[] b) {
        double mA = (a[3]-a[1])/(a[2]-a[0]);
        double mB = (b[3]-b[1])/(b[2]-b[0]);
        double bA = a[1]-mA*a[0];
        double bB = b[1]-mB*b[0];
        double x = (bB-bA)/(mA-mB);
        double y = mA*x+bA;
        return x >= Math.min(a[0], a[2]) && x <= Math.max(a[0], a[2]) && y >= Math.min(a[1], a[3]) && y <= Math.max(a[1], a[3]) && x >= Math.min(b[0], b[2]) && x <= Math.max(b[0], b[2]) && y >= Math.min(b[1], b[3]) && y <= Math.max(b[1], b[3]);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        int N = Integer.parseInt(f.readLine());
        double[][] lineSegments = new double[N][5];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if(x1 > x2) {
                int tempX = x1;
                x1 = x2;
                x2 = tempX;
                int tempY = y1;
                y1 = y2;
                y2 = tempY;
            }
            lineSegments[i][0] = x1;
            lineSegments[i][1] = y1;
            lineSegments[i][2] = x2;
            lineSegments[i][3] = y2;
            lineSegments[i][4] = i+1;
        }
        Arrays.sort(lineSegments, new Comparator<double[]>() {
            @Override
            public int compare(double[] doubles, double[] t1) {
                double val = doubles[0]-t1[0];
                if(val < 0) {
                    return -1;
                }
                if(val > 0) {
                    return 1;
                }
                return (int)(doubles[4]-t1[4]);
            }
        });
        for(int i = 0; i < N-1; i++) {
            if(intersect(lineSegments[i], lineSegments[i+1])) {
                if(i == N-2 || (lineSegments[i][4] < lineSegments[i+1][4] && !intersect(lineSegments[i+1], lineSegments[i+2]))) {
                    out.println((int) lineSegments[i][4]);
                } else {
                    out.println((int) lineSegments[i+1][4]);
                }
                break;
            }
        }
        f.close();
        out.close();
    }
}
