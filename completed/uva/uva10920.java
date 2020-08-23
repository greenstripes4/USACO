import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int[][] directions = {{0,-1},{-1,0},{0,1},{1,0}};
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int SZ = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            if(P == 1) {
                out.println("Line = " + (SZ/2+1) + ", column = " + (SZ/2+1) + ".");
                continue;
            }
            int upperBoundSqrt = (int)Math.floor(Math.sqrt(P));
            if(upperBoundSqrt%2 == 0) {
                upperBoundSqrt--;
            }
            if(upperBoundSqrt*upperBoundSqrt < P) {
                upperBoundSqrt += 2;
            }
            int upperBound = upperBoundSqrt*upperBoundSqrt;
            int layer = upperBoundSqrt/2;
            int layerSegmentLength = upperBoundSqrt-1;
            int[][] layerCorners = {{SZ/2+1+layer,SZ/2+1+layer},{SZ/2+1+layer,SZ/2+1-layer},{SZ/2+1-layer,SZ/2+1-layer},{SZ/2+1-layer,SZ/2+1+layer}};
            int layerSegmentIndex = (upperBound-P)/layerSegmentLength;
            int difference = (upperBound-P)%layerSegmentLength;
            int[] coordinates = {layerCorners[layerSegmentIndex][0]+directions[layerSegmentIndex][0]*difference,layerCorners[layerSegmentIndex][1]+directions[layerSegmentIndex][1]*difference};
            out.println("Line = " + coordinates[1] + ", column = " + coordinates[0] + ".");
        }
        f.close();
        out.close();
    }
}
