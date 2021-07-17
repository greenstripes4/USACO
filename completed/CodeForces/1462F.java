import java.io.*;
import java.util.*;

public class Main {
    private static int lower(int[][] a, int t) {
        int l = 0;
        int h = a.length-1;
        int ans = -1;
        while(l <= h) {
            int m = (l+h)/2;
            if(a[m][1] < t) {
                l = m+1;
                ans = m;
            } else {
                h = m-1;
            }
        }
        return ans;
    }
    private static int higher(int[][] a, int t) {
        int l = 0;
        int h = a.length-1;
        int ans = a.length;
        while(l <= h) {
            int m = (l+h)/2;
            if(a[m][0] > t) {
                h = m-1;
                ans = m;
            } else {
                l = m+1;
            }
        }
        return ans;
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
            int[][] s = new int[n][2];
            int[][] e = new int[n][2];
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                s[i][0] = l;
                s[i][1] = r;
                e[i][0] = l;
                e[i][1] = r;
            }
            Arrays.sort(s, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[0]-t1[0];
                }
            });
            Arrays.sort(e, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[1]-t1[1];
                }
            });
            int min = n;
            for(int[] i: s) {
                min = Math.min(min, lower(e, i[0])+1+n-higher(s, i[1]));
            }
            out.println(min);
        }
        f.close();
        out.close();
    }
}