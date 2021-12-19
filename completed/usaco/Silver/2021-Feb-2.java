import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken())-1;
        int[] arr = new int[N+1];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(arr);
        int[] temp = new int[N];
        for(int i = 0; i < N; i++) {
            int higher = (arr[i]+11)/12*12;
            int lower = arr[i+1]/12*12;
            temp[i] = Math.max(0, lower-higher);
        }
        Arrays.sort(temp);
        int sum = 0;
        for(int i = N-K; i < N; i++) {
            sum += temp[i];
        }
        out.println((arr[N]+11)/12*12-sum);
        f.close();
        out.close();
    }
}
