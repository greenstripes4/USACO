import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        char[] a = f.readLine().toCharArray();
        int val = 1;
        for(int i = 0; i < n; i++) {
            arr[i] = val*(a[n-i-1]-'0');
            val = (val*2)%998244353;
        }
        for(int i = 1; i < n; i++) {
            arr[i] = (arr[i-1]+arr[i])%998244353;
        }
        char[] b = f.readLine().toCharArray();
        int ans = 0;
        for(int i = 0; i < m; i++) {
            if(b[i] == '1') {
                ans = (ans+arr[Math.min(m-i-1, n-1)])%998244353;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
