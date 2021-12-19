import java.io.*;
import java.util.*;

public class Main {
    private static int floor(int[] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] <= tar) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static int ceil(ArrayList<int[]> arr, int tar, int coor) {
        int low = 0;
        int high = arr.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr.get(mid)[coor] >= tar) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] x = new int[n];
            for(int i = 0; i < n; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(f.readLine());
            int[] y = new int[m];
            for(int i = 0; i < m; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<int[]> horizontal = new ArrayList<>();
            ArrayList<int[]> vertical = new ArrayList<>();
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(f.readLine());
                int xp = Integer.parseInt(st.nextToken());
                int yp = Integer.parseInt(st.nextToken());
                int tempX = floor(x, xp);
                int tempY = floor(y, yp);
                if(tempX >= 0 && x[tempX] == xp && tempY >= 0 && y[tempY] == yp) {
                    continue;
                }
                if(tempX >= 0 && x[tempX] == xp) {
                    vertical.add(new int[]{xp, yp});
                } else {
                    horizontal.add(new int[]{xp, yp});
                }
            }
            Collections.sort(horizontal, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[0]-t1[0];
                }
            });
            Collections.sort(vertical, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[1]-t1[1];
                }
            });
            HashMap<Integer, Integer> occ = new HashMap<>();
            long ans = 0;
            int last = -2;
            for(int i = 0; i < horizontal.size(); i++) {
                int lower = floor(x, horizontal.get(i)[0]);
                if(lower != last) {
                    occ = new HashMap<>();
                }
                if(lower < 0) {
                    ans += i-occ.getOrDefault(horizontal.get(i)[1], 0);
                } else {
                    ans += i-ceil(horizontal, x[lower], 0)-occ.getOrDefault(horizontal.get(i)[1], 0);
                }
                occ.put(horizontal.get(i)[1], occ.getOrDefault(horizontal.get(i)[1], 0)+1);
                last = lower;
            }
            occ = new HashMap<>();
            last = -2;
            for(int i = 0; i < vertical.size(); i++) {
                int lower = floor(y, vertical.get(i)[1]);
                if(lower != last) {
                    occ.clear();
                }
                if(lower < 0) {
                    ans += i-occ.getOrDefault(vertical.get(i)[0], 0);
                } else {
                    ans += i-ceil(vertical, y[lower], 1)-occ.getOrDefault(vertical.get(i)[0], 0);
                }
                occ.put(vertical.get(i)[0], occ.getOrDefault(vertical.get(i)[0], 0)+1);
                last = lower;
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
