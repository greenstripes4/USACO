import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            int[] m = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken())-1;
                m[a[i]] = i;
            }
            st = new StringTokenizer(f.readLine());
            int[] b = new int[n];
            for(int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken())-1;
            }
            boolean[] visited = new boolean[n];
            int count = 0;
            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    count++;
                    int j = i;
                    while(!visited[j]) {
                        visited[j] = true;
                        j = m[b[j]];
                    }
                }
            }
            int ans = 1;
            for(int i = 0; i < count; i++) {
                ans = (ans*2)%1000000007;
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}