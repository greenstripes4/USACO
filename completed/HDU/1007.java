import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    public double x;
    public double y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    double distanceTo(Point o) {
        double dx = Math.abs(x-o.x);
        double dy = Math.abs(y-o.y);
        return dx*dx+dy*dy;
    }
    @Override
    public int compareTo(Point o) {
        int res = Double.compare(x, o.x);
        return res == 0 ? Double.compare(y, o.y) : res;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int N = Integer.parseInt(f.readLine());
            if(N == 0) {
                break;
            }
            Point[] points = new Point[N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                points[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            }
            Arrays.sort(points);
            TreeSet<Point> relativePoints = new TreeSet<Point>();
            double min = Double.MAX_VALUE;
            int index = 0;
            relativePoints.add(points[0]);
            for(int i = 1; i < N; i++) {
                while(index < i && points[i].x-points[index].x > min) {
                    relativePoints.remove(points[index++]);
                }
                Point first = relativePoints.ceiling(new Point(points[i].x-min, Double.MIN_VALUE));
                while(first != null) {
                    double temp = first.distanceTo(points[i]);
                    min = Math.min(min, temp);
                    first = relativePoints.higher(first);
                }
                relativePoints.add(points[i]);
            }
            out.printf("%.2f\n", Math.sqrt(min)/2);
        }
        f.close();
        out.close();
    }
}