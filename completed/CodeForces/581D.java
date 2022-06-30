import java.io.*;
import java.util.*;

public class Main {
    private static boolean solve(int x1, int y1, int x2, int y2, int x3, int y3, int side, PrintWriter out) {
        if(x1 == side && x2 == side && x3 == side) {
            out.println(side);
            for(int i = 0; i < y1; i++) {
                out.println("A".repeat(side));
            }
            for(int i = 0; i < y2; i++) {
                out.println("B".repeat(side));
            }
            for(int i = 0; i < y3; i++) {
                out.println("C".repeat(side));
            }
            return true;
        } else if(y1 == side && y2 == side && y3 == side) {
            out.println(side);
            for(int i = 0; i < side; i++) {
                out.println("A".repeat(x1)+"B".repeat(x2)+"C".repeat(x3));
            }
            return true;
        } else if(x1 == side && x2+x3 == side && y2 == y3) {
            out.println(side);
            for(int i = 0; i < y1; i++) {
                out.println("A".repeat(side));
            }
            for(int i = 0; i < y2; i++) {
                out.println("B".repeat(x2)+"C".repeat(x3));
            }
            return true;
        } else if(x2 == side && x1+x3 == side && y1 == y3) {
            out.println(side);
            for(int i = 0; i < y2; i++) {
                out.println("B".repeat(side));
            }
            for(int i = 0; i < y1; i++) {
                out.println("A".repeat(x1)+"C".repeat(x3));
            }
            return true;
        } else if(x3 == side && x1+x2 == side && y1 == y2) {
            out.println(side);
            for(int i = 0; i < y3; i++) {
                out.println("C".repeat(side));
            }
            for(int i = 0; i < y1; i++) {
                out.println("A".repeat(x1)+"B".repeat(x2));
            }
            return true;
        } else if(y1 == side && y2+y3 == side && x2 == x3) {
            out.println(side);
            for(int i = 0; i < y2; i++) {
                out.println("A".repeat(x1)+"B".repeat(x2));
            }
            for(int i = 0; i < y3; i++) {
                out.println("A".repeat(x1)+"C".repeat(x2));
            }
            return true;
        } else if(y2 == side && y1+y3 == side && x1 == x3) {
            out.println(side);
            for(int i = 0; i < y1; i++) {
                out.println("B".repeat(x2)+"A".repeat(x1));
            }
            for(int i = 0; i < y3; i++) {
                out.println("B".repeat(x2)+"C".repeat(x1));
            }
            return true;
        } else if(y3 == side && y1+y2 == side && x1 == x2) {
            out.println(side);
            for(int i = 0; i < y1; i++) {
                out.println("C".repeat(x3)+"A".repeat(x1));
            }
            for(int i = 0; i < y2; i++) {
                out.println("C".repeat(x3)+"B".repeat(x1));
            }
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int area = x1*y1+x2*y2+x3*y3;
        int side = 1;
        while(side*side < area) {
            side++;
        }
        if(side*side > area) {
            out.println(-1);
        } else if(!solve(x1, y1, x2 ,y2, x3, y3, side, out) && !solve(x1, y1, x2 ,y2, y3, x3, side, out) && !solve(x1, y1, y2 ,x2, x3, y3, side, out) &&
            !solve(x1, y1, y2 ,x2, y3, x3, side, out) && !solve(y1, x1, x2 ,y2, x3, y3, side, out) && !solve(y1, x1, x2 ,y2, y3, x3, side, out) &&
            !solve(y1, x1, y2 ,x2, x3, y3, side, out) && !solve(y1, x1, y2, x2, y3, x3, side, out)) {
            out.println(-1);
        }
        f.close();
        out.close();
    }
}