import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader f;
    private static int[] read(int n) throws IOException {
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        return a;
    }
    private static int[][] sort(int[] a) {
        Integer[] idx = new Integer[a.length];
        for(int i = 0; i < a.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return a[integer]-a[t1];
            }
        });
        int[][] res = new int[2][a.length];
        for(int i = 0; i < a.length; i++) {
            res[0][i] = idx[i];
            res[1][idx[i]] = i;
        }
        return res;
    }
    private static void solve(int[] a, int[] b, int[] map, ArrayList<Integer>[] invalid) {
        for(int i = 0; i < b.length; i++) {
            if(b[i] == Integer.MAX_VALUE) {
                continue;
            }
            Collections.sort(invalid[i]);
            int mex = 0;
            while(mex < invalid[i].size() && mex == invalid[i].get(mex)) {
                mex++;
            }
            if(mex == a.length || a[map[mex]] == Integer.MAX_VALUE) {
                b[i] = Integer.MAX_VALUE;
            } else {
                b[i] += a[map[mex]];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());
        int n4 = Integer.parseInt(st.nextToken());
        int[] a = read(n1);
        int[] b = read(n2);
        int[] c = read(n3);
        int[] d = read(n4);
        int[][] mapA = sort(a);
        int[][] mapD = sort(d);
        ArrayList<Integer>[] invalid1 = new ArrayList[n2];
        for(int i = 0; i < n2; i++) {
            invalid1[i] = new ArrayList<>();
        }
        int m1 = Integer.parseInt(f.readLine());
        for(int i = 0; i < m1; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            invalid1[y].add(mapA[1][x]);
        }
        ArrayList<Integer>[] invalid2 = new ArrayList[n3];
        for(int i = 0; i < n3; i++) {
            invalid2[i] = new ArrayList<>();
        }
        int m2 = Integer.parseInt(f.readLine());
        for(int i = 0; i < m2; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            invalid2[y].add(x);
        }
        ArrayList<Integer>[] invalid3 = new ArrayList[n3];
        for(int i = 0; i < n3; i++) {
            invalid3[i] = new ArrayList<>();
        }
        int m3 = Integer.parseInt(f.readLine());
        for(int i = 0; i < m3; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            invalid3[x].add(mapD[1][y]);
        }
        solve(a, b, mapA[0], invalid1);
        solve(d, c, mapD[0], invalid3);
        int[][] mapB = sort(b);
        for(ArrayList<Integer> i: invalid2) {
            for(int j = 0; j < i.size(); j++) {
                i.set(j, mapB[1][i.get(j)]);
            }
        }
        solve(b, c, mapB[0], invalid2);
        int min = Integer.MAX_VALUE;
        for(int i: c) {
            min = Math.min(min, i);
        }
        out.println(min == Integer.MAX_VALUE ? -1 : min);
        f.close();
        out.close();
    }
}
