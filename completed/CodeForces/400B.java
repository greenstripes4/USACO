import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][];
        boolean[] contains = new boolean[m];
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            arr[i] = f.readLine().toCharArray();
            int pos = -1;
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 'S') {
                    if(pos < 0) {
                        flag = true;
                    } else {
                        contains[j-pos] = true;
                    }
                    break;
                }
                if(arr[i][j] == 'G') {
                    pos = j;
                }
            }
            if(flag) {
                break;
            }
        }
        if(flag) {
            out.println(-1);
        } else {
            int ans = 0;
            for(boolean i: contains) {
                if(i) {
                    ans++;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}