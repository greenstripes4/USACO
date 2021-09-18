import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        TreeSet<int[]> set1 = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(t1[1] == ints[1]) {
                    return ints[0]-t1[0];
                }
                return t1[1]-ints[1];
            }
        });
        TreeSet<int[]> set2 = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        int start = 0;
        for(int i = 1; i < n; i++) {
            if(a[i] != a[start]) {
                set1.add(new int[]{start, i-start});
                set2.add(new int[]{start, i-start});
                start = i;
            }
        }
        set1.add(new int[]{start, n-start});
        set2.add(new int[]{start, n-start});
        int ans = 0;
        while(!set1.isEmpty()) {
            ans++;
            int[] max = set1.first();
            set1.remove(max);
            int[] left = set2.lower(new int[]{max[0]});
            int[] right = set2.ceiling(new int[]{max[0]+max[1]});
            set2.remove(max);
            if(left != null && right != null && a[left[0]] == a[right[0]]) {
                set1.remove(left);
                set1.remove(right);
                set2.remove(left);
                set2.remove(right);
                set1.add(new int[]{left[0], left[1]+right[1]});
                set2.add(new int[]{left[0], left[1]+right[1]});
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}