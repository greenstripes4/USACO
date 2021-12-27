import java.io.*;
import java.util.*;

public class Main {
    private static int floor(ArrayList<Integer> arr, int tar) {
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
    private static int solve(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(a.size() == 0) {
            return 0;
        }
        int[] suff = new int[a.size()+1];
        for(int i = a.size()-1; i >= 0; i--) {
            suff[i] = suff[i+1]+(Collections.binarySearch(b, a.get(i)) >= 0 ? 1 : 0);
        }
        int first = a.get(0);
        int size = 1;
        int ans = 0;
        for(int i = 0; i < b.size(); i++) {
            int cur = b.get(i);
            if(cur < first) {
                continue;
            }
            while(size < a.size() && a.get(size) <= cur+size) {
                size++;
            }
            ans = Math.max(ans, floor(b, cur+size-1)-i+1+suff[size]);
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            ArrayList<Integer> a1 = new ArrayList<>();
            ArrayList<Integer> a2 = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp < 0) {
                    a1.add(-temp);
                } else {
                    a2.add(temp);
                }
            }
            Collections.reverse(a1);
            st = new StringTokenizer(f.readLine());
            ArrayList<Integer> b1 = new ArrayList<>();
            ArrayList<Integer> b2 = new ArrayList<>();
            for(int i = 0; i < m; i++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp < 0) {
                    b1.add(-temp);
                } else {
                    b2.add(temp);
                }
            }
            Collections.reverse(b1);
            out.println(solve(a1, b1)+solve(a2, b2));
        }
        f.close();
        out.close();
    }
}
