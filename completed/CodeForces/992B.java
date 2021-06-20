import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        if(y%x != 0) {
            out.println(0);
        } else {
            int z = y/x;
            int ll = (l+x-1)/x;
            int rr = r/x;
            int ans = 0;
            for(int i = 1; i*i <= z; i++) {
                if(z%i == 0) {
                    int j = z/i;
                    if(i >= ll && j <= rr && gcd(i, j) == 1) {
                        ans++;
                        if(i != j) {
                            ans++;
                        }
                    }
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}