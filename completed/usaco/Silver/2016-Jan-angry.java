import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("angry.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(arr);
        int low = 0;
        int high = 1000000000;
        while(low < high){
            int mid = (low+high)/2;
            int k = 0;
            int last = 0;
            while(last < N){
                k++;
                int cur = last+1;
                while(cur < N && arr[cur]-arr[last] <= mid*2){
                    cur++;
                }
                last = cur;
            }
            if(k <= K){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        out.println(low);
        f.close();
        out.close();
    }
}
