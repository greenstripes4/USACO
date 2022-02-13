import java.io.*;
import java.util.*;

public class Main {
    private static int helper(ArrayList<int[]> points) {
        if(points.size() == 0) {
            return 0;
        }
        Collections.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1]-b[1];
            }
        });
        int end = points.get(0)[1];
        int cnt = 1;
        for(int[] i: points) {
            if(i[0] > end) {
                end = i[1];
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int x = Integer.parseInt(f.readLine());
            ArrayList<int[]> points = new ArrayList<>();
            for(int i = 0; i < n-1; i++) {
                if(a[i]+a[i+1] < 2*x) {
                    points.add(new int[]{i, i+1});
                }
            }
            for(int i = 0; i < n-2; i++) {
                if(a[i]+a[i+1]+a[i+2] < 3*x) {
                    points.add(new int[]{i, i+2});
                }
            }
            out.println(n-helper(points));
        }
        f.close();
        out.close();
    }
}
