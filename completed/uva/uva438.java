import java.io.*;
import java.util.*;

public class Main {
    private static double distance(double x1, double y1, double x2, double y2) {
        double dx = Math.abs(x1-x2);
        double dy = Math.abs(y1-y2);
        return Math.sqrt(dx*dx+dy*dy);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double x3 = Double.parseDouble(st.nextToken());
            double y3 = Double.parseDouble(st.nextToken());
            double sa = distance(x1, y1, x2, y2);
            double sb = distance(x2, y2, x3, y3);
            double sc = distance(x3, y3, x1, y1);
            double s = (sa+sb+sc)/2;
            double R = (sa*sb*sc)/(4*Math.sqrt(s*(s-sa)*(s-sb)*(s-sc)));
            double C = 2*R*Math.PI;
            out.printf("%.2f\n", C);
        }
        f.close();
        out.close();
    }
}