import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int pointer1 = 0;
        int pointer2 = 0;
        int max = 0;
        int sum = 0;
        while(pointer1 <= pointer2) {
            if(sum <= t) {
                max = Math.max(max, pointer2-pointer1);
                if(pointer2 == n) {
                    break;
                }
                sum += a[pointer2];
                pointer2++;
            } else {
                sum -= a[pointer1];
                pointer1++;
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}
