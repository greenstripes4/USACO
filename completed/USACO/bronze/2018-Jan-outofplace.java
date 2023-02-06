import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("outofplace.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
        int N = Integer.parseInt(f.readLine());
        int[] heights = new int[N];
        int[] heightsSorted = new int[N];
        for(int i = 0; i < N; i++) {
            int height = Integer.parseInt(f.readLine());
            heights[i] = height;
            heightsSorted[i] = height;
        }
        Arrays.sort(heightsSorted);
        int swaps = 0;
        for(int j = 0; j < N; j++) {
            if(heights[j] != heightsSorted[j]) {
                swaps++;
            }
        }
        out.println(swaps-1 == -1 ? 0:swaps-1);
        f.close();
        out.close();
    }
}
