import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(f.readLine());
            int[] C = new int[n];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int i = 0; i < n; i++) {
                C[i] = Integer.parseInt(st.nextToken());
            }
            int currentTotal = C[0];
            int maxCoins = 1;
            for(int i = 1; i < n-1; i++) {
                if(currentTotal+C[i] < C[i+1]) {
                    currentTotal += C[i];
                    maxCoins++;
                }
            }
            maxCoins++;
            out.println(maxCoins);
        }
        f.close();
        out.close();
    }
}
