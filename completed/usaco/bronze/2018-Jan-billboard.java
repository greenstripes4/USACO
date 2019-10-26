import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        StringTokenizer st2 = new StringTokenizer(f.readLine());
        int LX1 = Integer.parseInt(st.nextToken());
        int LY1 = Integer.parseInt(st.nextToken());
        int LX2 = Integer.parseInt(st.nextToken());
        int LY2 = Integer.parseInt(st.nextToken());
        int CX1 = Integer.parseInt(st2.nextToken());
        int CY1 = Integer.parseInt(st2.nextToken());
        int CX2 = Integer.parseInt(st2.nextToken());
        int CY2 = Integer.parseInt(st2.nextToken());
        int[][] area = new int[2001][2001];
        for(int i = LX1; i < LX2; i++){
            for(int j = LY1; j < LY2; j++){
                area[i+1000][j+1000] = -1;
            }
        }
        for(int k = CX1; k < CX2; k++){
            for(int l = CY1; l < CY2; l++){
                area[k+1000][l+1000] = 1;
            }
        }
        int[] dimensions = {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        boolean hasUncovered = false;
        for(int m = 0; m < 2001; m++){
            for(int n = 0; n < 2001; n++){
                if(area[m][n] == -1){
                    dimensions[0] = Math.min(dimensions[0],m);
                    dimensions[1] = Math.min(dimensions[1],n);
                    dimensions[2] = Math.max(dimensions[2],m);
                    dimensions[3] = Math.max(dimensions[3],n);
                    hasUncovered = true;
                }
            }
        }
        out.println(hasUncovered ? (dimensions[2]-dimensions[0]+1)*(dimensions[3]-dimensions[1]+1):0);
        f.close();
        out.close();
    }
}
