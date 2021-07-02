import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int num = arr[0][0];
        long sum = 0;
        long ans = 0;
        int i = 0;
        while(i < n) {
            if(arr[i][0] == num) {
                queue.offer(arr[i][1]);
                sum += arr[i][1];
                i++;
            } else {
                sum -= queue.poll();
                ans += sum;
                if(queue.isEmpty()) {
                    num = arr[i][0];
                } else {
                    num++;
                }
            }
        }
        while(!queue.isEmpty()) {
            sum -= queue.poll();
            ans += sum;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}