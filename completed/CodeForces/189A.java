import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int max = 0;
        for(int i = 0; a*i <= n; i++) {
            for(int j = 0; a*i+b*j <= n; j++) {
                int left = n-a*i-b*j;
                if(left%c == 0) {
                    max = Math.max(max, i+j+left/c);
                }
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}