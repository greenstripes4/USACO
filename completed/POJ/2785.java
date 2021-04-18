import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] arr = new int[4][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int cur = map.containsKey(arr[0][i]+arr[1][j]) ? map.get(arr[0][i]+arr[1][j]) : 0;
                map.put(arr[0][i]+arr[1][j], cur+1);
            }
        }
        long ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int val = map.containsKey(-arr[2][i]-arr[3][j]) ? map.get(-arr[2][i]-arr[3][j]) : 0;
                ans += val;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}