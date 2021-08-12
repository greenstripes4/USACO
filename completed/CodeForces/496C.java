import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] s = new char[n][];
        for(int i = 0; i < n; i++) {
            s[i] = f.readLine().toCharArray();
        }
        int[] process = new int[n];
        int ans = 0;
        for(int j = 0; j < m; j++) {
            int[] temp = process.clone();
            boolean invalid = false;
            int id = 0;
            for(int i = 0; i < n; i++) {
                if(process[i] < 0) {
                    continue;
                }
                if(i > 0 && process[i-1] == process[i] && s[i][j] < s[i-1][j]) {
                    invalid = true;
                    break;
                }
                if((i == 0 || process[i-1] != process[i] || s[i][j] > s[i-1][j]) && (i == n-1 || process[i+1] != process[i] || s[i][j] < s[i+1][j])) {
                    temp[i] = -1;
                    continue;
                }
                if(i > 0 && s[i][j] != s[i-1][j]) {
                    id++;
                }
                temp[i] = id;
            }
            if(invalid) {
                ans++;
                continue;
            }
            process = temp;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
