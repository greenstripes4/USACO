import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[4];
        for(int i = 0; i < 4; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        char[] s = f.readLine().toCharArray();
        int ans = 0;
        for(char i: s) {
            ans += a[i-'1'];
        }
        out.println(ans);
        f.close();
        out.close();
    }
}