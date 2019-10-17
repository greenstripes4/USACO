import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("hps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] plays = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            plays[i][0] = Integer.parseInt(st.nextToken());
            plays[i][1] = Integer.parseInt(st.nextToken());
        }
        int max1 = 0;
        int max2 = 0;
        for(int[] j: plays){
            if((j[0] == 1 && j[1] == 3) || (j[0] == 3 && j[1] == 2) || (j[0] == 2 && j[1] == 1)){
                max1++;
            } else if((j[0] == 1 && j[1] == 2) || (j[0] == 2 && j[1] == 3) || (j[0] == 3 && j[1] == 1)) {
                max2++;
            }
        }
        out.println(Math.max(max1,max2));
        f.close();
        out.close();
    }
}
