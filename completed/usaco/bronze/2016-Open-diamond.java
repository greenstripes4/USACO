import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] diamonds = new int[N];
        for(int i = 0; i < N; i++){
            diamonds[i] = Integer.parseInt(f.readLine());
        }
        int max = 0;
        for(int j = 0; j < N; j++){
            int count = 0;
            for(int k = 0; k < N; k++){
                if(diamonds[k] - diamonds[j] <= K && diamonds[k] >= diamonds[j]){
                    count++;
                }
            }
            if(count > max){
                max = count;
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}
