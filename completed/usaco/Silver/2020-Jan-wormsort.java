import java.io.*;
import java.util.*;

public class Main {
    private static int root(int[] parentIds, int X) {
        while(X != parentIds[X]) {
            parentIds[X] = parentIds[parentIds[X]];
            X = parentIds[X];
        }
        return X;
    }
    private static void union(int[] parentIds, int[] groupSizes, int X, int Y) {
        int rootX = root(parentIds, X);
        int rootY = root(parentIds, Y);
        if(groupSizes[rootX] < groupSizes[rootY]) {
            parentIds[rootX] = rootY;
            groupSizes[rootY] += groupSizes[rootX];
        } else {
            parentIds[rootY] = rootX;
            groupSizes[rootX] += groupSizes[rootY];
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("wormsort.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] p = new int[N];
        for(int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken())-1;
        }
        int[][] wormholes = new int[M][3];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            wormholes[i][0] = Integer.parseInt(st.nextToken())-1;
            wormholes[i][1] = Integer.parseInt(st.nextToken())-1;
            wormholes[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wormholes, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return t1[2]-ints[2];
            }
        });
        boolean isSorted = true;
        for(int i = 0; i < N; i++) {
            if(i != p[i]) {
                isSorted = false;
                break;
            }
        }
        int low = 0;
        int high = M-1;
        int ans = isSorted ? -1 : M-1;
        while(low <= high) {
            int mid = (low+high)/2;
            int[] parentIds = new int[N];
            int[] groupSizes = new int[N];
            for(int i = 0; i < N; i++) {
                parentIds[i] = i;
                groupSizes[i] = 1;
            }
            for(int i = 0; i <= mid; i++) {
                union(parentIds, groupSizes, wormholes[i][0], wormholes[i][1]);
            }
            boolean valid = true;
            for(int i = 0; i < N; i++) {
                if(root(parentIds, i) != root(parentIds, p[i])) {
                    valid = false;
                    break;
                }
            }
            if(valid) {
                high = mid-1;
                ans = Math.min(ans, mid);
            } else {
                low = mid+1;
            }
        }
        out.println(ans == -1 ? -1 : wormholes[ans][2]);
        f.close();
        out.close();
    }
}
