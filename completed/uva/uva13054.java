import java.io.*;
import java.util.*;

public class Main{
    private static int binarySearch(int[] arr, int upperBound, int low, int high) {
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] < upperBound) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int C = Integer.parseInt(f.readLine());
        for(int t = 1; t <= C; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int Ta = Integer.parseInt(st.nextToken());
            int Td = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] elephants = new int[N];
            for(int i = 0; i < N; i++) {
                elephants[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(elephants);
            if(Ta*2 <= Td) {
                out.println("Case " + t + ": " + Ta*N);
            } else {
                boolean[] visited = new boolean[N];
                int high = N-1;
                int sum = 0;
                for(int i = 0; i < N; i++) {
                    if(visited[i]) {
                        continue;
                    }
                    visited[i] = true;
                    int temp = binarySearch(elephants, H-elephants[i], i+1, high);
                    if(temp >= 0) {
                        visited[temp] = true;
                    }
                    sum += temp == -1 ? Ta : Td;
                    high = temp-1;
                }
                out.println("Case " + t + ": " + sum);
            }
        }
        f.close();
        out.close();
    }
}
