import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String> edges = new ArrayList<>();
        for(int i = 1; i <= n && edges.size() < m; i++) {
            for(int j = i+1; j <= n && edges.size() < m; j++) {
                if(gcd(i, j) == 1) {
                    edges.add(i + " " + j);
                }
            }
        }
        if(edges.size() < m || m < n-1) {
            out.println("Impossible");
        } else {
            out.println("Possible");
            for(int i = 0; i < m; i++) {
                out.println(edges.get(i));
            }
        }
        f.close();
        out.close();
    }
}
