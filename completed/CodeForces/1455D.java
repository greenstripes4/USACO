import java.io.*;
import java.util.*;

public class Main {
    private static boolean isSorted(int[] a) {
        for(int i = 1; i < a.length; i++) {
            if(a[i] < a[i-1]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int ans = 0;
            while(!isSorted(a)) {
                for(int i = 0; i < n; i++) {
                    if(i > 0 && a[i] < a[i-1] && a[i] < x) {
                        ans = -1;
                        break;
                    }
                    if(a[i] > x) {
                        int temp = a[i];
                        a[i] = x;
                        x = temp;
                        ans++;
                        break;
                    }
                }
                if(ans == -1) {
                    break;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}