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
        int[][] allPossibleK = new int[50001][];
        for(int i = 0; i*i <= 50000; i++) {
            for(int j = i; i*i+j*j <= 50000; j++) {
                for(int k = j; i*i+j*j+k*k <= 50000; k++) {
                    int threeSquare = i*i+j*j+k*k;
                    if(allPossibleK[threeSquare] == null) {
                        allPossibleK[threeSquare] = new int[]{i, j, k};
                    }
                }
            }
        }
        int N = Integer.parseInt(f.readLine());
        for(int t = 0; t < N; t++) {
            int K = Integer.parseInt(f.readLine());
            out.println(allPossibleK[K] == null ? -1 : allPossibleK[K][0] + " " + allPossibleK[K][1] + " " + allPossibleK[K][2]);
        }
        f.close();
        out.close();
    }
}
