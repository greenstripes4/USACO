import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("snowboots.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[][] a = new int[N][2];
        for(int i = 0; i < N; i++) {
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = i;
        }
        int[][] b = new int[B][3];
        for(int i = 0; i < B; i++) {
            st = new StringTokenizer(f.readLine());
            b[i][0] = Integer.parseInt(st.nextToken());
            b[i][1] = Integer.parseInt(st.nextToken());
            b[i][2] = i;
        }
        Arrays.sort(b, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == 0 || o1[1] == N-1) {
                    return -1;
                }
                if(o2[1] == 0 || o2[1] == N-1) {
                    return 1;
                }
                return o1[0]-o2[0];
            }
        });
        int[] res = new int[B];
        TreeSet<Integer> set = new TreeSet<>();
        TreeMap<Integer, Integer> occ = new TreeMap<>();
        set.add(0);
        set.add(N-1);
        occ.put(N-1, 1);
        int idx = 2;
        for(int[] i: b) {
            while(idx < N && a[idx][0] <= i[0]) {
                int left = set.lower(a[idx][1]);
                int right = set.higher(a[idx][1]);
                occ.put(right-left, occ.get(right-left)-1);
                if(occ.get(right-left) == 0) {
                    occ.remove(right-left);
                }
                occ.put(a[idx][1]-left, occ.getOrDefault(a[idx][1]-left, 0)+1);
                occ.put(right-a[idx][1], occ.getOrDefault(right-a[idx][1], 0)+1);
                set.add(a[idx][1]);
                idx++;
            }
            if(occ.lastKey() <= i[1]) {
                res[i[2]] = 1;
            }
        }
        for(int i: res) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}