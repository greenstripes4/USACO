import java.io.*;
import java.util.*;

public class Main {
    private static int lower(ArrayList<Integer> arr, int tar) {
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
    private static int higher(ArrayList<Integer> arr, int tar) {
        int low = 0;
        int high = arr.size()-1;
        int ans = arr.size();
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
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            ArrayList<Integer> x = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                x.add(Integer.parseInt(st.nextToken()));
            }
            f.readLine();
            Collections.sort(x);
            int[] left = new int[n];
            left[0] = 0;
            for(int i = 1; i < n; i++) {
                left[i] = Math.max(left[i-1], i-higher(x, x.get(i-1)-k));
            }
            int ans = left[n-1]+1;
            int max = 1;
            for(int i = n-2; i >= 0; i--) {
                max = Math.max(max, lower(x, x.get(i)+k)-i+1);
                ans = Math.max(ans, left[i]+max);
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}