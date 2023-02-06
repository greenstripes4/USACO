import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        int numPiles = Integer.parseInt(f.readLine());
        int[] piles = new int[numPiles];
        for(int i = 0; i < numPiles; i++){
            piles[i] = Integer.parseInt(f.readLine());
        }
        int sum = 0;
        for(int j: piles){
            sum += j;
        }
        int average = sum/numPiles;
        int hayMoved = 0;
        for(int k: piles){
            if(k < average){
                hayMoved += average - k;
            }
        }
        out.println(hayMoved);
        out.close();
        f.close();
    }
}
