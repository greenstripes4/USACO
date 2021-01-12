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
            int k = Integer.parseInt(st.nextToken());
            out.println(k%n == 0 ? 0 : 2);
            for(int j = 0; j < n; j++) {
                char[] temp = new char[n];
                Arrays.fill(temp, '0');
                for(int l = 0; l < k/n; l++) {
                    temp[(j+l)%n] = '1';
                }
                if(j < k%n) {
                    temp[(j+k/n)%n] = '1';
                }
                out.println(temp);
            }
        }
        f.close();
        out.close();
    }
}