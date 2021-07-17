import java.io.*;
import java.util.*;

public class Main {
    private static long[] factorial;
    private static final int MOD = 998244353;
    private static int add(long a, long b) {
        return (int) (((a+MOD)%MOD+(b+MOD)%MOD)%MOD);
    }
    private static int subtract(long a, long b) {
        return add(a, -b);
    }
    private static int multiply(long a, long b) {
        return (int) ((a%MOD*b%MOD)%MOD);
    }
    private static int divide(long a, long b) {
        return multiply(a, modularInverse(b));
    }
    private static int modularInverse(long a) {
        return power(a, MOD-2);
    }
    private static int power(long a, long b) {
        long c = 1;
        while(b > 0) {
            if((b&1) > 0) {
                c = multiply(c, a);
            }
            a = multiply(a, a);
            b >>= 1;
        }
        return (int) c;
    }
    private static void calculateFactorials() {
        factorial[0] = 1;
        for(int i = 1; i < factorial.length; i++) {
            factorial[i] = multiply(factorial[i-1], i);
        }
    }
    private static int C(int n, int r) {
        if(r > n) {
            return 0;
        }
        return divide(factorial[n], multiply(factorial[r], factorial[n-r]));
    }
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
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        factorial = new long[n+1];
        calculateFactorials();
        HashMap<Integer, Integer> start = new HashMap<>();
        int[][] l = new int[n][2];
        int[][] r = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            l[i][0] = Integer.parseInt(st.nextToken());
            l[i][1] = Integer.parseInt(st.nextToken());
            r[i][0] = l[i][0];
            r[i][1] = l[i][1];
            start.put(l[i][0], start.getOrDefault(l[i][0], 0)+1);
        }
        Arrays.sort(l, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        Arrays.sort(r, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[1]-t1[1];
            }
        });
        int ans = 0;
        for(int i: start.keySet()) {
            int p = n-(lower(r, i)+1+n-higher(l, i));
            int s = start.get(i);
            ans = add(ans, subtract(C(p, k), C(p-s, k)));
        }
        out.println(ans);
        f.close();
        out.close();
    }
}