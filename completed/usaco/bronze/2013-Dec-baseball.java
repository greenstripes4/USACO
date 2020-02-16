import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("baseball.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("baseball.out")));
        int N = Integer.parseInt(f.readLine());
        int[] cows = new int[N];
        for(int i = 0; i < N; i++){
            cows[i] = Integer.parseInt(f.readLine());
        }
        int count = 0;
        Arrays.sort(cows);
        for(int i = 0; i < N-2; i++){
            for(int j = i+1; j < N-1; j++){
                for(int k = j+1; k < N; k++){
                    if(cows[k] - cows[j]  >= cows[j] - cows[i] && cows[k] - cows[j] <= 2 * (cows[j] - cows[i])){
                        count++;
                    }
                }
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
