import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(f.readLine());
            int[] arr = new int[n+1];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 1; j <= n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            for(int j = 1; j <= n; j++){
                max = Math.max(max,arr[j]-arr[j-1]);
            }
            int ans = max;
            for(int j = 1; j <= n; j++){
                int distance = arr[j]-arr[j-1];
                if(distance > max){
                    ans++;
                    break;
                } else if(distance == max){
                    max--;
                }
            }
            out.println("Case " + (i+1) + ": " + ans);
        }
        f.close();
        out.close();
    }
}
