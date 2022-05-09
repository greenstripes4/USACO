import java.io.*;
import java.util.*;

public class Main {
    private static String[] a;
    private static String[] b;
    private static boolean isValid(int l, int r) {
        HashSet<String> set = new HashSet<>();
        for(String i: a) {
            set.add(i.substring(l, r+1));
        }
        for(String i: b) {
            if(set.contains(i.substring(l, r+1))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cownomics.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        a = new String[N];
        for(int i = 0; i < N; i++) {
            a[i] = f.readLine();
        }
        b = new String[N];
        for(int i = 0; i < N; i++) {
            b[i] = f.readLine();
        }
        int i = 0;
        int j = 0;
        int ans = M;
        while(j < M) {
            if(isValid(i, j)) {
                ans = Math.min(ans, j-i+1);
                i++;
            } else {
                j++;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}