import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        int C = f.nextInt();
        int F = f.nextInt();
        int[][] cows = new int[C][2];
        for(int i = 0; i < C; i++) {
            cows[i][0] = f.nextInt();
            cows[i][1] = f.nextInt();
        }
        N /= 2;
        Arrays.sort(cows, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1-integer;
            }
        });
        int sum = 0;
        for(int i = 0; i < N; i++) {
            queue.offer(cows[i][1]);
            sum += cows[i][1];
        }
        int[] left = new int[C];
        for(int i = N; i < C-N; i++) {
            left[i] = sum;
            queue.offer(cows[i][1]);
            sum += cows[i][1];
            sum -= queue.poll();
        }
        queue.clear();
        sum = 0;
        for(int i = C-1; i >= C-N; i--) {
            queue.offer(cows[i][1]);
            sum += cows[i][1];
        }
        int[] right = new int[C];
        for(int i = C-N-1; i >= N; i--) {
            right[i] = sum;
            queue.offer(cows[i][1]);
            sum += cows[i][1];
            sum -= queue.poll();
        }
        int ans = -1;
        for(int i = C-N-1; i >= N; i--) {
            if(left[i]+cows[i][1]+right[i] <= F) {
                ans = cows[i][0];
                break;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}