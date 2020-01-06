/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int i = 0; i < testcases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            st.nextToken();
            st.nextToken();
            int size = Integer.parseInt(st.nextToken());
            long[][] matrix = new long[size][size];
            for(int j = 0; j < size; j++){
                StringTokenizer row = new StringTokenizer(f.readLine());
                for(int k = 0; k < size; k++){
                    matrix[j][k] = Long.parseLong(row.nextToken());
                }
            }
            boolean valid = true;
            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    if(matrix[j][k] != matrix[matrix.length-j-1][matrix.length-k-1] || matrix[j][k] < 0){
                        valid = false;
                        break;
                    }
                }
            }
            if(valid){
                out.println("Test #" + (i+1) + ": Symmetric.");
            } else {
                out.println("Test #" + (i+1) + ": Non-symmetric.");
            }
        }
        f.close();
        out.close();
    }
}
