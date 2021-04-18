import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            char[][] arr = new char[n][];
            int[] minRow = new int[10];
            int[] minCol = new int[10];
            int[] maxRow = new int[10];
            int[] maxCol = new int[10];
            Arrays.fill(minRow, n);
            Arrays.fill(minCol, n);
            Arrays.fill(maxRow, -1);
            Arrays.fill(maxCol, -1);
            for(int i = 0; i < n; i++) {
                arr[i] = f.readLine().toCharArray();
                for(int j = 0; j < n; j++) {
                    int temp = arr[i][j]-'0';
                    minRow[temp] = Math.min(minRow[temp], i);
                    minCol[temp] = Math.min(minCol[temp], j);
                    maxRow[temp] = Math.max(maxRow[temp], i);
                    maxCol[temp] = Math.max(maxCol[temp], j);
                }
            }
            int[] ans = new int[10];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int temp = arr[i][j]-'0';
                    ans[temp] = Math.max(ans[temp], Math.max(Math.max(maxRow[temp]-i, i-minRow[temp])*Math.max(j, n-j-1),Math.max(maxCol[temp]-j, j-minCol[temp])*Math.max(i, n-i-1)));
                }
            }
            out.print(ans[0]);
            for(int i = 1; i < 10; i++) {
                out.print(" " + ans[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}