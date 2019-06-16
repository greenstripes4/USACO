/*
ID: strongh2
LANG: JAVA
PROG: milk2
TASK: milk2
 */
import java.io.*;
import java.util.*;

class Point implements Comparable{
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        Point target = (Point)o;
        Integer a = this.x;
        Integer b = ((Point)o).x;
        return a.compareTo(b);
    }
}

public class milk2 {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        int farmers = Integer.parseInt(f.readLine());
        Point[] pts = new Point[farmers];
        for(int i = 0; i < farmers; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            pts[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        f.close();
        Arrays.sort(pts);
        int[] se = new int[2];
        se[0] = pts[0].x;
        se[1] = pts[0].y;
        int max1 = se[1] - se[0];
        int max2 = 0;
        for(int i = 1; i < farmers; i++){
            int start = pts[i].x;
            int end = pts[i].y;

            if(start>se[1]){
                max1 = Math.max(se[1]-se[0], max1);
                max2 = Math.max(max2, start-se[1]);
                se[0] = start;
                se[1] = end;
            }else if(end>=se[1]){
                se[1] = end;
                max1 = Math.max(se[1]-se[0],max1);
            }
        }
        out.println(max1 + " " + max2);
        out.close();
    }
}
