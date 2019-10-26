import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
        int N = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        int[] finalOrder = new int[N];
        StringTokenizer order = new StringTokenizer(f.readLine());
        for(int i = 0; i < N; i++){
            finalOrder[i] = Integer.parseInt(order.nextToken());
        }
        for(int i = 0; i < 3; i++){
            int[] temp = new int[N];
            for(int j = 0; j < N; j++){
                temp[j] = finalOrder[arr[j]];
            }
            finalOrder = temp;
        }
        for(int i: finalOrder){
            out.println(i);
        }
        f.close();
        out.close();
    }
}
