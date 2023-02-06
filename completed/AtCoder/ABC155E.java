import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] N = f.readLine().toCharArray();
        int[] arr = new int[N.length+1];
        for(int i = 1; i <= N.length; i++) {
            arr[i] = N[i-1]-'0';
        }
        int ans = 0;
        for(int i = N.length; i > 0; i--) {
            if(arr[i] == 10) {
                arr[i-1]++;
            } else if(arr[i] > 5) {
                arr[i-1]++;
                ans += 10-arr[i];
            } else if(arr[i] == 5) {
                if(arr[i-1] >= 5) {
                    arr[i-1]++;
                }
                ans += 5;
            } else {
                ans += arr[i];
            }
        }
        ans += arr[0];
        out.println(ans);
        f.close();
        out.close();
    }
}
