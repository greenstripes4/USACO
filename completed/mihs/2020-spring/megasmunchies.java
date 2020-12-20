import java.io.*;
import java.util.*;

public class program {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < M; i++) {
            StringTokenizer order = new StringTokenizer(f.readLine());
            int index = Integer.parseInt(order.nextToken())-1;
            int value = Integer.parseInt(order.nextToken());
            arr[index] += value;
        }
        out.print(arr[0]);
        for(int i = 1; i < N; i++) {
            out.print(" " + arr[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}
