import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] mask = new int[10000001];
        for(int i = 1; i <= 10000000; i++) {
            mask[i] = i;
            for(int j = 2; j*j <= i; j++) {
                if(i%j == 0) {
                    int last = i/j;
                    if(mask[last]%j == 0) {
                        mask[i] = mask[last]/j;
                    } else {
                        mask[i] = mask[last]*j;
                    }
                    break;
                }
            }
        }
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = mask[Integer.parseInt(st.nextToken())];
            }
            HashSet<Integer> seen = new HashSet<>();
            int ans = 1;
            for(int i: a) {
                if(seen.contains(i)) {
                    seen.clear();
                    ans++;
                    seen.add(i);
                } else {
                    seen.add(i);
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}