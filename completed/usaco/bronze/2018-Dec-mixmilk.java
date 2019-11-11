import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
        int[] amounts = new int[3];
        int[] max = new int[3];
        for(int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            max[i] = Integer.parseInt(st.nextToken());
            amounts[i] = Integer.parseInt(st.nextToken());
        }
        int[][] transfers = {{0,1},{1,2},{2,0}};
        for(int i = 0; i < 100; i++){
            int[] t = transfers[i%3];
            int bucket1 = amounts[t[0]];
            int bucket2 = amounts[t[1]];
            amounts[t[0]] = Math.max(0,bucket1 - (max[t[1]] - bucket2));
            amounts[t[1]] = Math.min(max[t[1]],bucket1 + bucket2);
        }
        out.println(amounts[0]);
        out.println(amounts[1]);
        out.println(amounts[2]);
        f.close();
        out.close();
    }
}