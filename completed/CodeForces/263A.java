import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[][] matrix = new int[5][5];
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < 5; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean found = false;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(matrix[i][j] == 1) {
                    found = true;
                    out.println(Math.abs(i-2)+Math.abs(j-2));
                    break;
                }
            }
            if(found) {
                break;
            }
        }
        f.close();
        out.close();
    }
}