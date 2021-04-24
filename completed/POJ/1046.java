import java.io.*;
import java.util.*;

public class Main {
    private static int distance(int[] a, int[] b) {
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1])+(a[2]-b[2])*(a[2]-b[2]);
    }
    private static String toString(int[] c) {
        return "(" + c[0] + ","+c[1] + "," + c[2] + ")";
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[][] template = new int[16][3];
        for(int i = 0; i < 16; i++) {
            template[i][0] = f.nextInt();
            template[i][1] = f.nextInt();
            template[i][2] = f.nextInt();
        }
        while(true) {
            int[] color = {f.nextInt(), f.nextInt(), f.nextInt()};
            if(color[0] == -1 && color[1] == -1 && color[2] == -1) {
                break;
            }
            int[] closest = new int[3];
            int min = Integer.MAX_VALUE;
            for(int[] i: template) {
                int temp = distance(color, i);
                if(temp < min) {
                    closest = i;
                    min = temp;
                }
            }
            out.println(toString(color) + " maps to " + toString(closest));
        }
        f.close();
        out.close();
    }
}