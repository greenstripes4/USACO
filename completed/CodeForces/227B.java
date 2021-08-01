import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] pos = new int[n+1];
        for(int i = 0; i < n; i++) {
            pos[Integer.parseInt(st.nextToken())] = i;
        }
        int m = Integer.parseInt(f.readLine());
        st = new StringTokenizer(f.readLine());
        long front = 0;
        long end = 0;
        for(int i = 0; i < m; i++) {
            int b = Integer.parseInt(st.nextToken());
            front += pos[b]+1;
            end += n-pos[b];
        }
        out.println(front + " " + end);
        f.close();
        out.close();
    }
}