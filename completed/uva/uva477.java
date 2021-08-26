import java.io.*;
import java.util.*;

public class Main {
    private static class Rectangle {
        private int id;
        private double x1;
        private double y1;
        private double x2;
        private double y2;
        private Rectangle(int id, double x1, double y1, double x2, double y2) {
            this.id = id;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        private boolean contains(double x, double y) {
            return x >= x1 && x <= x2 && y >= y2 && y <= y1;
        }
    }
    private static class Circle {
        private int id;
        private double x1;
        private double y1;
        private double r;
        private Circle(int id, double x1, double y1, double r) {
            this.id = id;
            this.x1 = x1;
            this.y1 = y1;
            this.r = r;
        }
        private boolean contains(double x, double y) {
            double dx = Math.abs(x-x1);
            double dy = Math.abs(y-y1);
            return dx*dx+dy*dy <= r*r;
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        ArrayList<Rectangle> r = new ArrayList<>();
        ArrayList<Circle> c = new ArrayList<>();
        String input;
        int id = 1;
        while(!(input = f.readLine()).equals("*")) {
            StringTokenizer st = new StringTokenizer(input);
            char t = st.nextToken().charAt(0);
            if(t == 'r') {
                double x1 = Double.parseDouble(st.nextToken());
                double y1 = Double.parseDouble(st.nextToken());
                double x2 = Double.parseDouble(st.nextToken());
                double y2 = Double.parseDouble(st.nextToken());
                r.add(new Rectangle(id, x1, y1, x2, y2));
            } else {
                double x1 = Double.parseDouble(st.nextToken());
                double y1 = Double.parseDouble(st.nextToken());
                double R = Double.parseDouble(st.nextToken());
                c.add(new Circle(id, x1, y1, R));
            }
            id++;
        }
        int t = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            if(x == 9999.9 && y == 9999.9) {
                break;
            }
            ArrayList<Integer> res = new ArrayList<>();
            for(Rectangle i: r) {
                if(i.contains(x, y)) {
                    res.add(i.id);
                }
            }
            for(Circle i: c) {
                if(i.contains(x, y)) {
                    res.add(i.id);
                }
            }
            Collections.sort(res);
            for(int i: res) {
                out.println("Point " + t + " is contained in figure " + i);
            }
            if(res.size() == 0) {
                out.println("Point " + t + " is not contained in any figure");
            }
            t++;
        }
        f.close();
        out.close();
    }
}