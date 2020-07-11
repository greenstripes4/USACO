import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int A = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[] X = new int[C];
            StringTokenizer finalHeights = new StringTokenizer(f.readLine());
            for(int i = 0; i < C; i++) {
                X[i] = Integer.parseInt(finalHeights.nextToken());
            }
            int laserOn = 0;
            int lastHeight = A;
            for(int i = 0; i < C; i++) {
                if(X[i] < lastHeight) {
                    laserOn += lastHeight-X[i];
                }
                lastHeight = X[i];
            }
            out.println(laserOn);
        }
        f.close();
        out.close();
    }
}
