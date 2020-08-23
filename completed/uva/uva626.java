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
        while((input = f.readLine()) != null) {
            int n = Integer.parseInt(input);
            int[][] coincidenceMatrix = new int[n][n];
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                for(int k = 0; k < n; k++) {
                    coincidenceMatrix[i][k] = Integer.parseInt(st.nextToken());
                }
            }
            int cyclicChains = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    for(int k = 0; k < n; k++) {
                        if(coincidenceMatrix[i][j] == 1 && coincidenceMatrix[k][i] == 1 && coincidenceMatrix[j][k] == 1 && ((i < j && j < k) || (i > j && j > k))) {
                            cyclicChains++;
                            out.println((i+1) + " " + (j+1) + " " + (k+1));
                        }
                    }
                }
            }
            out.println("total:" + cyclicChains);
            out.println();
        }
        f.close();
        out.close();
    }
}
