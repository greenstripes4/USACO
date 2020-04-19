import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(f.readLine());
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int start = 0;
            int end = 0;
            int sum = 0;
            int min = Integer.MAX_VALUE;
            while(true){
                if(sum < S){
                    if(end == N){
                        break;
                    }
                    sum += arr[end];
                    end++;
                } else {
                    min = Math.min(min,end-start);
                    if(start == N){
                        break;
                    }
                    sum -= arr[start];
                    start++;
                }
            }
            out.println(min == Integer.MAX_VALUE ? 0 : min);
        }
        f.close();
        out.close();
    }
}
