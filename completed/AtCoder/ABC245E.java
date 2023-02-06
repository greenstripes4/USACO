import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] A = new int[N];
        Integer[] a = new Integer[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            a[i] = i;
        }
        st = new StringTokenizer(f.readLine());
        int[] B = new int[N];
        for(int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        int[] C = new int[M];
        Integer[] b = new Integer[M];
        for(int i = 0; i < M; i++) {
            C[i] = Integer.parseInt(st.nextToken());
            b[i] = i;
        }
        st = new StringTokenizer(f.readLine());
        int[] D = new int[M];
        for(int i = 0; i < M; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return A[o2]-A[o1];
            }
        });
        Arrays.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return C[o2]-C[o1];
            }
        });
        TreeMap<Integer, Integer> occ = new TreeMap<>();
        int j = 0;
        boolean flag = false;
        for(int i = 0; i < N; i++) {
            while(j < M && C[b[j]] >= A[a[i]]) {
                occ.put(D[b[j]], occ.getOrDefault(D[b[j]], 0)+1);
                j++;
            }
            Integer higher = occ.ceilingKey(B[a[i]]);
            if(higher == null) {
                flag = true;
                break;
            }
            occ.put(higher, occ.get(higher)-1);
            if(occ.get(higher) == 0) {
                occ.remove(higher);
            }
        }
        out.println(flag ? "No" : "Yes");
        f.close();
        out.close();
    }
}
