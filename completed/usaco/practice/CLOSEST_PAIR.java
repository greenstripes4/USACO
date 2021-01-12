import java.io.*;
import java.util.*;

public class Main {
    private static double distance(double[] p1, double[] p2) {
        double distX = Math.abs(p1[0]-p2[0]);
        double distY = Math.abs(p1[1]-p2[1]);
        return Math.sqrt(distX*distX+distY*distY);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        double[][] points = new double[N][3];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            points[i][0] = Double.parseDouble(st.nextToken());
            points[i][1] = Double.parseDouble(st.nextToken());
            points[i][2] = i;
        }
        Arrays.sort(points, new Comparator<double[]>() {
            @Override
            public int compare(double[] doubles, double[] t1) {
                if(Double.compare(doubles[0], t1[0]) == 0) {
                    return Double.compare(doubles[1], t1[1]);
                }
                return Double.compare(doubles[0], t1[0]);
            }
        });
        TreeSet<double[]> relativePoints = new TreeSet<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] doubles, double[] t1) {
                if(Double.compare(doubles[0], t1[0]) == 0) {
                    return Double.compare(doubles[1], t1[1]);
                }
                return Double.compare(doubles[0], t1[0]);
            }
        });
        int index = 0;
        double min = Double.MAX_VALUE;
        int a = -1;
        int b = -1;
        relativePoints.add(points[0]);
        for(int i = 1; i < N; i++) {
            while(index < i && points[i][0]-points[index][0] > min) {
                relativePoints.remove(points[index++]);
            }
            double[] first = relativePoints.higher(new double[]{points[i][0]-min, -1});
            while(first != null) {
                double temp = distance(points[i], first);
                if(temp < min) {
                    min = temp;
                    a = Math.min((int) points[i][2], (int) first[2]);
                    b = Math.max((int) points[i][2], (int) first[2]);
                }
                first = relativePoints.higher(first);
            }
            relativePoints.add(points[i]);
        }
        out.println(a + " " + b + " " + String.format("%.6f", min));
        f.close();
        out.close();
    }
}