import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        ArrayList<int[]> b = new ArrayList<>();
        b.add(new int[]{a[0], 1});
        for(int i = 1; i < n; i++) {
            if(a[i] == a[i-1]) {
                b.get(b.size()-1)[1]++;
            } else {
                b.add(new int[]{a[i], 1});
            }
        }
        long prev = k;
        int i;
        for(i = 0; i < b.size(); i++) {
            if(k <= 0) {
                break;
            }
            prev = k;
            k -= ((long) b.get(i)[1])*n;
        }
        i--;
        for(int j = 0; j < n; j++) {
            if(prev-b.get(i)[1] <= 0) {
                out.println(b.get(i)[0] + " " + a[j]);
                break;
            }
            prev -= b.get(i)[1];
        }
        f.close();
        out.close();
    }
}