import java.io.*;
import java.util.*;

public class Main {
    private static boolean isValid(int[] c, int h, int K, int L) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int s = 0;
        for(int i = c.length-h; i < c.length && c[i] < h; i++) {
            queue.offer(h-c[i]);
            s += h-c[i];
        }
        while(!queue.isEmpty()) {
            L = queue.poll();
            s -= K*L;
        }
        return s <= 0;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] c = new int[N];
        for(int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(c);
        int low = 1;
        int high = N;
        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            if(isValid(c, mid, K, L)) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}