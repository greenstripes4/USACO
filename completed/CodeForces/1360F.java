import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] a = new char[n][];
            for(int j = 0; j < n; j++) {
                a[j] = f.readLine().toCharArray();
            }
            boolean found = false;
            for(int j = 0; j < m; j++) {
                char original = a[0][j];
                for(int k = 0; k < 26; k++) {
                    a[0][j] = (char) ('a' + k);
                    boolean valid = true;
                    for(int l = 1; l < n; l++) {
                        int count = 0;
                        for(int o = 0; o < m; o++) {
                            if(a[0][o] != a[l][o]) {
                                count++;
                            }
                        }
                        if(count > 1) {
                            valid = false;
                            break;
                        }
                    }
                    if(valid) {
                        found = true;
                        out.println(a[0]);
                        break;
                    }
                }
                a[0][j] = original;
                if(found) {
                    break;
                }
            }
            if(!found) {
                out.println(-1);
            }
        }
        f.close();
        out.close();
    }
}