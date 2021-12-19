import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static int solve(int[] arr) {
        int start = 0;
        int last = -1;
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                start = i+1;
            } else if(arr[i] == 0) {
                last = i;
            }
            if(last >= start) {
                ans += last-start+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] < 100) {
                    arr[i][j] = -1000;
                } else if(arr[i][j] > 100) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
                if(i > 0) {
                    arr[i][j] += arr[i-1][j];
                }
            }
        }
        long ans = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                int[] temp = new int[N];
                for(int k = 0; k < N; k++) {
                    temp[k] = arr[j][k]-(i == 0 ? 0 : arr[i-1][k]);
                    if(temp[k] < 0) {
                        temp[k] = -1;
                    } else if(temp[k] > j-i) {
                        temp[k] = 1;
                    } else {
                        temp[k] = 0;
                    }
                }
                ans += solve(temp);
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
