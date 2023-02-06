import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
ID: strongh2
LANG: JAVA
PROG: numtri
TASK: numtri
 */
public class numtri {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        int R = Integer.parseInt(f.readLine());
        int[][] val = new int[R][R];
        int ind = 1;
        for(int i = 0; i < R; i++){
            StringTokenizer st  = new StringTokenizer(f.readLine());
            for(int j = 0; j < ind; j++){
                val[i][j] = Integer.parseInt(st.nextToken());
            }
            for(int k = ind; k < R; k++){
                val[i][k] = 0;
            }
            ind++;
        }
        for(int l = R-1; l > 0; l--){
            for(int m = 0; m < l; m++){
                val[l-1][m] += Math.max(val[l][m],val[l][m+1]);
            }
        }
        out.println(val[0][0]);
        f.close();
        out.close();
    }
}
