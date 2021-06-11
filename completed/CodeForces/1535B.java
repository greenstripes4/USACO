import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
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
            ArrayList<Integer> even = new ArrayList<>();
            ArrayList<Integer> odd = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp%2 == 0) {
                    even.add(temp);
                } else {
                    odd.add(temp);
                }
            }
            int ans = 0;
            for(int i = 0; i < even.size(); i++) {
                ans += n-i-1;
            }
            for(int i = 0; i < odd.size(); i++) {
                for(int j = i+1; j < odd.size(); j++) {
                    if(gcd(odd.get(i), odd.get(j)) > 1) {
                        ans++;
                    }
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}