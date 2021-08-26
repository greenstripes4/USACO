import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Long> arr;
    private static void dfs(long cur, int pos, int nonZeroCount) {
        if(pos == 18) {
            arr.add(cur);
            return;
        }
        dfs(cur*10, pos+1, nonZeroCount);
        if(nonZeroCount < 3) {
            for(int i = 1; i < 10; i++) {
                dfs(cur*10+i, pos+1, nonZeroCount+1);
            }
        }
    }
    private static int floor(ArrayList<Long> arr, long tar) {
        int low = 0;
        int high = arr.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr.get(mid) <= tar) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static int ceil(ArrayList<Long> arr, long tar) {
        int low = 0;
        int high = arr.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr.get(mid) >= tar) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        arr = new ArrayList<>();
        dfs(0, 0, 0);
        arr.add(1000000000000000000L);
        Collections.sort(arr);
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long L = Long.parseLong(st.nextToken());
            long R = Long.parseLong(st.nextToken());
            out.println(floor(arr, R)-ceil(arr, L)+1);
        }
        f.close();
        out.close();
    }
}
