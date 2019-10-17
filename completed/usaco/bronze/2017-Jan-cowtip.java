import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("cowtip.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
        int N = Integer.parseInt(f.readLine());
        char[][] grid = new char[N][N];
        for(int i = 0; i < N; i++){
            char[] temp = f.readLine().toCharArray();
            grid[i] = temp;
        }
        int count = 0;
        for(int j = N-1; j >= 0; j--){
            for(int k = N-1; k >= 0; k--){
                if(grid[j][k] == '1'){
                    count++;
                    for(int l = 0; l <= j; l++){
                        for(int m = 0; m <= k; m++){
                            grid[l][m] = (grid[l][m] == '0') ? '1':'0';
                        }
                    }
                }
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
